package com.fsd.customer.client;

import com.fsd.customer.bean.RegisterVendorRequestBean;
import com.fsd.customer.bean.ResponseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url="localhost:8081/vendor",name="vendor-client")
public interface VendorClient {

    @PostMapping("/register")
    public ResponseEntity<String> registerVendor(@RequestBody RegisterVendorRequestBean registerVendorRequestBean);
}