package com.bs.fan.myjob.mapper.local.ordertrace;

import com.bs.fan.myjob.model.LateOrder;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("lateOrderMapper")
public interface LateOrderMapper {

    @Select("SELECT * FROM duoqianqian_order_list")
    @Results({@Result(property = "seqNo",column = "NO"),
            @Result(property = "orderNo",column = "ORDER_NO"),
            @Result(property = "orderDeliveryDate",column = "ORDER_DELIVERY_DATE"),
            @Result(property = "deliveryWeekFlag",column = "DELIVY_WEEK_FLAG"),
            @Result(property = "sgSign",column = "SG_SIGN"),
            @Result(property = "steelGrade",column = "STEELGRADE"),
            @Result(property = "orderStatus",column = "ORDER_STATUS"),
            @Result(property = "orderThick",column = "ORDER_THICK"),
            @Result(property = "orderWidth",column = "ORDER_WIDTH"),
            @Result(property = "finUserName",column = "FIN_USER_NAME"),
            @Result(property = "cause1",column = "daleiyuanyin"),
            @Result(property = "defect1",column = "defect1"),
            @Result(property = "reason",column = "REASON"),
            @Result(property = "measure",column = "MEASURE"),
            @Result(property = "dealTime",column = "DEAL_TIME"),
            @Result(property = "wuliao",column = "WULIAO"),
            @Result(property = "rpn",column = "rpn_01"),
            @Result(property = "orderWt",column = "ORDER_WT"),
            @Result(property = "orderLackWt",column = "zhunfaqianliang"),
            @Result(property = "psr",column = "PSR"),
            @Result(property = "apn",column = "ord_n"),
            @Result(property = "lackWtInput",column = "lack_wei"),
            @Result(property = "lackMark",column = "buzubj")

    })
    List<LateOrder> getAll();

    @Update("UPDATE duoqianqian_order_list SET RPN_01=#{rpn}," +
            "REASON=#{reason},MEASURE=#{measure}," +
            "DEAL_TIME=#{dealTime}" +
            " WHERE " +
            "ORDER_NO =#{orderNo}")
    void update(LateOrder lo);


    @Select("SELECT * FROM duoqianqian_order_list where ORDER_NO=#{orderNo}")
    @Results({@Result(property = "seqNo",column = "NO"),
            @Result(property = "orderNo",column = "ORDER_NO"),
            @Result(property = "orderDeliveryDate",column = "ORDER_DELIVERY_DATE"),
            @Result(property = "deliveryWeekFlag",column = "DELIVY_WEEK_FLAG"),
            @Result(property = "sgSign",column = "SG_SIGN"),
            @Result(property = "steelGrade",column = "STEELGRADE"),
            @Result(property = "orderStatus",column = "ORDER_STATUS"),
            @Result(property = "orderThick",column = "ORDER_THICK"),
            @Result(property = "orderWidth",column = "ORDER_WIDTH"),
            @Result(property = "finUserName",column = "FIN_USER_NAME"),
            @Result(property = "cause1",column = "daleiyuanyin"),
            @Result(property = "defect1",column = "defect1"),
            @Result(property = "reason",column = "REASON"),
            @Result(property = "measure",column = "MEASURE"),
            @Result(property = "dealTime",column = "DEAL_TIME"),
            @Result(property = "wuliao",column = "WULIAO"),
            @Result(property = "rpn",column = "rpn_01"),
            @Result(property = "orderWt",column = "ORDER_WT"),
            @Result(property = "orderLackWt",column = "zhunfaqianliang"),
            @Result(property = "psr",column = "PSR"),
            @Result(property = "apn",column = "ord_n"),
            @Result(property = "lackWtInput",column = "lack_wei"),
            @Result(property = "lackMark",column = "buzubj")

    })
    List<LateOrder> getByOrder(String orderNo);
}
