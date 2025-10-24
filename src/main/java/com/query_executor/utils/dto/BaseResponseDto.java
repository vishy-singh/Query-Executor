package com.query_executor.utils.dto;

import lombok.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

/**
 * Generic response DTO for API responses.
 * <p>
 * This class is used to standardize the structure of API responses throughout the application.
 * It encapsulates a message, HTTP status, and a generic data payload.
 * <ul>
 *     <li>message: A human-readable message describing the response.</li>
 *     <li>status: The HTTP status code associated with the response.</li>
 *     <li>data: The actual response data, which can be of any type.</li>
 * </ul>
 *
 * <b>Usage Example:</b>
 * <pre>
 *     BaseResponseDto&lt;UserDto&gt; response = BaseResponseDto.&lt;UserDto&gt;builder()
 *         .message("User fetched successfully")
 *         .status(HttpStatus.OK)
 *         .data(userDto)
 *         .build();
 * </pre>
 *
 * @param <T> the type of the response data
 */
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
