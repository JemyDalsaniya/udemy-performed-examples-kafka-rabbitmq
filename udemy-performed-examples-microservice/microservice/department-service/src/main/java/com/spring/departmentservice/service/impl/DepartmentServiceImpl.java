package com.spring.departmentservice.service.impl;

import com.spring.departmentservice.controller.DepartmentController;
import com.spring.departmentservice.dto.DepartmentDto;
import com.spring.departmentservice.entity.Department;
import com.spring.departmentservice.mapper.DepartmentMapper;
import com.spring.departmentservice.repository.DepartmentRepository;
import com.spring.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {


    DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);


        Department saveDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
