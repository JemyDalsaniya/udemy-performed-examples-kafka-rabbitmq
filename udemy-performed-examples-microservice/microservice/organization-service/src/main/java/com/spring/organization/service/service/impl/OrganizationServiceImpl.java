package com.spring.organization.service.service.impl;

import com.spring.organization.service.dto.OrganizationDto;
import com.spring.organization.service.entity.Organization;
import com.spring.organization.service.mapper.OrganizationMapper;
import com.spring.organization.service.repository.OrganizationRepository;
import com.spring.organization.service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization= organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization savedOrganizationDto = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(savedOrganizationDto);
    }
}
