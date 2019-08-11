package com.kd.serwisAukcyjny.cart;


import com.kd.serwisAukcyjny.BaseEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cart extends BaseEntity {

}
