package com.spring.employeeservice.service;

import com.spring.employeeservice.dto.APIResponseDto;
import com.spring.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}
