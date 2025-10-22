package com.query_executor.utils.dto;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.*;

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
