package com.query_executor.connection;

import lombok.*;

import javax.sql.DataSource;
import java.sql.SQLException;

@Getter
public abstract class AbstractConnection {

    /**
     * -- GETTER --
     *  Return the DataSource to execute queries
     */
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
     * Close connection pool if applicable
     */
    public abstract void close();
}
