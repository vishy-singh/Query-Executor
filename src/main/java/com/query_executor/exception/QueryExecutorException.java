package com.query_executor.exception;

/**
 * Custom exception for errors occurring in the Query Executor application.
 * <p>
 * This exception is used to signal application-specific errors that occur during query execution or related operations.
 * It extends {@link RuntimeException}, allowing it to be thrown without being declared in a method's {@code throws} clause.
 * <ul>
 *     <li>Supports exception chaining by accepting a cause.</li>
 *     <li>Can be used to provide meaningful error messages to the user or for logging purposes.</li>
 * </ul>
 *
 * <b>Usage Example:</b>
 * <pre>
 *     throw new QueryExecutorException("Failed to execute query");
 *     throw new QueryExecutorException("Database error", cause);
 * </pre>
 */
public class QueryExecutorException extends RuntimeException {

    public QueryExecutorException(String message) {
        super(message);
    }

    public QueryExecutorException(String message, Throwable cause) {
        super(message, cause);
    }
}
