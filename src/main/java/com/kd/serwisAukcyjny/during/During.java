package com.kd.serwisAukcyjny.during;

import com.kd.serwisAukcyjny.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class During extends BaseEntity {
}
