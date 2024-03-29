package com.kd.serwisAukcyjny.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FilterOutCategoryService extends CategoryService {
    @Autowired
    public FilterOutCategoryService (CategoryRepository categoryRepository){
        super(categoryRepository);
    }
    public List<CategoryDTO> filterCategories (String searchText) {
        Map<Long, CategoryDTO> dtoMap = getCategories().stream()
                .collect(Collectors.toMap(k -> k.getId(), v -> v));
        return dtoMap.values().stream()
                .peek(dto -> dto.setParentCat(dtoMap.get(dto.getParentId())))
                .map(dto -> populateStateAndOpenParents(dto, searchText))
                .filter(e -> e.getState().isOpened())
                .collect(Collectors.toList());
    }
}
