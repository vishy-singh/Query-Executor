package com.query_executor.exception;

public class QueryExecutorException extends RuntimeException {

    public QueryExecutorException(String message) {
        super(message);
    }

    public QueryExecutorException(String message, Throwable cause) {
        super(message, cause);
    }
}
