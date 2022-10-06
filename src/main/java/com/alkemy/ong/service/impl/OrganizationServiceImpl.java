package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationDTO;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.mapper.OrganizationMapper;
import com.alkemy.ong.model.Organization;
import com.alkemy.ong.repository.OrganizationRepository;
import com.alkemy.ong.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;

    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public OrganizationDTO getById(Long id) {
        Optional<Organization> org = organizationRepository.findById(id);
        if(!org.isPresent()){
            throw new ParamNotFound("Id no valido");
        }
        return organizationMapper.orgRedes2DTO(org.get());
    }

    @Override
    public List<OrganizationDTO> getOrganizationBasic() {
        List<Organization> organization = organizationRepository.findAll();
        return organizationMapper.listOrg2listOrgDTO(organization);
    }

    @Override
    public OrganizationDTO getOrganizationBasic2() {
        return null;
    }

    // TODO: returns the last created data
    @Override
    public OrganizationBasicDTO getOrganizationBasic3() {
        Organization organization = organizationRepository.findFirstByOrderByCreationDateDesc();
        return organizationMapper.organizationToOrganizationBasicDTO(organization);
    }

    @Override
    public OrganizationBasicDTO save(OrganizationBasicDTO dto) {
        Organization org = organizationMapper.organizationBasicDTO2Organization(dto);
        Organization orgSave = organizationRepository.save(org);
        return organizationMapper.organizationToOrganizationBasicDTO(orgSave);
    }



}
