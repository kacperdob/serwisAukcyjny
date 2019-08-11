package com.kd.serwisAukcyjny.auction;

import com.kd.serwisAukcyjny.BaseEntity;
import com.kd.serwisAukcyjny.auctions.Auctions;
import com.kd.serwisAukcyjny.categories.Category;
import com.kd.serwisAukcyjny.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Auction extends BaseEntity {
    private String title;
    private String description;
    private BigDecimal minPrice;
    private BigDecimal buyNowPrice;
    private boolean promote;
@OneToMany
    private List<Auctions> auctions;
//@ManyToOne
//    private Category category;


}
