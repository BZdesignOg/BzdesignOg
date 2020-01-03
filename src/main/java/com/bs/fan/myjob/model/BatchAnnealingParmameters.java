package com.bs.fan.myjob.model;

public class BatchAnnealingParmameters {
    private String position="";
    private String planNo="";
    private String matNo="";
    private String designAnnealingDiagramCode="";
    private String socketNo="";
    private String stNo="";
    private String sign="";


    private float thick;
    private int width;
    private float weight;

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }

    public String getDesignAnnealingDiagramCode() {
        return designAnnealingDiagramCode;
    }

    public void setDesignAnnealingDiagramCode(String designAnnealingDiagramCode) {
        this.designAnnealingDiagramCode = designAnnealingDiagramCode;
    }

    public String getSocketNo() {
        return socketNo;
    }

    public void setSocketNo(String socketNo) {
        this.socketNo = socketNo;
    }

    public String getStNo() {
        return stNo;
    }

    public void setStNo(String stNo) {
        this.stNo = stNo;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getThick() {
        return thick;
    }

    public void setThick(float thick) {
        this.thick = thick;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMatNo() {
        return matNo;
    }

    public void setMatNo(String matNo) {
        this.matNo = matNo;
    }
}
