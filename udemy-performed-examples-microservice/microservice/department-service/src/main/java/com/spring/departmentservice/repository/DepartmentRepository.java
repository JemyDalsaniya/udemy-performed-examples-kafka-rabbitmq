package com.spring.departmentservice.repository;

import com.spring.departmentservice.dto.DepartmentDto;
import com.spring.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String code);
}
