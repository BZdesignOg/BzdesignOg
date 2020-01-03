package com.bs.fan.myjob.controller.designprocess;

import com.bs.fan.myjob.controller.AbstractFrameController;
import com.bs.fan.myjob.ui.JCustButton;
import com.bs.fan.myjob.ui.JTablePanel;
import com.bs.fan.myjob.ui.designprocess.JDesignProcessViewPanel;
import com.bs.fan.myjob.ui.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;


@Controller
public class DesignProcessViewController extends AbstractFrameController {
    private JDesignProcessViewPanel designProcessViewPanel;

    @Override
    public void prepareAndOpenFrame() {
        MainFrame mf=applicationContext.getBean(MainFrame.class);
        String header=mf.getMenuProcessDesign().getText();
        mf.getCustTabbedPane().addOrSelectTab(header,null, designProcessViewPanel.getClass(),null,
                true);

        JCustButton btn=designProcessViewPanel.getBtnDesignProcess();
        if(!btn.isListening()){
            registerButtonAction(btn,e->{
                onDesignProcess();
            });
            btn.setListening(true);
        }
    }

    private void onDesignProcess() {
        JTablePanel panel=designProcessViewPanel.getTablePanel();
        String content="hashcode是:"+panel.hashCode();
        JOptionPane.showMessageDialog(null, content, "警告",
                JOptionPane.WARNING_MESSAGE, null);
    }

    @Autowired
    DesignProcessViewController(JDesignProcessViewPanel designProcessViewPanel){
        this.designProcessViewPanel = designProcessViewPanel;
    }



}
