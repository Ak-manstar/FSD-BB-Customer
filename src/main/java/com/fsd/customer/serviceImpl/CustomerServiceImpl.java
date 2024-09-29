package com.fsd.customer.serviceImpl;

import com.fsd.customer.bean.ErrorBean;
import com.fsd.customer.bean.SignUpResponse;
import com.fsd.customer.bean.UserLoginRequest;
import com.fsd.customer.bean.UserSignUpRequest;
import com.fsd.customer.client.TemplateClient;
import com.fsd.customer.dao.CustomerDao;
import com.fsd.customer.entity.UserEntity;
import com.fsd.customer.exception.CustomerException;
import com.fsd.customer.helper.CustomerHashUtils;
import com.fsd.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao dao;

    @Autowired
    TemplateClient client;


    @Override
    public SignUpResponse userSignUp(UserSignUpRequest userSignUpRequest) {
        String userId= userSignUpRequest.getRole().substring(0,2)+CustomerHashUtils.getId();
        UserEntity userEntity=new UserEntity(userId,userSignUpRequest.getUserName(),userSignUpRequest.getPassword(),userSignUpRequest.getEmail(),userSignUpRequest.getMobile(),userSignUpRequest.getRole());
        if(null!=dao.saveUser(userEntity)) {
            return new SignUpResponse(userId, "Registered Successfully");
        }else {
            throw new CustomerException(new ErrorBean("CU_001","Not Registered"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String userLogin(UserLoginRequest userLoginRequest) {
        return "";
    }

    @Override
    public UserSignUpRequest getUserDetails(String mobile) {
        return null;
    }
}