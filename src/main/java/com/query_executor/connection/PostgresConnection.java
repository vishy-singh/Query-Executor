package com.query_executor.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresConnection extends AbstractConnection {

    @Override
    public void initialize(String host, int port, String database, String username, String password, String schema) {
        HikariConfig config = new HikariConfig();

        // Set the JDBC URL with the schema
        String url = String.format(
                "jdbc:postgresql://%s:%d/%s?currentSchema=%s",
                host, port, database, schema
        );
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setPoolName("ClientDBPool");

        this.dataSource = new HikariDataSource(config);
    }

    @Override
    public void validate() throws SQLException {
        try (Connection conn = dataSource.getConnection()) {

            // Fetch the current schema from connection
            String currentSchema;
            try (PreparedStatement stmt = conn.prepareStatement("SELECT current_schema()")) {
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        currentSchema = rs.getString(1);
                    } else {
                        throw new SQLException("Could not determine current schema.");
                    }
                }
            }

            // Ensure schema exists (optional, extra safety)
            String schemaQuery = "SELECT schema_name FROM information_schema.schemata WHERE schema_name = ?";
            try (PreparedStatement stmt = conn.prepareStatement(schemaQuery)) {
                stmt.setString(1, currentSchema);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (!rs.next()) {
                        throw new SQLException("Schema '" + currentSchema + "' does not exist or is not accessible by the user.");
                    }
                }
            }

            // Check SELECT permission for all tables in the schema
            String tablePermQuery = "SELECT table_name FROM information_schema.tables WHERE table_schema = ?";
            try (PreparedStatement stmt = conn.prepareStatement(tablePermQuery)) {
                stmt.setString(1, currentSchema);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String table = rs.getString("table_name");
                        String permCheck = "SELECT has_table_privilege(current_user, ?, 'SELECT')";
                        try (PreparedStatement permStmt = conn.prepareStatement(permCheck)) {
                            permStmt.setString(1, table);
                            try (ResultSet permRs = permStmt.executeQuery()) {
                                if (permRs.next() && !permRs.getBoolean(1)) {
                                    throw new SQLException("User does not have SELECT permission on table: " + table);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void close() {
        if (dataSource instanceof HikariDataSource) {
            ((HikariDataSource) dataSource).close();
        }
    }
}