package com.consumers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumers.model.ObjectData;

@Repository
public interface ObjectDataRepository extends JpaRepository<ObjectData, Integer> {
    
}
