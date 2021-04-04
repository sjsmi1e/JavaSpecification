package com.smlie.responcse;

/**
 * 此类为返回相应页面类
 * 规定返回的数据格式（json）
 * 状态码+data
 */
public class CommonResponse {
    private int state;
    private Object data;


    //创建响应体VO
    public static CommonResponse createRrsponse(int state, Object data){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setState(state);
        commonResponse.setData(data);
        return commonResponse;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
