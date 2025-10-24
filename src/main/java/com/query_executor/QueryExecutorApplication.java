package com.query_executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Query Executor Spring Boot application.
 * <p>
 * This class bootstraps the Spring application context and starts the embedded server.
 * <ul>
 *     <li>Uses {@link SpringBootApplication} to enable component scanning, auto-configuration, and configuration properties support.</li>
 *     <li>Runs the application using {@link SpringApplication#run(Class, String...)}.</li>
 * </ul>
 *
 * <b>Usage:</b>
 * <pre>
 *     java -jar query-executor.jar
 * </pre>
 */
@SpringBootApplication
public class QueryExecutorApplication {
    /**
     * Main method to launch the Spring Boot application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(QueryExecutorApplication.class, args);
    }
}
