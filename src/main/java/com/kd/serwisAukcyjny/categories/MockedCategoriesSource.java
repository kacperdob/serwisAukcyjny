package com.kd.serwisAukcyjny.categories;


import com.google.common.io.Resources;
import lombok.Getter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
public class MockedCategoriesSource {
    private static MockedCategoriesSource instance;

    private List<Category> mockedCategories;

    public static MockedCategoriesSource getInstance(){
        if (instance == null){
            synchronized (MockedCategoriesSource.class){
                if (instance == null){
                    instance = new MockedCategoriesSource();
                }
            }
        }
        return instance;
    }
    private MockedCategoriesSource() {
        mockedCategories = initializeCategories();
    }

    private List<Category> initializeCategories() {
        try {
            List<String> strings = Resources.readLines(Resources.getResource("kategorie.txt"), Charset.forName("UNICODE"));
            List<Category> categories = new ArrayList<>();

            int counter = 1;
            for (String line : strings) {
                Category category = Category.builder()
                        .name(line.trim())
                        .depth(calculatedDepth(line))
                        .build();
                category.setId((long) counter++);
                categories.add(category);
            }

            Map<Integer, List<Category>> categoryMap = new HashMap<>();
            for (Category category : categories) {
                if (categoryMap.containsKey(category.getDepth())) {
                    categoryMap.get(category.getDepth()).add(category);
                } else {
                    List<Category> cats = new ArrayList<>();
                    cats.add(category);
                    categoryMap.put(category.getDepth(), cats);
                }
            }
            populateParentID(categoryMap, 0);
            return categories;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void populateParentID(Map<Integer, List<Category>> categoryMap, Integer depth) {
        if (!categoryMap.containsKey(depth)) {
            return;
        }
        List<Category> children = categoryMap.get(depth);
        for (Category child : children) {
            if (depth != 0) {
                List<Category> potentialParents = categoryMap.get(depth - 1);
                long parentID = 0;
                for (Category potentialParent : potentialParents) {
                    if (potentialParent.getId() < child.getId() && parentID < potentialParent.getId()) {
                        parentID = potentialParent.getId();
                    }
                }
                if (parentID == 0) {
                    throw new RuntimeException();
                }
                child.setParentId(parentID);
            }
        }
        populateParentID(categoryMap, ++depth);
    }

    private int calculatedDepth(String line){
        if (line.startsWith(" ") || line.startsWith("\t")){
            return line.split("\\S")[0].length();
        }
        return 0;
    }
}
