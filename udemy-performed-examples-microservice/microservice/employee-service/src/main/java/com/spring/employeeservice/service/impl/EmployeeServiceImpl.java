package com.spring.employeeservice.service.impl;

import com.spring.employeeservice.dto.APIResponseDto;
import com.spring.employeeservice.dto.DepartmentDto;
import com.spring.employeeservice.dto.EmployeeDto;
import com.spring.employeeservice.dto.OrganizationDto;
import com.spring.employeeservice.entity.Employee;
import com.spring.employeeservice.mapper.EmployeeMapper;
import com.spring.employeeservice.repository.EmployeeRepository;
import com.spring.employeeservice.service.APIClient;
import com.spring.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.xml.validation.Validator;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;

    private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    //    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long id) {

        logger.info("getEmployeeById method");
        Optional<Employee> employee = employeeRepository.findById(id);


        EmployeeDto employeeDto = null;
        DepartmentDto departmentDto = null;
        OrganizationDto organizationDto = null;
        if (employee.isPresent()) {

            //Communication using RestTemplate

//            ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.get().getDepartmentCode(), DepartmentDto.class);
//            departmentDto = responseEntity.getBody();

            //Communication using WebClient

            departmentDto = webClient.get()
                    .uri("http://localhost:8080/api/departments/" + employee.get().getDepartmentCode())
                    .retrieve()
                    .bodyToMono(DepartmentDto.class)
                    .block();

            organizationDto = webClient.get()
                    .uri("http://localhost:8083/api/organizations/" + employee.get().getOrganizationCode())
                    .retrieve()
                    .bodyToMono(OrganizationDto.class)
                    .block();

            //Communication using OpenFeign Client

//            departmentDto = apiClient.getDepartment(employee.get().getDepartmentCode());

            employeeDto = EmployeeMapper.mapToEmployeeDto(employee.get());

        }

        APIResponseDto apiResponseDto = new APIResponseDto(
                employeeDto,
                departmentDto,
                organizationDto
        );
        return apiResponseDto;
    }

//    public APIResponseDto getDefaultDepartment(Long id, Exception exception) {
//
//        logger.info("getDefaultDepartment METHOD");
//        Optional<Employee> employee = employeeRepository.findById(id);
//
//
//        EmployeeDto employeeDto = null;
//        APIResponseDto apiResponseDto = null;
//        DepartmentDto departmentDto = new DepartmentDto();
//        departmentDto.setDepartmentName("R&D Department");
//        departmentDto.setDepartmentDescription("Research & Development");
//        departmentDto.setDepartmentCode("RD001");
//
//        if (employee.isPresent()) {
//
//            employeeDto = EmployeeMapper.mapToEmployeeDto(employee.get());
//
//            apiResponseDto = new APIResponseDto();
//            apiResponseDto.setEmployeeDto(employeeDto);
//            apiResponseDto.setDepartmentDto(departmentDto);
//        }
//        return apiResponseDto;
//    }
    public APIResponseDto getDefaultDepartment(Long id, Exception exception) {

        logger.info("getDefault Organization METHOD");
        Optional<Employee> employee = employeeRepository.findById(id);


        EmployeeDto employeeDto = null;
        APIResponseDto apiResponseDto = null;
        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setOrganizationName("Tridhya Tech");
        organizationDto.setOrganizationDescription("Liferay Department");
        organizationDto.setOrganizationCode("LR001");

        if (employee.isPresent()) {

            employeeDto = EmployeeMapper.mapToEmployeeDto(employee.get());

            apiResponseDto = new APIResponseDto();
            apiResponseDto.setEmployeeDto(employeeDto);
            apiResponseDto.setOrganizationDto(organizationDto);
        }
        return apiResponseDto;
    }
}
