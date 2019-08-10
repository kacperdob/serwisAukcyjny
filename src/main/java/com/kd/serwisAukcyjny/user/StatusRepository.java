package com.kd.serwisAukcyjny.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Role,Long> {
    @Query("SELECT s FROM Status s WHERE s.statusName =?1")
    Role findStatusByStatusName(String statusName);
}
