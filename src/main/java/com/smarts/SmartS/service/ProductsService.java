package com.smarts.SmartS.service;

import com.smarts.SmartS.model.Products;
import com.smarts.SmartS.repository.ProductsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductsService {
    private ProductsRepository productsRepository;
    public ProductsService (ProductsRepository productsRepository) {
        this.productsRepository=productsRepository;
    }
    public void save(Products products) {
        productsRepository.save(products);
    }

    public List<Products> listAllProducts() {
        return productsRepository.findAll();
    }

    public Products get(Integer id) {
        return productsRepository.findById(id).get();
    }
    public void delete(Integer id) {
        productsRepository.deleteById(id);
    }
}
