package com.kd.serwisAukcyjny.bought;

import com.kd.serwisAukcyjny.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Bought extends BaseEntity {
}
