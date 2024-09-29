package com.fsd.customer.controller;

import com.fsd.customer.bean.ResponseBean;
import com.fsd.customer.bean.UserSignUpRequest;
import com.fsd.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("/signUp")
    public ResponseEntity<ResponseBean> dummyGetController(@RequestBody UserSignUpRequest userSignUpRequest){
        return new ResponseEntity<>(new ResponseBean(service.userSignUp(userSignUpRequest)), HttpStatus.OK);
    }
}