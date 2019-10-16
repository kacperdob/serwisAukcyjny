package com.kd.serwisAukcyjny.auction;

import lombok.Getter;

@Getter
public enum AuctionType {
    NORMAL("zwykła"), PREMIUM("premium");
    String type;

    AuctionType(String type) {
        this.type = type;
    }
}
