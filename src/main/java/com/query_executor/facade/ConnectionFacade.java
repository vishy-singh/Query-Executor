package com.query_executor.facade;


import com.query_executor.connection.*;
import com.query_executor.dao.*;
import com.query_executor.entity.*;
import com.query_executor.utils.dto.*;
import lombok.*;
import lombok.extern.log4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.sql.*;


@Log4j2
@Service
@AllArgsConstructor
public class ConnectionFacade {

    private final ConnectionDao dao;

    /**
     * Creates a new database connection using the provided connection details.
     * <p>
     * This method performs the following steps:
     * <ol>
     *     <li>Initializes a {@link PostgresConnection} instance with the connection details from the {@link ConnectionDto}.</li>
     *     <li>Validates the connection parameters by attempting to connect to the database.</li>
     *     <li>If the connection is successful, saves the connection details to the database using {@link ConnectionDao}.</li>
     *     <li>Logs the status of the connection and handles any exceptions that may occur during the process.</li>
     *     <li>Ensures that the database connection is properly closed in all cases.</li>
     * </ol>
     *
     * @param dto the {@link ConnectionDto} containing the connection parameters such as host, port, database, username, password, and schema
     * @throws RuntimeException if validation or saving the connection fails
     */
    public void createConnection(@RequestBody ConnectionDto dto) {

        PostgresConnection pgConn = new PostgresConnection();
        try {
            pgConn.initialize(dto.getHost(),
                    dto.getPort(),
                    dto.getDatabase(),
                    dto.getUsername(),
                    dto.getPassword(),
                    dto.getSchema());

            pgConn.validate();

            try (Connection conn = pgConn.getDataSource().getConnection()) {
                log.info("Connected and validated! Ready to execute queries.");


                dao.save(
                        ConnectionEntity.builder()
                                .host(dto.getHost())
                                .port(dto.getPort())
                                .database(dto.getDatabase())
                                .username(dto.getUsername())
                                .password(dto.getPassword())
                                .schema(dto.getSchema())
                                .build()
                );


            }

        } catch (Exception e) {

            log.error("Validation failed: " + e.getMessage());
        } finally {
            pgConn.close();
        }
    }


}
