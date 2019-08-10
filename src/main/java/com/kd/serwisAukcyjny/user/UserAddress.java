package com.kd.serwisAukcyjny.user;


import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
    private String voivodeship;
    private String city;
    private String street;
    private String zipCode;
    private String homeNumber;
    private String flatNumber;


}
