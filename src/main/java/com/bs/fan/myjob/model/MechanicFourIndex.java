package com.bs.fan.myjob.model;

import java.util.Objects;

public class MechanicFourIndex {
    private String orderThick;//合同厚度
    private String orderSteel;//合同出钢记号
    private String orderSgCode;//合同钢级
    private String signLineNo;//产线族代码

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MechanicFourIndex that = (MechanicFourIndex) o;
        return Objects.equals(orderThick, that.orderThick) &&
                Objects.equals(orderSteel, that.orderSteel) &&
                Objects.equals(orderSgCode, that.orderSgCode) &&
                Objects.equals(signLineNo,that.signLineNo);
    }

    @Override
    public String toString() {
        return "{" +
                "t='" + orderThick + '\'' +
                ", stl='" + orderSteel + '\'' +
                ", stc='" + orderSgCode + '\'' +
                ", ln='" + signLineNo + '\''+
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderThick, orderSteel, orderSgCode);
    }

    public String getOrderThick() {
        return orderThick;
    }

    public void setOrderThick(String orderThick) {
        this.orderThick = orderThick;
    }

    public String getOrderSteel() {
        return orderSteel;
    }

    public void setOrderSteel(String orderSteel) {
        this.orderSteel = orderSteel;
    }

    public String getSignLineNo() {
        return signLineNo;
    }

    public void setSignLineNo(String signLineNo) {
        this.signLineNo = signLineNo;
    }

    public String getOrderSgCode() {
        return orderSgCode;
    }

    public void setOrderSgCode(String orderSgCode) {
        this.orderSgCode = orderSgCode;
    }
}
