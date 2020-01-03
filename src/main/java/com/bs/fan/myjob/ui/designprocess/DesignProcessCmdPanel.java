package com.bs.fan.myjob.ui.designprocess;

import com.bs.fan.myjob.ui.JCustButton;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class DesignProcessCmdPanel extends JPanel {
    private JCustButton btnDesignProcess=new JCustButton("查询设计工艺");

    public JCustButton getBtnDesignProcess() {
        return btnDesignProcess;
    }

    public  DesignProcessCmdPanel(){

        ///设置GridBagLayout布局
        setLayout(new GridBagLayout());
        setBackground(new Color(196,196,196));
        //增加按钮
        add(btnDesignProcess);

    }

}
