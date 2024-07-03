package com.martinps.persistence.service;

import com.martinps.persistence.entity.Category;
import com.martinps.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public List<Category> findAll(Specification<Category> specification){
        return categoryRepository.findAll(specification);
    }


}
