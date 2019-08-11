package com.kd.serwisAukcyjny.user;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRegistrationDtoToUserBuilder {

    public static Customer rewriteToCustomer(CustomerRegistrationDto dto, PasswordEncoder passwordEncoder) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName().trim());
        customer.setLastName(dto.getLastName().trim());
        customer.setPassword(passwordEncoder.encode(dto.getPassword().trim()));
        customer.setName(dto.getEmail().trim());
        customer.setPesel(dto.getPesel().trim());
        customer.setBirthDate(dto.getBirthDate().trim());
        customer.setPhone(dto.getPhone().trim());
        customer.setUserAddress(UserAddress.builder()
                .street(dto.getStreet().trim())
                .city(dto.getCity().trim())
                .voivodeship(dto.getVoivodeship().trim())
                .zipCode(dto.getZipCode().trim())
                .homeNumber(dto.getHomeNumber().trim())
                .flatNumber(dto.getFlatNumber().trim())
                .build());
        return customer;
    }

}
