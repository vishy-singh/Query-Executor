package com.query_executor.facade;


import com.query_executor.connection.*;
import com.query_executor.dao.*;
import com.query_executor.entity.*;
import com.query_executor.utils.dto.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@Service
@AllArgsConstructor
public class ConnectionFacade {

    private final ConnectionDao dao;

    public void CreateConnection(@RequestBody ConnectionDto dto) {

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
                System.out.println("Connected and validated! Ready to execute queries.");

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
            System.err.println("Validation failed: " + e.getMessage());
        } finally {
            pgConn.close(); // Close the pool
        }
    }


}
