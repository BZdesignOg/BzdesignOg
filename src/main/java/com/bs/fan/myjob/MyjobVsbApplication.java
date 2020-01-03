package com.bs.fan.myjob;

import com.bs.fan.myjob.controller.mainframe.MainFrameController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

@SpringBootApplication
@EnableCaching
public class MyjobVsbApplication {

    public static void main(String[] args) {
//设置成headless=false,否则打包后不能运行。
        System.setProperty("java.awt.headless","false");
        ConfigurableApplicationContext context=
                new SpringApplicationBuilder(MyjobVsbApplication.class)
                        .headless(false).run(args);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrameController mfc=context.getBean(MainFrameController.class);
                mfc.prepareAndOpenFrame();
            }
        });

    }

}
