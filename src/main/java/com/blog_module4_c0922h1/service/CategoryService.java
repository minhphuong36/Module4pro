package com.blog_module4_c0922h1.service;

import com.blog_module4_c0922h1.model.Category;
import com.blog_module4_c0922h1.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    ICategoryRepo iCategoryRepo;

    public List<Category> getAll(){
        return (List<Category>) iCategoryRepo.findAll();
    }
}
