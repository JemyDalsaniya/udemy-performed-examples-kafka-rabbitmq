package com.spring.employeeservice.service;

import com.spring.employeeservice.dto.APIResponseDto;
import com.spring.employeeservice.dto.DepartmentDto;
import com.spring.employeeservice.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/departments/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable String departmentCode);
}
