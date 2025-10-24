package com.query_executor.controller;


import com.query_executor.facade.*;
import com.query_executor.utils.dto.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * REST controller for handling query execution and connection management endpoints.
 * <p>
 * This controller exposes endpoints for creating database connections and executing SQL queries.
 * <ul>
 *     <li>Delegates connection creation to {@link ConnectionFacade}.</li>
 *     <li>Provides a placeholder for query execution logic.</li>
 * </ul>
 *
 * <b>Endpoints:</b>
 * <ul>
 *     <li><b>POST /query-executor/createConnection</b>: Creates a new database connection.</li>
 *     <li><b>POST /query-executor/executeQuery</b>: Executes a SQL query (to be implemented).</li>
 * </ul>
 */
@RestController
@RequestMapping("query-executor")
@AllArgsConstructor
public class QueryExecutoryController {

    /**
     * Facade for connection management operations.
     */
    @Autowired
    private final ConnectionFacade connectionFacade;

    /**
     * Executes a SQL query using the provided request data.
     * <p>
     * <b>Note:</b> This method is a placeholder and should be implemented to delegate query execution to the appropriate facade or service.
     *
     * @param dto the request containing the query and connection ID
     * @return the result of the query execution (currently returns null)
     */
    public String executeQuery(@RequestBody QueryExecutorRequestDto dto){
        // TODO: Implement query execution logic
        return null;
    }

    /**
     * Creates a new database connection using the provided connection details.
     *
     * @param dto the connection details
     */
    public void createConnection(@RequestBody ConnectionDto dto){
        connectionFacade.createConnection(dto);
    }
}
