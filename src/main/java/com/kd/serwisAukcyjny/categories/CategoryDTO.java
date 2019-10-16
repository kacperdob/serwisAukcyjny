package com.kd.serwisAukcyjny.categories;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private Long id;
    private Long parentId;
    private Integer depth;
    private String name;
    private CategoryDTO parentCat;
    private CategoryState state;

    public String getText(){
        return id + ". " + name;
    }
    public String getParent(){
        return parentId == null ? "#" : parentId.toString();
    }
}
