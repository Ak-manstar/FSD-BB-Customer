package com.fsd.customer.helper;

import com.fsd.customer.bean.RegisterVendorRequestBean;
import com.fsd.customer.bean.UserSignUpRequest;

public class MapperUtil {

    public static RegisterVendorRequestBean getRegisterVendorRequestBean(UserSignUpRequest userSignUpRequest, String userId) {
        RegisterVendorRequestBean registerVendorRequestBean=new RegisterVendorRequestBean();
        registerVendorRequestBean.setUserId(userId);
        registerVendorRequestBean.setVendorOutletName(userSignUpRequest.getVendorOutletName());
        registerVendorRequestBean.setState(userSignUpRequest.getState());
        registerVendorRequestBean.setCity(userSignUpRequest.getCity());
        registerVendorRequestBean.setAddressLine1(userSignUpRequest.getAddressLine1());
        registerVendorRequestBean.setAddressLine2(userSignUpRequest.getAddressLine2());
        registerVendorRequestBean.setPinCode(userSignUpRequest.getPinCode());
        registerVendorRequestBean.setOpeningTime(userSignUpRequest.getOpeningTime());
        registerVendorRequestBean.setClosingTime(userSignUpRequest.getClosingTime());
        registerVendorRequestBean.setNoOfStaff(userSignUpRequest.getNoOfStaff());
        registerVendorRequestBean.setMobile(userSignUpRequest.getMobile());
        registerVendorRequestBean.setServices(userSignUpRequest.getServices());
        return registerVendorRequestBean;
    }
}