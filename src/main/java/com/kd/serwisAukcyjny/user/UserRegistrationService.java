package com.kd.serwisAukcyjny.user;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserRegistrationService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsersRepository<Customer> usersRepository;

    public void registerUser(CustomerRegistrationDto customerRegistrationDto) {
        Customer user = UserRegistrationDtoToUserBuilder.rewriteToCustomer(customerRegistrationDto, passwordEncoder);
        if (usersRepository.existsByName(user.getName())) {
            throw new UserExistException("User with username " + user.getName() + "already exists in database");
        } else {
            addUser(user);
        }
    }

    private void addUser(Customer user) {
        Role roleUser = Optional.ofNullable(roleRepository.findRoleByRoleName("ROLE_USER"))
                .orElseGet(() -> roleRepository.save(new Role(RoleTypeEnum.USER.getRoleName())));
        user.setRoles(Sets.newHashSet(roleUser));
        usersRepository.save(user);
    }
}
