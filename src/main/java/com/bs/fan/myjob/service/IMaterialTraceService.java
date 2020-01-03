package com.bs.fan.myjob.service;

import com.bs.fan.myjob.model.MaterialTraceData;

import java.util.List;

public interface IMaterialTraceService {
    public List<MaterialTraceData> getTraceDataByCoilno(String outCoilNo);
}
