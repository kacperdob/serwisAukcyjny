package com.kd.serwisAukcyjny.categories;

import com.kd.serwisAukcyjny.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Category extends BaseEntity {

}
