package com.fsd.customer.controller;

import com.fsd.customer.bean.ResponseBean;
import com.fsd.customer.bean.UserLoginRequest;
import com.fsd.customer.bean.UserSignUpRequest;
import com.fsd.customer.service.CustomerService;
import jakarta.websocket.server.PathParam;
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
    public ResponseEntity<ResponseBean> signUp(@RequestBody UserSignUpRequest userSignUpRequest){
        return new ResponseEntity<>(new ResponseBean(service.userSignUp(userSignUpRequest)), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseBean> getUserDetails(@RequestBody UserLoginRequest userLoginRequest){
        return new ResponseEntity<>(new ResponseBean(service.userLogin(userLoginRequest)), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseBean> getUserDetails(@PathVariable String userId){
        return new ResponseEntity<>(new ResponseBean(service.getUserDetails(userId)), HttpStatus.OK);
    }


}