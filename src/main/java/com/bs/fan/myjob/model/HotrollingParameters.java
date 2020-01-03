package com.bs.fan.myjob.model;

public class HotrollingParameters {
    private int dischTempAct;
    private int tempFmMax;
    private int tempFmMin;
    private int tempFmAve;
    private int tempCtMax;
    private int tempCtAve;
    private int tempCtMin;

    private String coldPatternCode;
    private String matNo;
    private String planNo;
    private String recCreateTime;
    private String slabNo;

    public String getSlabNo() {
        return slabNo;
    }

    public void setSlabNo(String slabNo) {
        this.slabNo = slabNo;
    }

    public int getDischTempAct() {
        return dischTempAct;
    }

    public void setDischTempAct(int dischTempAct) {
        this.dischTempAct = dischTempAct;
    }

    public int getTempFmMax() {
        return tempFmMax;
    }

    public void setTempFmMax(int tempFmMax) {
        this.tempFmMax = tempFmMax;
    }

    public int getTempFmMin() {
        return tempFmMin;
    }

    public void setTempFmMin(int tempFmMin) {
        this.tempFmMin = tempFmMin;
    }

    public int getTempFmAve() {
        return tempFmAve;
    }

    public void setTempFmAve(int tempFmAve) {
        this.tempFmAve = tempFmAve;
    }

    public int getTempCtMax() {
        return tempCtMax;
    }

    public void setTempCtMax(int tempCtMax) {
        this.tempCtMax = tempCtMax;
    }

    public int getTempCtAve() {
        return tempCtAve;
    }

    public void setTempCtAve(int tempCtAve) {
        this.tempCtAve = tempCtAve;
    }

    public int getTempCtMin() {
        return tempCtMin;
    }

    public void setTempCtMin(int tempCtMin) {
        this.tempCtMin = tempCtMin;
    }

    public String getColdPatternCode() {
        return coldPatternCode;
    }

    public void setColdPatternCode(String coldPatternCode) {
        this.coldPatternCode = coldPatternCode;
    }

    public String getMatNo() {
        return matNo;
    }

    public void setMatNo(String matNo) {
        this.matNo = matNo;
    }

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }

    public String getRecCreateTime() {
        return recCreateTime;
    }

    public void setRecCreateTime(String recCreateTime) {
        this.recCreateTime = recCreateTime;
    }
}
