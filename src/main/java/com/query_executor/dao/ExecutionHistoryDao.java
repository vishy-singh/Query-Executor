package com.query_executor.dao;

import com.query_executor.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

/**
 * Repository interface for managing {@link ExecutionHistory} persistence.
 * <p>
 * Extends {@link JpaRepository} to provide CRUD operations and query methods for ExecutionHistory entities.
 * <ul>
 *     <li>Supports saving, updating, deleting, and finding execution history records by their UUID.</li>
 *     <li>Can be extended with custom query methods as needed.</li>
 * </ul>
 *
 * <b>Usage Example:</b>
 * <pre>
 *     List<ExecutionHistory> allHistory = executionHistoryDao.findAll();
 *     Optional<ExecutionHistory> history = executionHistoryDao.findById(uuid);
 * </pre>
 */
public interface ExecutionHistoryDao extends JpaRepository<ExecutionHistory, UUID> {
}
