package com.bs.fan.myjob.model;

public class TensileTestOrder {
    private String order;
    private String sampleGaugeCode;//
    private String sampleShapeCode;//
    private String testDirectCode;//
    private String ysType;//
    private int ysMin;//
    private int ysMax;//
    private int tsMin;//
    private int tsMax;//
    private int breakElMin;//
    private int breakElMax;//

    public String getSampleGaugeCode() {
        return sampleGaugeCode;
    }

    public void setSampleGaugeCode(String sampleGaugeCode) {
        this.sampleGaugeCode = sampleGaugeCode;
    }

    public String getSampleShapeCode() {
        return sampleShapeCode;
    }

    public void setSampleShapeCode(String sampleShapeCode) {
        this.sampleShapeCode = sampleShapeCode;
    }

    public String getTestDirectCode() {
        return testDirectCode;
    }

    public void setTestDirectCode(String testDirectCode) {
        this.testDirectCode = testDirectCode;
    }

    public String getYsType() {
        return ysType;
    }

    public void setYsType(String ysType) {
        this.ysType = ysType;
    }

    public int getYsMin() {
        return ysMin;
    }

    public void setYsMin(int ysMin) {
        this.ysMin = ysMin;
    }

    public int getYsMax() {
        return ysMax;
    }

    public void setYsMax(int ysMax) {
        this.ysMax = ysMax;
    }

    public int getTsMin() {
        return tsMin;
    }

    public void setTsMin(int tsMin) {
        this.tsMin = tsMin;
    }

    public int getTsMax() {
        return tsMax;
    }

    public void setTsMax(int tsMax) {
        this.tsMax = tsMax;
    }

    public int getBreakElMin() {
        return breakElMin;
    }

    public void setBreakElMin(int breakElMin) {
        this.breakElMin = breakElMin;
    }

    public int getBreakElMax() {
        return breakElMax;
    }

    public void setBreakElMax(int breakElMax) {
        this.breakElMax = breakElMax;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
