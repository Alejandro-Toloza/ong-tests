package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.CategoryDTO;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.mapper.CategoryMapper;
import com.alkemy.ong.mapper.ICategoryMapper;
import com.alkemy.ong.model.Category;
import com.alkemy.ong.repository.CategoryRepository;
import com.alkemy.ong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ICategoryMapper icatMapper;

    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDTO> dtoList = categoryMapper.categoryList2DTO(categoryList);
        return dtoList;
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        Category category = categoryMapper.categorDTO2Entity(dto);
        Category saveCategory = categoryRepository.save(category);
        CategoryDTO dtoResult = categoryMapper.category2DTO(saveCategory);
        return dtoResult;
    }

    //TODO: METODO USANDO MAPSTRUCKT - FUNCIONA
    @Override
    public CategoryDTO save2(CategoryDTO dto) {
        Category category = icatMapper.categoryDTOToCategory(dto);
        Category saveCategory = categoryRepository.save(category);
        CategoryDTO result = icatMapper.categoryToCategoryDTO(saveCategory);
        return result;
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO dto) {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()){
            throw new ParamNotFound("Id no valido");
        }
        categoryMapper.refreshValues(category.get(),dto);
        Category categorySave = categoryRepository.save(category.get());
        CategoryDTO category2dto = categoryMapper.category2DTO(categorySave);
        return category2dto;
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDTO getId(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        CategoryDTO dto = categoryMapper.category2DTO(category.get());
        return dto;
    }


}
