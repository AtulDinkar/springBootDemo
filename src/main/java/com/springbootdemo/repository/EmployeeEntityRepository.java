package com.springbootdemo.repository;

import com.springbootdemo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, String> {
}
