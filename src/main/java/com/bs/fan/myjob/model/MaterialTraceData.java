package com.bs.fan.myjob.model;

import lombok.Data;


@Data
public class MaterialTraceData {
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



	//工具函数：判断所属工序


}
