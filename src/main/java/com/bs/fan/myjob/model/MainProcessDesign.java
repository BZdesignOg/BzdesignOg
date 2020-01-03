package com.bs.fan.myjob.model;

import java.util.Objects;

public class MainProcessDesign {
//	合同档
	private String orderNo;
	//	钢级
	private String signCode;
	private String signLineNo;
	//	出钢记号
	private String stNo;
	//	退火工艺
	private String annealDiagramCode;
	private int controlTemp;
	private int oakTempAim;
	private float tpmRateAim;
	private String annealUnit;

	private String orderStatus;
	private String sgStd;
	private float orderThick;
	private int orderWidth;
	private int orderInnerDia;
	private String orderDeliveryDate;
	private String sgSign;
	private float orderWt;	
	private String psr;
	private String mic;
	private String apn;
	private String finUserName;

//	热轧工艺
	private int heatTempAim;
	private int afftTempAim;
	private int coilTempAim;
	private String hotUnit;
	private String sprayCtrlModeCode;
	private String dynCtIdx;
//	冷轧工艺
	private float hotThick;
	private float deformRate;


//	试验索引
	private String idxNoQ1;//拉伸
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

	private String idxNoQ8;//硬度
	private String hardType;
	private int hardMin;
	private int hardMax;

	private String idxNoQ6;

	public String getDynCtIdx() {
		return dynCtIdx;
	}

	public void setDynCtIdx(String dynCtIdx) {
		this.dynCtIdx = dynCtIdx;
	}

	public String getSignLineNo() {
		return signLineNo;
	}

	public void setSignLineNo(String signLineNo) {
		this.signLineNo = signLineNo;
	}

	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getSgStd() {
		return sgStd;
	}
	public void setSgStd(String sgStd) {
		this.sgStd = sgStd;
	}
	public float getOrderThick() {
		return orderThick;
	}
	public void setOrderThick(float orderThick) {
		this.orderThick = orderThick;
	}
	public int getOrderWidth() {
		return orderWidth;
	}
	public void setOrderWidth(int orderWidth) {
		this.orderWidth = orderWidth;
	}
	public int getOrderInnerDia() {
		return orderInnerDia;
	}
	public void setOrderInnerDia(int orderInnerDia) {
		this.orderInnerDia = orderInnerDia;
	}
	public String getOrderDeliveryDate() {
		return orderDeliveryDate;
	}
	public void setOrderDeliveryDate(String orderDeliveryDate) {
		this.orderDeliveryDate = orderDeliveryDate;
	}
	public String getSgSign() {
		return sgSign;
	}
	public void setSgSign(String sgSign) {
		this.sgSign = sgSign;
	}
	public float getOrderWt() {
		return orderWt;
	}
	public void setOrderWt(float orderWt) {
		this.orderWt = orderWt;
	}
	public String getPsr() {
		return psr;
	}
	public void setPsr(String psr) {
		this.psr = psr;
	}
	public String getMic() {
		return mic;
	}
	public void setMic(String mic) {
		this.mic = mic;
	}
	public String getFinUserName() {
		return finUserName;
	}
	public void setFinUserName(String finUserName) {
		this.finUserName = finUserName;
	}
	public String getStNo() {
		return stNo;
	}
	public void setStNo(String stNo) {
		this.stNo = stNo;
	}
	public int getHeatTempAim() {
		return heatTempAim;
	}
	public void setHeatTempAim(int heatTempAim) {
		this.heatTempAim = heatTempAim;
	}
	public int getAfftTempAim() {
		return afftTempAim;
	}
	public void setAfftTempAim(int afftTempAim) {
		this.afftTempAim = afftTempAim;
	}
	public int getCoilTempAim() {
		return coilTempAim;
	}
	public void setCoilTempAim(int coilTempAim) {
		this.coilTempAim = coilTempAim;
	}
	public String getHotUnit() {
		return hotUnit;
	}
	public void setHotUnit(String hotUnit) {
		this.hotUnit = hotUnit;
	}
	public String getSprayCtrlModeCode() {
		return sprayCtrlModeCode;
	}
	public void setSprayCtrlModeCode(String sprayCtrlModeCode) {
		this.sprayCtrlModeCode = sprayCtrlModeCode;
	}
	public float getHotThick() {
		return hotThick;
	}
	public void setHotThick(float hotThick) {
		this.hotThick = hotThick;
	}
	public float getDeformRate() {
		return deformRate;
	}
	public void setDeformRate(float deformRate) {
		this.deformRate = deformRate;
	}
	public String getAnnealDiagramCode() {
		return annealDiagramCode;
	}
	public void setAnnealDiagramCode(String annealDiagramCode) {
		this.annealDiagramCode = annealDiagramCode;
	}
	public int getControlTemp() {
		return controlTemp;
	}
	public void setControlTemp(int controlTemp) {
		this.controlTemp = controlTemp;
	}
	public int getOakTempAim() {
		return oakTempAim;
	}
	public void setOakTempAim(int oakTempAim) {
		this.oakTempAim = oakTempAim;
	}
	public float getTpmRateAim() {
		return tpmRateAim;
	}
	public void setTpmRateAim(float tpmRateAim) {
		this.tpmRateAim = tpmRateAim;
	}
	public String getAnnealUnit() {
		return annealUnit;
	}
	public void setAnnealUnit(String annealUnit) {
		this.annealUnit = annealUnit;
	}
	public String getSignCode() {
		return signCode;
	}
	public void setSignCode(String signCode) {
		this.signCode = signCode;
	}
	public String getIdxNoQ1() {
		return idxNoQ1;
	}
	public void setIdxNoQ1(String idxNoQ1) {
		this.idxNoQ1 = idxNoQ1;
	}
	public String getIdxNoQ8() {
		return idxNoQ8;
	}
	public void setIdxNoQ8(String idxNoQ8) {
		this.idxNoQ8 = idxNoQ8;
	}
	public String getIdxNoQ6() {
		return idxNoQ6;
	}
	public void setIdxNoQ6(String idxNoQ6) {
		this.idxNoQ6 = idxNoQ6;
	}
	public String getApn() {
		return apn;
	}
	public void setApn(String apn) {
		this.apn = apn;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MainProcessDesign that = (MainProcessDesign) o;
		return
				orderNo.equals(that.orderNo) &&
				sgSign.equals(that.sgSign) &&
				stNo.equals(that.stNo) &&
				signCode.equals(that.signCode) &&
				signLineNo.equals(that.signLineNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderNo, sgSign,  stNo,  signCode);
	}
}
