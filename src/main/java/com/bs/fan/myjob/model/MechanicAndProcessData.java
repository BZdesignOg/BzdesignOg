package com.bs.fan.myjob.model;

public class MechanicAndProcessData {
    private String matNo;
    private String samplePosition;
    private String thick;
    private String steel;
    private String steelCode;
    private String signLineNo;
    private String psr;
    private String sign;
    private String orderNo;

    private String annealUnit="";//退火机组
    private String hotUnit="";//热轧机组
    private String hotMatNo="";//热轧出口卷号
    private String hotInMatNo="";//热轧出口卷号

    //炼钢成分
    private float eleCAct;
    private float eleSiAct;
    private float eleMnAct;
    private float elePAct;
    private float eleSAct;
    private float eleAltAct;
    private float eleNAct;
    private float eleOAct;
    private float eleTiAct;
    private float eleNbAct;
    private float eleBAct;

    //热轧工艺
    private int dischTempAct;
    private int tempFmMax;
    private int tempFmMin;
    private int tempFmAve;
    private int tempCtMax;
    private int tempCtAve;
    private int tempCtMin;

    private String coldPatternCode="";
    //连退工艺
    private String annealCode="";
    private String planCode="";

    private int speed;
    private int sfTempAve;
    private int sfTempAveFur;
    private int oaTempAve;
    private int preTensionAve;
    private int nextTensionAve;
    private int rollForceAve;
    private float tpmRateAve;


    private float ts;
    private float rp02;
    private float rpl;
    private float rpstd;
    private float el;
    private float hardness;
    private float ysEl;

    private float r0;
    private float r45;
    private float r90;
    private float ravg;
    private float deltaR;

    private float navg;
    private float n0;
    private float n45;
    private float n90;

    private String matTrackNo;
    private String pono;
    private String datet;

    public int getSfTempAveFur() {
        return sfTempAveFur;
    }

    public void setSfTempAveFur(int sfTempAveFur) {
        this.sfTempAveFur = sfTempAveFur;
    }

    public String getPsr() {
        return psr;
    }

    public void setPsr(String psr) {
        this.psr = psr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public float getDeltaR() {
        return deltaR;
    }

    public void setDeltaR(float deltaR) {
        this.deltaR = deltaR;
    }

    public String getDatet() {
        return datet;
    }

    public void setDatet(String datet) {
        this.datet = datet;
    }

    public float getYsEl() {
        return ysEl;
    }

    public void setYsEl(float ysEl) {
        this.ysEl = ysEl;
    }

    public float getR0() {
        return r0;
    }

    public void setR0(float r0) {
        this.r0 = r0;
    }

    public float getR45() {
        return r45;
    }

    public void setR45(float r45) {
        this.r45 = r45;
    }

    public float getR90() {
        return r90;
    }

    public void setR90(float r90) {
        this.r90 = r90;
    }

    public float getRavg() {
        return ravg;
    }

    public void setRavg(float ravg) {
        this.ravg = ravg;
    }

    public float getNavg() {
        return navg;
    }

    public void setNavg(float navg) {
        this.navg = navg;
    }

    public float getN0() {
        return n0;
    }

    public void setN0(float n0) {
        this.n0 = n0;
    }

    public float getN45() {
        return n45;
    }

    public void setN45(float n45) {
        this.n45 = n45;
    }

    public float getN90() {
        return n90;
    }

    public void setN90(float n90) {
        this.n90 = n90;
    }

    public String getMatTrackNo() {
        return matTrackNo;
    }

    public void setMatTrackNo(String matTrackNo) {
        this.matTrackNo = matTrackNo;
    }

    public String getPono() {
        return pono;
    }

    public void setPono(String pono) {
        this.pono = pono;
    }

    public String getSignLineNo() {
        return signLineNo;
    }

    public void setSignLineNo(String signLineNo) {
        this.signLineNo = signLineNo;
    }

    @Override
    public String toString() {
        return "MechanicAndProcessData{" +
                "matNo='" + matNo + '\'' +
                ", samplePosition='" + samplePosition + '\'' +
                ", thick='" + thick + '\'' +
                ", steel='" + steel + '\'' +
                ", steelCode='" + steelCode + '\'' +
                ", ts=" + ts +
                ", rp02=" + rp02 +
                ", rpl=" + rpl +
                ", el=" + el +
                ", hardness=" + hardness +
                '}';
    }

    public String getMatNo() {
        return matNo;
    }

    public void setMatNo(String matNo) {
        this.matNo = matNo;
    }

    public String getSamplePosition() {
        return samplePosition;
    }

    public void setSamplePosition(String samplePosition) {
        this.samplePosition = samplePosition;
    }

    public String getThick() {
        return thick;
    }

    public void setThick(String thick) {
        this.thick = thick;
    }

    public String getSteel() {
        return steel;
    }

    public void setSteel(String steel) {
        this.steel = steel;
    }

    public String getSteelCode() {
        return steelCode;
    }

    public void setSteelCode(String steelCode) {
        this.steelCode = steelCode;
    }

    public float getTs() {
        return ts;
    }

    public void setTs(float ts) {
        this.ts = ts;
    }

    public float getRp02() {
        return rp02;
    }

    public void setRp02(float rp02) {
        this.rp02 = rp02;
    }

    public float getRpl() {
        return rpl;
    }

    public void setRpl(float rpl) {
        this.rpl = rpl;
    }

    public float getEl() {
        return el;
    }

    public void setEl(float el) {
        this.el = el;
    }

    public float getHardness() {
        return hardness;
    }

    public void setHardness(float hardness) {
        this.hardness = hardness;
    }

    public float getRpstd() {
        return rpstd;
    }

    public void setRpstd(float rpstd) {
        this.rpstd = rpstd;
    }

    public String getAnnealUnit() {
        return annealUnit;
    }

    public void setAnnealUnit(String annealUnit) {
        this.annealUnit = annealUnit;
    }

    public String getHotUnit() {
        return hotUnit;
    }

    public void setHotUnit(String hotUnit) {
        this.hotUnit = hotUnit;
    }

    public String getHotMatNo() {
        return hotMatNo;
    }

    public void setHotMatNo(String hotMatNo) {
        this.hotMatNo = hotMatNo;
    }

    public String getHotInMatNo() {
        return hotInMatNo;
    }

    public void setHotInMatNo(String hotInMatNo) {
        this.hotInMatNo = hotInMatNo;
    }

    public String getAnnealCode() {
        return annealCode;
    }

    public void setAnnealCode(String annealCode) {
        this.annealCode = annealCode;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSfTempAve() {
        return sfTempAve;
    }

    public void setSfTempAve(int sfTempAve) {
        this.sfTempAve = sfTempAve;
    }

    public int getOaTempAve() {
        return oaTempAve;
    }

    public void setOaTempAve(int oaTempAve) {
        this.oaTempAve = oaTempAve;
    }

    public int getPreTensionAve() {
        return preTensionAve;
    }

    public void setPreTensionAve(int preTensionAve) {
        this.preTensionAve = preTensionAve;
    }

    public int getNextTensionAve() {
        return nextTensionAve;
    }

    public void setNextTensionAve(int nextTensionAve) {
        this.nextTensionAve = nextTensionAve;
    }

    public int getRollForceAve() {
        return rollForceAve;
    }

    public void setRollForceAve(int rollForceAve) {
        this.rollForceAve = rollForceAve;
    }

    public float getTpmRateAve() {
        return tpmRateAve;
    }

    public void setTpmRateAve(float tpmRateAve) {
        this.tpmRateAve = tpmRateAve;
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

    public float getEleCAct() {
        return eleCAct;
    }

    public void setEleCAct(float eleCAct) {
        this.eleCAct = eleCAct;
    }

    public float getEleSiAct() {
        return eleSiAct;
    }

    public void setEleSiAct(float eleSiAct) {
        this.eleSiAct = eleSiAct;
    }

    public float getEleMnAct() {
        return eleMnAct;
    }

    public void setEleMnAct(float eleMnAct) {
        this.eleMnAct = eleMnAct;
    }

    public float getElePAct() {
        return elePAct;
    }

    public void setElePAct(float elePAct) {
        this.elePAct = elePAct;
    }

    public float getEleSAct() {
        return eleSAct;
    }

    public void setEleSAct(float eleSAct) {
        this.eleSAct = eleSAct;
    }

    public float getEleAltAct() {
        return eleAltAct;
    }

    public void setEleAltAct(float eleAltAct) {
        this.eleAltAct = eleAltAct;
    }

    public float getEleNAct() {
        return eleNAct;
    }

    public void setEleNAct(float eleNAct) {
        this.eleNAct = eleNAct;
    }

    public float getEleOAct() {
        return eleOAct;
    }

    public void setEleOAct(float eleOAct) {
        this.eleOAct = eleOAct;
    }

    public float getEleTiAct() {
        return eleTiAct;
    }

    public void setEleTiAct(float eleTiAct) {
        this.eleTiAct = eleTiAct;
    }

    public float getEleNbAct() {
        return eleNbAct;
    }

    public void setEleNbAct(float eleNbAct) {
        this.eleNbAct = eleNbAct;
    }

    public float getEleBAct() {
        return eleBAct;
    }

    public void setEleBAct(float eleBAct) {
        this.eleBAct = eleBAct;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
