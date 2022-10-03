package com.alkemy.ong.controller;

import com.alkemy.ong.dto.CategoryDTO;
import com.alkemy.ong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll(){
        List<CategoryDTO> dtoList = categoryService.getAll();
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO dto){
        CategoryDTO dtoSave = categoryService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoSave);
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryDTO> save2(@RequestBody CategoryDTO dto){
        CategoryDTO dtoSave = categoryService.save2(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto){
        CategoryDTO dtoUpdate = categoryService.update(id,dto);
        return ResponseEntity.ok().body(dtoUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDTO> deleted(@PathVariable Long id){
        this.categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id){
        CategoryDTO categoryDTO = categoryService.getId(id);
        return ResponseEntity.ok().body(categoryDTO);
    }


}
