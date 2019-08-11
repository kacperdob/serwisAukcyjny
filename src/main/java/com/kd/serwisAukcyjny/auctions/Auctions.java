package com.kd.serwisAukcyjny.auctions;

import com.kd.serwisAukcyjny.BaseEntity;
import com.kd.serwisAukcyjny.auction.Auction;
import com.kd.serwisAukcyjny.user.User;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Auctions extends BaseEntity {
//    user id
//    auction id
//            customer id
    @ManyToOne
    @JoinColumn(name="auction_Id")
    private Auction auction;

    @OneToOne
    @JoinColumn(name="user_Id")
    private User user;

}
