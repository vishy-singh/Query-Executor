package com.query_executor.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

/**
 * Entity representing the execution history of SQL queries.
 * <p>
 * This class maps to the <b>execution_history</b> table in the database and stores details about each query execution event.
 * <ul>
 *     <li><b>id</b>: Unique identifier for the execution history record (UUID).</li>
 *     <li><b>connectionId</b>: The UUID of the database connection used for the query.</li>
 *     <li><b>query</b>: The SQL query that was executed.</li>
 *     <li><b>executedAt</b>: The timestamp when the query was executed.</li>
 *     <li><b>responseMetaData</b>: Metadata or summary about the query response (e.g., status, row count, error info).</li>
 * </ul>
 *
 * <b>Usage Example:</b>
 * <pre>
 *     ExecutionHistory history = new ExecutionHistory();
 *     history.setConnectionId(connectionId);
 *     history.setQuery("SELECT * FROM users");
 *     history.setExecutedAt(Instant.now());
 *     history.setResponseMetaData("Success: 10 rows");
 * </pre>
 */
@Data
@Entity
@Table(name = "execution_history")
public class ExecutionHistory {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "u_id")
    private UUID id;

    @Column(name = "u_connection_id")
    private UUID connectionId;

    @Column(name = "s_query")
    private String query;

    @Column(name = "dt_executed_at")
    private Instant executedAt;

    @Column(name = "s_response_meta_data")
    private String responseMetaData;
}
