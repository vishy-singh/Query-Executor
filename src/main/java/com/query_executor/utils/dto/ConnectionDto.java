package com.query_executor.utils.dto;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.*;

/**
 * Data Transfer Object (DTO) for database connection details.
 * <p>
 * This class encapsulates all necessary information required to establish a connection to a database.
 * It is used to transfer connection parameters between client, controller, and service layers.
 * <ul>
 *     <li>host: The hostname or IP address of the database server.</li>
 *     <li>port: The port number on which the database server is listening.</li>
 *     <li>database: The name of the target database.</li>
 *     <li>username: The username for database authentication.</li>
 *     <li>password: The password for database authentication.</li>
 *     <li>schema: The schema to use within the database (if applicable).</li>
 *     <li>dbType: The type of the database (e.g., POSTGRES, MYSQL).</li>
 * </ul>
 *
 * <b>Usage Example:</b>
 * <pre>
 *     ConnectionDto dto = new ConnectionDto();
 *     dto.setHost("localhost");
 *     dto.setPort(5432);
 *     dto.setDatabase("mydb");
 *     dto.setUsername("user");
 *     dto.setPassword("pass");
 *     dto.setSchema("public");
 *     dto.setDbType("POSTGRES");
 * </pre>
 */
@Data
@Component
public class ConnectionDto {
    private String host;

    private int port;

    private String database;

    private String username;

    private String password;

    private String schema;

    private String dbType;
}
