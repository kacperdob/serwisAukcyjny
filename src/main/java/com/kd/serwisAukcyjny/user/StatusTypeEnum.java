package com.kd.serwisAukcyjny.user;

import lombok.Getter;

@Getter
public enum StatusTypeEnum {
    ACTIVE("STATUS_ACTIVE"), DISACTIVE("STATUS_DISACTIVE"), BANNED("STATUS_BANNED");

    private String statusName;

    StatusTypeEnum(String statusName) {
        this.statusName = statusName;
    }
}
