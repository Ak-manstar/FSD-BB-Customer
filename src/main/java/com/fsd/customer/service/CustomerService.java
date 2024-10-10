package com.fsd.customer.service;

import com.fsd.customer.bean.LoginResponse;
import com.fsd.customer.bean.SignUpResponse;
import com.fsd.customer.bean.UserLoginRequest;
import com.fsd.customer.bean.UserSignUpRequest;
import com.fsd.customer.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public interface CustomerService {

    SignUpResponse userSignUp(UserSignUpRequest userSignUpRequest);
    LoginResponse userLogin(UserLoginRequest userLoginRequest);
    UserEntity getUserDetails(String userId);

}