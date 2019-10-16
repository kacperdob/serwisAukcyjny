package com.kd.serwisAukcyjny.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminCategoriesController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String cats (Model model, @RequestParam(required = false) String searchText) {
        List<CategoryDTO> categoryDTOList = categoryService.filterCategories((searchText));
        model.addAttribute("catsdata", categoryDTOList);
        return "categories";
    }
    @PostMapping("/categories/moveCat")
    @ResponseBody
    public void moveCat(@RequestParam(required = true) String oldParentId, @RequestParam(required = true) String newParentId, @RequestParam(required = true) String movedId) {
        categoryService.moveCategory(newParentId, movedId);
    }

    @GetMapping("/category")
    public String addCategoryForm() {
        return "addCategory";
    }

    @PostMapping("/category")
    public String addCategory(@RequestParam String catName,@RequestParam Long parentId) {
        categoryService.addCategory(catName, parentId);
        return  "redirect:/admin/categories";
    }
}
