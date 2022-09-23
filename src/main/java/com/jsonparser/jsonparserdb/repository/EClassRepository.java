package com.jsonparser.jsonparserdb.repository;

import com.jsonparser.jsonparserdb.entity.EClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EClassRepository extends JpaRepository<EClassEntity,Long> {
}
