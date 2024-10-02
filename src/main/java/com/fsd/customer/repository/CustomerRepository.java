package com.fsd.customer.repository;

import com.fsd.customer.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUserIdAndIsActive(String userId, int i);

    UserEntity findUserByMobileAndIsActive(Long mobile, int i);
}