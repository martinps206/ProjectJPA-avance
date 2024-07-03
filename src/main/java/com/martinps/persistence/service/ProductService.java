package com.martinps.persistence.service;

import com.martinps.persistence.entity.Product;
import com.martinps.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product>  findAll(){
        return productRepository.findAll();
    }

    public List<Product> findAll(Specification<Product> specification){
        return productRepository.findAll(specification);
    }

    public List<Product> findAll(Example example){
        return productRepository.findAll(example);
    }

    public List<Product> findAllByNameContainingIgnoreCaseAndPriceLessThanEqualAndPriceGreaterThanEqualAndCategoryNameContainingIgnoreCase(String name, BigDecimal minPrice, BigDecimal maxPrice, String categoryName){
        return productRepository.findAllByNameContainingIgnoreCaseAndPriceLessThanEqualAndPriceGreaterThanEqualAndCategoryNameContainingIgnoreCase(name, maxPrice, minPrice, categoryName);
    }

    public List<Product> findAllByNameContainingIgnoreCase(String name){
        return productRepository.findAllByNameContainingIgnoreCase(name);
    }

    public List<Product> findAllByNameContainingIgnoreCaseAndCategoryNameContainingIgnoreCase(String name, String categoryName){
        return productRepository.findAllByNameContainingIgnoreCaseAndCategoryNameContainingIgnoreCase(name, categoryName);
    }

    public List<Product> findAllByNameContainingIgnoreCaseAndCategoryNameIgnoreCaseAndPriceGreaterThanEqual(String name, String categoryName, BigDecimal minPrice){
        return productRepository.findAllByNameContainingIgnoreCaseAndCategoryNameIgnoreCaseAndPriceGreaterThanEqual(name, categoryName, minPrice);
    }

    public List<Product> findAllByNameContainingIgnoreCaseAndCategoryNameIgnoreCaseAndPriceLessThanEqual(String name, String categoryName, BigDecimal maxPrice){
        return productRepository.findAllByNameContainingIgnoreCaseAndCategoryNameIgnoreCaseAndPriceLessThanEqual(name, categoryName, maxPrice);
    }

}
