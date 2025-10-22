package com.query_executor.dao;

import com.query_executor.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;


@Repository
public interface ConnectionDao extends JpaRepository<ConnectionEntity, UUID> {

}
