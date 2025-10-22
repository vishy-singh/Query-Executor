package com.query_executor.utils.dto;

import lombok.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

@Data
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDto<T> {
    private String message;
    private HttpStatus status;
    private T data;
}
