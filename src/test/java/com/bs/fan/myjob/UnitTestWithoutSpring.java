package com.bs.fan.myjob;

import org.jfree.data.time.Second;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class UnitTestWithoutSpring {

    /*
      测试StringUtils.isEmpty:null,""返回true，其他返回false
     */
    @Test
    public void testSpringStringUtil(){
        String strTest=null;
        System.out.println(StringUtils.isEmpty(strTest));
    }

    @Test
    public void testSpringCollectionsUtils(){
        List<Integer> ints=null;
        System.out.println(CollectionUtils.isEmpty(ints));
    }

    @Test
    public void testReg(){
        String t="a,b,c，d1 e2 3,4.5，6";
        String[] target=t.split("[\\W]");
        for(String x:target) {
            System.out.println(x);
        }
    }

    @Test
    public void testFreechartTime() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        Date date=sdf.parse("20130522051609");

        Second second=new Second(date);
        System.out.println(second);
    }
}
