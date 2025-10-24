package com.query_executor.utils.dto;


import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Data Transfer Object (DTO) for executing SQL queries.
 * <p>
 * This class encapsulates the information required to execute a query against a specific database connection.
 * <ul>
 *     <li>query: The SQL query string to be executed.</li>
 *     <li>connectionId: The unique identifier of the database connection to use for execution.</li>
 * </ul>
 *
 * <b>Usage Example:</b>
 * <pre>
 *     QueryExecutorRequestDto request = new QueryExecutorRequestDto();
 *     request.setQuery("SELECT * FROM users");
 *     request.setConnectionId(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));
 * </pre>
 */
@Data
@Component
public class QueryExecutorRequestDto {
    private String query;
    private UUID connectionId;
}
