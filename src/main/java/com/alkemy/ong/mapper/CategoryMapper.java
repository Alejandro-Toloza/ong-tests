package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.CategoryDTO;
import com.alkemy.ong.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    public Category categorDTO2Entity(CategoryDTO dto){
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category.setImage(dto.getImage());
        category.setCreationDate(dto.getCreationDate());
        category.setUpdateDate(dto.getUpdateDate());
        return category;
    }

    public CategoryDTO category2DTO(Category category){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setCreationDate(category.getCreationDate());
        dto.setUpdateDate(category.getUpdateDate());
        dto.setImage(category.getImage());
        return dto;
    }

    public List<CategoryDTO> categoryList2DTO(List<Category> categoryList){
        List<CategoryDTO> dtoList = new ArrayList<>();
        for(Category category : categoryList){
            dtoList.add(category2DTO(category));
        }
        return dtoList;
    }

    public void refreshValues(Category category, CategoryDTO dto){
        category.setName(dto.getName());
        category.setImage(dto.getImage());
        category.setCreationDate(dto.getCreationDate());
        category.setUpdateDate(dto.getUpdateDate());
        category.setDescription(dto.getDescription());
    }


}
