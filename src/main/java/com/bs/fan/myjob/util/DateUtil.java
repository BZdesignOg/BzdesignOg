package com.bs.fan.myjob.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date dateByString(String dateString){

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date date=sdf.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
