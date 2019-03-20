package com.userdetails.springboot.util;

/**
* @author  Srinivas Gudipati
* @version 1.0
* @since   2019-03-20
* This is the Error class that captures the error message and send this to FrontEnd.
*/
public class CustomErrorType {

    private String errorMessage;

    public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
