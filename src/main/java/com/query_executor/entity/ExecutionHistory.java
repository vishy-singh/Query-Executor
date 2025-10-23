package com.query_executor.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

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
