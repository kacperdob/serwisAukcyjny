package com.kd.serwisAukcyjny.auction;

import com.kd.serwisAukcyjny.categories.Category;
import com.kd.serwisAukcyjny.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Auction {
    private String title;
    private String description;
    private BigDecimal minPrice;
    private BigDecimal buyNowPrice;
    private boolean promote;
@ManyToOne
    private User user;
@ManyToOne
    private Category category;


}
