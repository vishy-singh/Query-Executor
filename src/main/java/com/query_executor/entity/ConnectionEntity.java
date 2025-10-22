package com.query_executor.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Data
@Entity
@Table(name = "connection_entity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "u_id")
    private UUID id;

    @Column(name = "s_host")
    private String host;

    @Column(name = "n_port")
    private int port;

    @Column(name = "s_port")
    private String database;

    @Column(name = "s_username")
    private String username;

    @Column(name = "s_password")
    private String password;

    @Column(name = "s_schema")
    private String schema;

    @Column(name = "s_db_type")
    private String dbType;

    @Column(name = "dt_created_at")
    @Builder.Default
    private Instant createdAt = Instant.now();


}
