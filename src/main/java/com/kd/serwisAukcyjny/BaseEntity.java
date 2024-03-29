package com.kd.serwisAukcyjny;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
@EqualsAndHashCode
public class BaseEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
}
