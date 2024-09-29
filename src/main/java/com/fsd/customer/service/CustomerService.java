package com.fsd.customer.service;

import com.fsd.customer.bean.SignUpResponse;
import com.fsd.customer.bean.UserLoginRequest;
import com.fsd.customer.bean.UserSignUpRequest;
import org.springframework.stereotype.Component;

@Component
public interface CustomerService {

    SignUpResponse userSignUp(UserSignUpRequest userSignUpRequest);
    String userLogin(UserLoginRequest userLoginRequest);
//  This response bean need to be changed
    UserSignUpRequest getUserDetails(String mobile);

}