package com.kd.serwisAukcyjny;

import com.google.common.collect.Sets;
import com.kd.serwisAukcyjny.categories.CategoryRepository;
import com.kd.serwisAukcyjny.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MockData {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository<Customer> usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void mockData(){
        if(categoryRepository.checkSize() == 0){
            categoryRepository.initializeCategories();
        }
        if (!usersRepository.existsByName("user@user.pl")) {

            Role role = roleRepository.findRoleByRoleName(RoleTypeEnum.USER.getRoleName());
            if (role == null) {
                role = roleRepository.save(new Role(RoleTypeEnum.USER.getRoleName()));
            }
            Customer customer = new Customer();
            usersRepository.save(customer);
            customer.setName("user@user.pl");
            customer.setPassword(passwordEncoder.encode("user12345"));
            customer.setRoles(Sets.newHashSet(role));
            customer.setFirstName("Imię");
            customer.setLastName("Nazwisko");
            customer.setUserAddress(UserAddress.builder()
                    .zipCode("01-000")
                    .street("Kaczyńskiego")
                    .city("Łódź")
                    .voivodeship("Lubelskie")
                    .homeNumber("3")
                    .flatNumber("12")
                    .build());
            usersRepository.save(customer);

        }
    }
}
