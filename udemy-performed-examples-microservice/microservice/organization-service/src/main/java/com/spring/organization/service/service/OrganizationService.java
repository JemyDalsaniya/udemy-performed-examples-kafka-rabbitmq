package com.spring.organization.service.service;

import com.spring.organization.service.dto.OrganizationDto;
import org.springframework.http.ResponseEntity;

public interface OrganizationService {


     OrganizationDto saveOrganization(OrganizationDto organizationDto);

     OrganizationDto getOrganizationByCode(String organizationCode);


}
