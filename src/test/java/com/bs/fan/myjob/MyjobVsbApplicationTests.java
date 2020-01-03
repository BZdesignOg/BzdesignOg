package com.bs.fan.myjob;

import com.bs.fan.myjob.mapper.local.ordertrace.LateOrderMapper;
import com.bs.fan.myjob.mapper.sas.materialtrace.MaterialTraceDataMapper;
import com.bs.fan.myjob.model.LateOrder;
import com.bs.fan.myjob.model.MaterialTraceData;
import com.bs.fan.myjob.service.IMaterialTraceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@ComponentScan(basePackages = {"com.bs.fan.myjob.mapper.local"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MyjobVsbApplicationTests {

    @Autowired
    protected LateOrderMapper lateOrderMapper;
    @Autowired
    protected MaterialTraceDataMapper materialTraceDataMapper;

    @Autowired
    protected IMaterialTraceService materialTraceService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetAllOrders(){
        List<LateOrder> los=lateOrderMapper.getAll();
        for(LateOrder o:los){
            System.out.println(o);
        }
    }

    @Test
    public void testGetOrdersByOrderNo(){
        List<LateOrder> los=lateOrderMapper.getByOrder("L9BC015632");
        for(LateOrder o:los){
            System.out.println(o);
        }
    }

    @Test
    public void testUpdateOrder(){
        List<LateOrder> los=lateOrderMapper.getByOrder("L9BC015632");
        LateOrder lo=los.get(0);
        lo.setRpn("060680");
        lateOrderMapper.update(lo);

    }

    @Test
    public void testGetMatTraceData(){
        List<MaterialTraceData> data=materialTraceDataMapper.getTraceDataByCoilNo("19543071701");
        for(MaterialTraceData d:data){
            System.out.println(d);
        }
    }

    @Test
    public void testMaterialTraceService(){
        List<MaterialTraceData> list=materialTraceService.getTraceDataByCoilno("19345490901");
        for(MaterialTraceData mtd:list){
            System.out.println(mtd);
        }
    }

}
