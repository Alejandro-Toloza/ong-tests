package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationDTO;
import com.alkemy.ong.model.Organization;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationBasicDTO organizationToOrganizationBasicDTO(Organization entity);
    Organization organizationBasicDTO2Organization(OrganizationBasicDTO dto);
    List<OrganizationDTO> listOrg2listOrgDTO(List<Organization> organizationList);

    OrganizationDTO orgRedes2DTO(Organization organization);

    Organization orgDTO2OrgRedes(OrganizationDTO organizationDTO);

}
