package com.bs.fan.myjob.service;

import com.bs.fan.myjob.mapper.sas.materialtrace.MaterialTraceDataMapper;
import com.bs.fan.myjob.model.MaterialTraceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialTraceServiceImpl implements IMaterialTraceService {
    @Autowired
    protected MaterialTraceDataMapper materialTraceDataMapper;

    @Override
    public List<MaterialTraceData> getTraceDataByCoilno(String outCoilNo) {
        //根据outCoilNo获得包含材料跟踪号的MaterialTraceData
        List<MaterialTraceData> traceTarget=materialTraceDataMapper.getTraceDataByCoilNo(outCoilNo);
        //根据MaterialTraceData的MaterialTrackNo获取跟踪数据
        if(traceTarget!=null){
            for(MaterialTraceData mtd:traceTarget){
                List traceData=materialTraceDataMapper.getTraceDataByTrackNo(mtd.getTrackMatno());
                if(traceData!=null)
                    return traceData;
            }
        }
        return null;
    }
}
