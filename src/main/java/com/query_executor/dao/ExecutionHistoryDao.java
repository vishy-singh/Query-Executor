package com.query_executor.dao;

import com.query_executor.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface ExecutionHistoryDao extends JpaRepository<ExecutionHistory, UUID> {
}
