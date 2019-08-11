package com.kd.serwisAukcyjny.user;

import com.kd.serwisAukcyjny.bought.Bought;
import com.kd.serwisAukcyjny.during.During;
import com.kd.serwisAukcyjny.exposed.Exposed;
import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.expression.Lists;


import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Getter
@Setter
@Entity
@DiscriminatorValue("C")
public class Customer extends User {
    boolean premium;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Bought> boughtList = newArrayList();
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<During> duringList = newArrayList();
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Exposed> exposedList = newArrayList();
}
