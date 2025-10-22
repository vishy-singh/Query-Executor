package com.query_executor.utils.dto;


import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;


@Data
@Component
public class QueryExecutorRequestDto {
    private String query;
    private UUID connectionId;
}
