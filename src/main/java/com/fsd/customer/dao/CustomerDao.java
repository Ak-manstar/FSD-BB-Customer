package com.fsd.customer.dao;

import com.fsd.customer.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public interface CustomerDao {

    //methods to declare crud operations

    UserEntity getUserbyUserId(String userId);
    UserEntity saveUser(UserEntity userEntity);
    UserEntity getUserByMobile(Long mobile);
}