package com.bs.fan.myjob.model;

import lombok.Data;

@Data
public class LateOrder {
    private String seqNo;//序号
    private String orderNo;//合同号
    private String orderDeliveryDate;//交货期
    private String deliveryWeekFlag;//交期标志
    private String sgSign;//钢种
    private String steelGrade;//制程出钢记号
    private String orderStatus;//合同状态
    private Double orderThick;//厚度
    private Double orderWidth;//宽度
    private String finUserName;//最终用户
    private String cause1;//类别daleiyuanyin
    private String defect1;//改判项目defect1
    private String reason;//具体原因
    private String measure;//改进\措施
    private String dealTime;//预计完成时间deal_time
    private String wuliao;//进度状态
    private String rpn;//责任人rpn_01
    private Double orderWt;//订货重量
    private Double orderLackWt;//准发欠量zhunfaqianliang
    private String psr;//PSR
    private String apn;//APN
    private Double ordOnline;//在制份数ord_n
    private Double lackWtInput;//投料欠量lack_wei
    private String lackMark;//投料不足标记buzubj


    private String orderTypeCode;



    private String sgCode1;
    private String apnDesc;
    private String deliveryWeekFlag1;


}
