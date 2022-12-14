package com.alkemy.ong.controller;


import com.alkemy.ong.dto.ActivityDTO;
import com.alkemy.ong.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDTO> getId (@Valid @PathVariable Long id){
        ActivityDTO dto = activityService.getId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ActivityDTO> saveActivity (@Valid @RequestBody ActivityDTO dto){
        ActivityDTO savedActivity = activityService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedActivity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody ActivityDTO dto) {
        ActivityDTO activityDTO = activityService.update(id, dto);
        return ResponseEntity.ok().body(activityDTO);
    }





}