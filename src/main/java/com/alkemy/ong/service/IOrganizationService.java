package com.alkemy.ong.service;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationDTO;

import java.util.List;

public interface IOrganizationService {
    OrganizationDTO getById(Long id);
    List<OrganizationDTO> getOrganizationBasic();
    //TODO: returns the last created data
    OrganizationDTO getOrganizationBasic2();
    OrganizationBasicDTO save(OrganizationBasicDTO dto);
    OrganizationBasicDTO getOrganizationBasic3();


}
