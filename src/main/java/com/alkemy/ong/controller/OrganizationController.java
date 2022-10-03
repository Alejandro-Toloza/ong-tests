package com.alkemy.ong.controller;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationDTO;
import com.alkemy.ong.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organization")
public class OrganizationController {

    @Autowired
    IOrganizationService organizationService;

    @GetMapping("/public2")
    public ResponseEntity<List<OrganizationDTO>> getOrganizationBasic() {
        return ResponseEntity.ok(organizationService.getOrganizationBasic());
    }

    @GetMapping("/public/{id}")
    public ResponseEntity<OrganizationDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.getById(id));
    }
    //TODO: returns the last created data
    @GetMapping("/public")
    public ResponseEntity<OrganizationBasicDTO> getOrganizationBasic2() {
        return ResponseEntity.ok(organizationService.getOrganizationBasic3());

    }

    @PostMapping
    public ResponseEntity<OrganizationBasicDTO> save(@RequestBody OrganizationBasicDTO dto) {
        OrganizationBasicDTO saveDto = organizationService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveDto);
    }


}
