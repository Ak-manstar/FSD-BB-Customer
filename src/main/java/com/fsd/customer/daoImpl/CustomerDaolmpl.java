package com.fsd.customer.daoImpl;

import com.fsd.customer.dao.CustomerDao;
import com.fsd.customer.entity.UserEntity;
import com.fsd.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaolmpl implements CustomerDao {

    @Autowired
    CustomerRepository repository;


    @Override
    public UserEntity getUserbyUserId(String userId) {
        return repository.findByUserIdAndIsActive(userId,1);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {

        return repository.saveAndFlush(userEntity);
    }

    @Override
    public UserEntity getUserByMobile(Long mobile) {
        return repository.findUserByMobileAndIsActive(mobile,1);
    }
}