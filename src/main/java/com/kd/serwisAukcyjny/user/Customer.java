package com.kd.serwisAukcyjny.user;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("C")
public class Customer extends User {
    boolean premium;

}
