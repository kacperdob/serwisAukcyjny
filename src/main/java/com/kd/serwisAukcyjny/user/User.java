package com.kd.serwisAukcyjny.user;

import com.kd.serwisAukcyjny.BaseEntity;
import com.kd.serwisAukcyjny.DataBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //sposób dziedziczenia
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String password;
    private String name;
    private UserAddress userAddress;
    private DataBuilder createAccountDate;
    private String pesel;
    private String birthDate;
    private String phone;

    @ManyToMany
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "user_role")
    private Set<Role> roles;

    @ManyToMany
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "user_status")
    private Set<Status> status;

}
