package com.fsd.customer.repository;

import com.fsd.customer.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByMobileAndIsActive(Long mobile, int i);
}