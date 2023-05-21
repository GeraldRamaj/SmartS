package com.smarts.SmartS.service;

import com.smarts.SmartS.model.Category;
import com.smarts.SmartS.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
private CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listAllCategory() {
        return categoryRepository.findAll();
    }

    public void save(Category category){
        categoryRepository.save(category);
}

    public Category get(Integer id) {
        return categoryRepository.findById(id).get();
}

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
}
}
