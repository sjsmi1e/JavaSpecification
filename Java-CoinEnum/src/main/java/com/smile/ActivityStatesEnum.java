package com.smile;

/**
 * 枚举实现状态自动机
 */
public enum ActivityStatesEnum {
    /**
     * 活动状态
     * 申报-> 批准-> 报名 -> 开始 -> 结束
     */
    DEACLARE(1) {
        @Override
        ActivityStatesEnum nextState() {
            return APPROVE;
        }
    },
    APPROVE(2) {
        @Override
        ActivityStatesEnum nextState() {
            return ENROLL;
        }
    },
    ENROLL(3) {
        @Override
        ActivityStatesEnum nextState() {
            return START;
        }
    },
    START(4) {
        @Override
        ActivityStatesEnum nextState() {
            return END;
        }
    },
    END(5) {
        @Override
        ActivityStatesEnum nextState() {
            return this;
        }
    };

    private int status;

    abstract ActivityStatesEnum nextState();

    ActivityStatesEnum(int status) {
        this.status = status;
    }
  
  public ActivityStatesEnum getEnum(int status) {
        for (ActivityStatesEnum statesEnum : ActivityStatesEnum.values()) {
            if (statesEnum.status == status) {
                return statesEnum;
            }
        }
        return null;
    }
}