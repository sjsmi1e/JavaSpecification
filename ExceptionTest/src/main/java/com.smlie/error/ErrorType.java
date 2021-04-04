package com.smlie.error;

public enum  ErrorType implements CommonError{

    //用户相关错误信息
    USER_ERROR_MESSAGE(10001,"用户基本信息错误"),//用户基本信息错误
    USER_ERROR_NOTEXIT(10002,"用户不存在");//用户不存在

    ;
    private int code;
    private String errormsg;

    ErrorType(int code, String errormsg) {
        this.code = code;
        this.errormsg = errormsg;
    }

    @Override
    public int getErrCode() {
        return this.code;
    }

    @Override
    public String getErrMsg() {
        return this.errormsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errormsg = errMsg;
        return this;
    }
}
