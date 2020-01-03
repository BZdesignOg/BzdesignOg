package com.bs.fan.myjob.ui.materialtrace;

import com.bs.fan.myjob.ui.JCustButton;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MaterialTraceCmdPanel extends JPanel {
    private JCustButton btnTracePath = new JCustButton("查询工艺路径");
    private JCustButton btnTraceProcess = new JCustButton("查询工艺参数");

    public JCustButton getBtnTracePath() {
        return btnTracePath;
    }

    public JCustButton getBtnTraceProcess() {
        return btnTraceProcess;
    }

    MaterialTraceCmdPanel(){
        ///设置GridBagLayout布局
        setLayout(new GridBagLayout());
        //增加按钮
        add(btnTracePath);
        add(btnTraceProcess);

    }

    public void setBtnTracePath(JCustButton btnTracePath) {
        this.btnTracePath = btnTracePath;
    }

    public void setBtnTraceProcess(JCustButton btnTraceProcess) {
        this.btnTraceProcess = btnTraceProcess;
    }
}
