package com.martinps.web.controller;

import com.martinps.persistence.entity.Category;
import com.martinps.persistence.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/v0")
    public List<Category> findAllv0(){
        return categoryService.findAll();
    }

    @GetMapping("/v1")
    public List<Category> findAllv1(){

        Specification<Category> categoryWithoutProductsSpecification = (root, query, criteriaBuilder) -> {
            return criteriaBuilder.isEmpty(root.get("products"));
        };

        return categoryService.findAll(categoryWithoutProductsSpecification);
    }
}
