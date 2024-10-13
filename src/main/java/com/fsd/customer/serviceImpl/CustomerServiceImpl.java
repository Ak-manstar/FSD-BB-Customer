package com.fsd.customer.serviceImpl;

import com.fsd.customer.bean.*;
import com.fsd.customer.client.VendorClient;
import com.fsd.customer.dao.CustomerDao;
import com.fsd.customer.entity.UserEntity;
import com.fsd.customer.exception.CustomerException;
import com.fsd.customer.helper.CustomerHashUtils;
import com.fsd.customer.helper.MapperUtil;
import com.fsd.customer.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    VendorClient vendorClient;


    @Override
    @Transactional
    public SignUpResponse userSignUp(UserSignUpRequest userSignUpRequest) {
        String userId= userSignUpRequest.getRole().substring(0,2)+CustomerHashUtils.getId();
        UserEntity userEntity=new UserEntity(userId,userSignUpRequest.getUserName(),userSignUpRequest.getPassword(),userSignUpRequest.getEmail(),userSignUpRequest.getMobile(),userSignUpRequest.getRole());
        if(userSignUpRequest.getRole().equals("VENDOR")){
            RegisterVendorRequestBean registerVendorRequestBean= MapperUtil.getRegisterVendorRequestBean(userSignUpRequest,userId);
            vendorClient.registerVendor(registerVendorRequestBean);
        }
        if(null!= customerDao.saveUser(userEntity)) {
            return new SignUpResponse(userId, "Registered Successfully");
        }else {
            throw new CustomerException(new ErrorBean("CU_001","Not Registered"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public LoginResponse userLogin(UserLoginRequest userLoginRequest) {
        UserEntity userEntity=customerDao.getUserByMobile(userLoginRequest.getMobile());
        LoginResponse loginResponse=new LoginResponse();
        if(userEntity.getPassword().equals(userLoginRequest.getPassword())){
            loginResponse.setUserId(userEntity.getUserId());
            loginResponse.setRole(userEntity.getRole());
            loginResponse.setMessage("Login Successful");
        }
        else
            loginResponse.setMessage("Login Failed");
        return loginResponse;
    }

    @Override
    public UserEntity getUserDetails(String userId) {
        return customerDao.getUserbyUserId(userId);
    }
}