package com.smarts.SmartS.repository;

import com.smarts.SmartS.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
