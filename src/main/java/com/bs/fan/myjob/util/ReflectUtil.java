package com.bs.fan.myjob.util;

public class ReflectUtil {
    public static Class class$(String string){
        Class var_class=null;
        try {
            var_class=Class.forName(string);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return var_class;
    }
}
