package com.bs.fan.myjob.mapper.sas.materialtrace;

import com.bs.fan.myjob.model.MaterialTraceData;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("materialTraceDataMapper")
public interface MaterialTraceDataMapper {

    @Select("SELECT * FROM MM00.TMM0005 WHERE MAT_TRACK_NO=#{trackNo} ORDER BY " +
            "PROD_END_TIME ASC")
    @Results({
            @Result(property = "outMatno",column = "OUT_MAT_NO"),
            @Result(property = "inMatno",column = "IN_MAT_NO_1"),
            @Result(property = "trackMatno",column = "MAT_TRACK_NO"),
            @Result(property = "matThick",column = "MAT_ACT_THICK"),
            @Result(property = "matWidth",column = "MAT_ACT_WIDTH"),
            @Result(property = "matWeight",column = "MAT_ACT_WEIGHT"),
            @Result(property = "preUnitcode",column = "PRE_UNIT_CODE"),
            @Result(property = "stNo",column = "ST_NO"),
            @Result(property = "sgSign",column = "SG_SIGN"),
            @Result(property = "orderNo",column = "ORDER_NO"),
            @Result(property = "prodEndtime",column = "PROD_END_TIME"),
    })
  List<MaterialTraceData>
    getTraceDataByTrackNo(String trackNo);

    @Select("SELECT * FROM MM00.TMM0005 WHERE OUT_MAT_NO=#{coilNo}")
    @Results({
            @Result(property = "outMatno",column = "OUT_MAT_NO"),
            @Result(property = "inMatno",column = "IN_MAT_NO_1"),
            @Result(property = "trackMatno",column = "MAT_TRACK_NO"),
            @Result(property = "matThick",column = "MAT_ACT_THICK"),
            @Result(property = "matWidth",column = "MAT_ACT_WIDTH"),
            @Result(property = "matWeight",column = "MAT_ACT_WEIGHT"),
            @Result(property = "preUnitcode",column = "PRE_UNIT_CODE"),
            @Result(property = "stNo",column = "ST_NO"),
            @Result(property = "sgSign",column = "SG_SIGN"),
            @Result(property = "orderNo",column = "ORDER_NO"),
            @Result(property = "prodEndtime",column = "PROD_END_TIME"),
    })
  List<MaterialTraceData>
    getTraceDataByCoilNo(String coilNo);
}
