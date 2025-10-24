package com.query_executor.dao;

import com.query_executor.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Repository interface for managing {@link ConnectionEntity} persistence.
 * <p>
 * Extends {@link JpaRepository} to provide CRUD operations and query methods for ConnectionEntity objects.
 * <ul>
 *     <li>Supports saving, updating, deleting, and finding connections by their UUID.</li>
 *     <li>Can be extended with custom query methods as needed.</li>
 * </ul>
 *
 * <b>Usage Example:</b>
 * <pre>
 *     List<ConnectionEntity> allConnections = connectionDao.findAll();
 *     Optional<ConnectionEntity> connection = connectionDao.findById(uuid);
 * </pre>
 */
@Repository
public interface ConnectionDao extends JpaRepository<ConnectionEntity, UUID> {

}
