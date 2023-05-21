package com.smarts.SmartS.controller;

import com.smarts.SmartS.model.Category;
import com.smarts.SmartS.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CategoryController {
private CategoryService categoryService;

public CategoryController (CategoryService categoryService)
{
    this.categoryService=categoryService;
}

@GetMapping("/categories")
    public String listKategorite(Model model) {
    List<Category> listKategorite = categoryService.listAllCategory();
    model.addAttribute("listKategorite", listKategorite);
    return "kategori";
}

@RequestMapping("/categories/new")
    public String showCategoryNewForm(Model model) {
    Category category = new Category();
    model.addAttribute("category", category);
    return "kategori_form";
}

@RequestMapping(value = "/categories/save", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);

        return "redirect:/categories";
    }

    @RequestMapping("/categories/edit/{id}")
    public ModelAndView showEditCategoriesPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("ndrysho_kategori");
        Category category = categoryService.get(id);
        mav.addObject("category", category);

        return mav;
    }

    @RequestMapping("/categories/delete/{id}")
    public String deleteCategories(@PathVariable(name = "id") int id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }

}
