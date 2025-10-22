package com.query_executor.connection;

import javax.sql.DataSource;
import java.sql.SQLException;

public abstract class AbstractConnection {

    protected DataSource dataSource;

    /**
     * Initialize connection pool with client credentials
     */
    public abstract void initialize(String host, int port, String database, String username, String password, String schema) throws SQLException;

    /**
     * Validate schema and permissions
     */
    public abstract void validate() throws SQLException;

    /**
     * Return the DataSource to execute queries
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * Close connection pool if applicable
     */
    public abstract void close();
}
