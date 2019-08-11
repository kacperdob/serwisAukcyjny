package com.kd.serwisAukcyjny.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository<T extends User>  extends JpaRepository<T, Long> {

    Optional<T> findByName(String name);

    boolean existsByName(String name);
}
