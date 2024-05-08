package com.spring.organization.service.controller;

import com.spring.organization.service.dto.OrganizationDto;
import com.spring.organization.service.mapper.OrganizationMapper;
import com.spring.organization.service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {

    public OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        return new ResponseEntity<>(organizationService.saveOrganization(organizationDto), HttpStatus.CREATED);
    }

    @GetMapping("{organizationCode}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String organizationCode){
        return new ResponseEntity<>(organizationService.getOrganizationByCode(organizationCode), HttpStatus.OK);
    }

}
