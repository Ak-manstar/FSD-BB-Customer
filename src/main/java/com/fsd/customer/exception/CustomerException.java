package com.fsd.customer.exception;

import com.fsd.customer.bean.ErrorBean;
import org.springframework.http.HttpStatus;

public class CustomerException extends RuntimeException{

    private ErrorBean errorBean;
    private HttpStatus httpStatus;

    public CustomerException(ErrorBean errorBean, HttpStatus httpStatus) {
        this.errorBean = errorBean;
        this.httpStatus = httpStatus;
    }

    public ErrorBean getErrorBean() {
        return errorBean;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String toString() {
        return "CustomerException{" +
                "errorBean=" + errorBean +
                ", httpStatus=" + httpStatus +
                '}';
    }
}