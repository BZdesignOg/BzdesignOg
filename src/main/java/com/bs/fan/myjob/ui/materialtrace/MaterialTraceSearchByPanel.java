package com.bs.fan.myjob.ui.materialtrace;

import com.bs.fan.myjob.ui.JCustPanel;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MaterialTraceSearchByPanel extends JCustPanel {
    private JTextField materialNoFeild;

    public String getMaterialNo(){
        return materialNoFeild.getText();
    }
    MaterialTraceSearchByPanel(){
///设置null布局
        setLayout(null);
/////设置查询条件输入
        JLabel lblCoilno = new JLabel("输入材料号:");
        lblCoilno.setBounds(20, 20, 100, 20);// left x,left y,width,height
        materialNoFeild = new JTextField();
        materialNoFeild.setBounds(125, 40, 150, 30);
        this.add(lblCoilno);
        this.add(materialNoFeild);
    ///设置默认背景色
        setBackground(new Color(196,196,196));


    }

}
