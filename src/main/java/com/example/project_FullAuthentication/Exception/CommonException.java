package com.example.project_FullAuthentication.Exception;

public class CommonException extends Exception {
    private static final long serialVersionUID = 1l;
    private String Error_code ;
    private String Error_message;
    public CommonException(String Error_code, String Error_message){
        super(Error_message);
        this.Error_code = Error_code;
        this.Error_message = Error_message;
    }
    public CommonException (String error_message){
        super(error_message);
    }
    public String  getError_code(){
        return Error_code;
    }
    public void setError_code(String Error_code){
        this.Error_code = Error_code;
    }

    public String getError_message(){
        return Error_message;
    }
    public void setError_message( String Error_message){
        this.Error_message =  Error_message;
    }
}
