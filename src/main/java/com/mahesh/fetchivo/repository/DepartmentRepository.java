package com.mahesh.fetchivo.repository;

import com.mahesh.fetchivo.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}