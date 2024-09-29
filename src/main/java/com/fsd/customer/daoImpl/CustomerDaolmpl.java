package com.fsd.customer.daoImpl;

import com.fsd.customer.dao.CustomerDao;
import com.fsd.customer.entity.UserEntity;
import com.fsd.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaolmpl implements CustomerDao {

    @Autowired
    CustomerRepository repository;


    @Override
    public UserEntity getUserbyMobile(Long mobile) {
        return repository.findByMobileAndIsActive(mobile,1);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return repository.saveAndFlush(userEntity);
    }
}