package com.smarts.SmartS.controller;

import com.smarts.SmartS.model.Category;
import com.smarts.SmartS.model.Products;
import com.smarts.SmartS.service.CategoryService;
import com.smarts.SmartS.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/products/new")
    public String showProductsIRPage(Model model) {
        List<Category> listCategory =categoryService.listAllCategory();
        Products products = new Products();
        model.addAttribute("products", products);
        model.addAttribute("listCategory", listCategory);

        return "product_form";
    }

    @RequestMapping(value = "/products/saveProducts", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("products") Products products) {
        productsService.save(products);

        return "redirect:/products";
    }

    @GetMapping("/products")
    public String viewListaProductsPage(Model model) {
        List<Products> listProducts = productsService.listAllProducts();
        model.addAttribute("products", listProducts);

        return "listproducts";
    }

    @RequestMapping("products/edit/{id}")
    public ModelAndView showEditProductsPage(@PathVariable(name = "id") int id, Model model) {
        ModelAndView mav = new ModelAndView("ndrysho_product");
        List<Category> listaCategories = categoryService.listAllCategory();
        Products products = productsService.get(id);

        mav.addObject("products", products);
        model.addAttribute("listaCategories", listaCategories);

        return mav;
    }

    @RequestMapping("/products/delete/{id}")
    public String deleteProducts(@PathVariable(name = "id") int id) {
        productsService.delete(id);
        return "redirect:/listaProducts";
    }

}
