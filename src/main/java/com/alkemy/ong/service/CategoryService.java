package com.alkemy.ong.service;


import com.alkemy.ong.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAll();
    CategoryDTO save(CategoryDTO dto);
    CategoryDTO save2(CategoryDTO dto);
    CategoryDTO update(Long id, CategoryDTO dto);
    void delete(Long id);
    CategoryDTO getId(Long id);
}
