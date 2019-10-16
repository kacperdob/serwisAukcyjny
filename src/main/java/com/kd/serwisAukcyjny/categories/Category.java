package com.kd.serwisAukcyjny.categories;

import com.kd.serwisAukcyjny.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Category extends BaseEntity {

    private Long parentId;
    private Integer depth;
    @Column(length = 300)
    private String name;

    public Category(Long parentId, String name) {
        this.parentId = parentId;
        this.name = name;
    }
}
