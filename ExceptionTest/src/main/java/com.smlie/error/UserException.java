package com.smlie.error;

/**
 * 用户异常类
 */
public class UserException extends Exception implements CommonError{

    private CommonError commonError;

    public UserException(CommonError commonError) {
        super(commonError.getErrMsg());
        this.commonError = commonError;
    }

    public UserException(CommonError commonError ,String erroeMsg) {
        super(commonError.getErrMsg());
        this.commonError = commonError;
        this.setErrMsg(erroeMsg);
    }

    @Override
    public int getErrCode() {
        return 0;
    }

    @Override
    public String getErrMsg() {
        return null;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        return null;
    }
}
