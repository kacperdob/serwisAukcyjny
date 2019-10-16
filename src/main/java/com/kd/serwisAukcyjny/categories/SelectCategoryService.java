package com.kd.serwisAukcyjny.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Primary
public class SelectCategoryService extends CategoryService {

    @Autowired
    public SelectCategoryService(CategoryRepository categoryRepository){
        super(categoryRepository);
    }
    public List<CategoryDTO> filterCategories(String searchText) {
        Map<Long, CategoryDTO> dtoMap = getCategories().stream()
                .collect(Collectors.toMap(k -> k.getId(), v -> v));

        List<CategoryDTO> collect = dtoMap.values().stream()
                .peek(dto -> dto.setParentCat(dtoMap.get(dto.getParentId())))
                .map(dto -> populateStateAndOpenParents(dto, searchText))
                .collect(Collectors.toList());
        return collect;
    }
}
