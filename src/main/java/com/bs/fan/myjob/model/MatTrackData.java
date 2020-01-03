package com.bs.fan.myjob.model;


public class MatTrackData {
	private String outMatno;
	private String inMatno;
	private String trackMatno;

	private float matThick;
	private int matWidth;
	private float matWeight;

	private String preUnitcode;
	private String stNo;
	private String sgSign;
	private String orderNo;
	private String prodEndtime;


	public String getTrackMatno() {
		return trackMatno;
	}

	public void setTrackMatno(String trackMatno) {
		this.trackMatno = trackMatno;
	}

	public String getInMatno() {
		return inMatno;
	}
	public void setInMatno(String inMatno) {
		this.inMatno = inMatno;
	}
	public float getMatThick() {
		return matThick;
	}
	public void setMatThick(float matThick) {
		this.matThick = matThick;
	}
	
	public String getOutMatno() {
		return outMatno;
	}
	public void setOutMatno(String outMatno) {
		this.outMatno = outMatno;
	}
	public String getPreUnitcode() {
		return preUnitcode;
	}
	public void setPreUnitcode(String preUnitcode) {
		this.preUnitcode = preUnitcode;
	}
	public String getStNo() {
		return stNo;
	}
	public void setStNo(String stNo) {
		this.stNo = stNo;
	}
	public String getSgSign() {
		return sgSign;
	}
	public void setSgSign(String sgSign) {
		this.sgSign = sgSign;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProdEndtime() {
		return prodEndtime;
	}
	public void setProdEndtime(String prodEndtime) {
		this.prodEndtime = prodEndtime;
	}

	public MatTrackData(){}
	
	public MatTrackData(String outMatno, String trackMatno, float matThick, int matWidth,
                        float matWeight,
                        String inMatno,
                        String preUnitcode, String stNo, String sgSign, String orderNo, String prodEndtime){
		this.outMatno=outMatno;
		this.matThick=matThick;
		this.inMatno=inMatno;
		this.preUnitcode=preUnitcode;
		this.stNo=stNo;
		this.sgSign=sgSign;
		this.orderNo=orderNo;
		this.prodEndtime=prodEndtime;
		this.matWidth=matWidth;
		this.matWeight=matWeight;
		this.trackMatno=trackMatno;
		
	}
	public int getMatWidth() {
		return matWidth;
	}
	public void setMatWidth(int matWidth) {
		this.matWidth = matWidth;
	}
	public float getMatWeight() {
		return matWeight;
	}
	public void setMatWeight(float matWeight) {
		this.matWeight = matWeight;
	}


}
