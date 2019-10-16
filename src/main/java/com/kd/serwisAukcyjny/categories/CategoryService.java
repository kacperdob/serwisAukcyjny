package com.kd.serwisAukcyjny.categories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public abstract List<CategoryDTO> filterCategories(String searchText);

    protected CategoryDTO buildCategoryDTO (Category c){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(c.getId());
        categoryDTO.setParentId(c.getParentId());
        categoryDTO.setName(c.getName());
        categoryDTO.setDepth(c.getDepth());
        categoryDTO.setState(new CategoryState());
        return categoryDTO;
    }
    public Optional<Category> getCategoryById(Long movedId) {
        return categoryRepository.findCategoryById(movedId);
    }
    public List<CategoryDTO> getCategories(){
        List<Category> categoryList = categoryRepository.getCategories();
return categoryList.stream()
        .map(c -> buildCategoryDTO(c)).collect(Collectors.toList());
    }
    public void moveCategory(String newParentId, String movedId) {
        Category movedCategory = getCategoryById(Long.valueOf(movedId)).get();
        movedCategory.setParentId(Long.valueOf(newParentId));
        categoryRepository.updateCategory(movedCategory);
    }

    public void addCategory(String catName, Long parentId){
        categoryRepository.save(new Category(parentId == 0 ? null : parentId, catName));
    }
    protected CategoryDTO populateStateAndOpenParents(CategoryDTO dto, String searchText) {
        if (searchText != null && dto.getName().equals(searchText.trim())) {
            dto.getState().setOpened(true);
            dto.getState().setSelected(true);
            openParent(dto);
        }
        return dto;
    }
    protected void openParent(CategoryDTO child) {
        CategoryDTO parentCat = child.getParentCat();
        if (parentCat == null) {
            return;
        }
        parentCat.getState().setOpened(true);
        openParent(parentCat);
    }

}
