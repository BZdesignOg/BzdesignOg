package com.bs.fan.myjob.model;

public class HardnessTestOrder {
    private String orderNo;
    private String hardType;
    private int hardMin;
    private int hardMax;

    public String getHardType() {
        return hardType;
    }

    public void setHardType(String hardType) {
        this.hardType = hardType;
    }

    public int getHardMin() {
        return hardMin;
    }

    public void setHardMin(int hardMin) {
        this.hardMin = hardMin;
    }

    public int getHardMax() {
        return hardMax;
    }

    public void setHardMax(int hardMax) {
        this.hardMax = hardMax;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
