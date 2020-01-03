package com.bs.fan.myjob.model;

public class ContinuousAnnealingParameters {
	
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

	public String getMatNo() {
		return matNo;
	}

	public void setMatNo(String matNo) {
		this.matNo = matNo;
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

	public String getMatTrackNo() {
		return matTrackNo;
	}

	public void setMatTrackNo(String matTrackNo) {
		this.matTrackNo = matTrackNo;
	}

	public String getRecCreateTime() {
		return recCreateTime;
	}

	public void setRecCreateTime(String recCreateTime) {
		this.recCreateTime = recCreateTime;
	}

	public int getSfTempAveFur() {
		return sfTempAveFur;
	}

	public void setSfTempAveFur(int sfTempAveFur) {
		this.sfTempAveFur = sfTempAveFur;
	}

	private String annealCode;
	private String planCode;
	private String matNo;
	private String matTrackNo;

	private int speed;
	private int sfTempAve;
	private int sfTempAveFur;
	private int oaTempAve;
	private int preTensionAve;
	private int nextTensionAve;
	private int rollForceAve;
	private float tpmRateAve;

	private String recCreateTime;


}
