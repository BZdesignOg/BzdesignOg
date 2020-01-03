package com.bs.fan.myjob.ui.processtrace;

import com.bs.fan.myjob.ui.JCustButton;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ProcessTraceCmdPanel extends JPanel {
    private JCustButton btnGenerateChart=new JCustButton("生成一页纸");
    private JCustButton btnSaveChart=new JCustButton("另外为...");

    ProcessTraceCmdPanel(){
        setLayout(new GridBagLayout());

        add(btnGenerateChart);
        add(btnSaveChart);
    }

    public JCustButton getBtnGenerateChart() {
        return btnGenerateChart;
    }

    public JCustButton getBtnSaveChart() {
        return btnSaveChart;
    }
}
