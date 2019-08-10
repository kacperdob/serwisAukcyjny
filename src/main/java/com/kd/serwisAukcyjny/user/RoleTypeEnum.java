package com.kd.serwisAukcyjny.user;

import lombok.Getter;

@Getter
public enum RoleTypeEnum {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN"), PREMIUM("ROLE_PREMIUM");

    private String roleName;

    RoleTypeEnum(String roleName) {
        this.roleName = roleName;
    }
}
