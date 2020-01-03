package com.bs.fan.myjob.controller.mainframe;

import com.bs.fan.myjob.controller.AbstractFrameController;
import com.bs.fan.myjob.controller.designprocess.DesignProcessViewController;
import com.bs.fan.myjob.controller.materialtrace.MaterialTraceController;
import com.bs.fan.myjob.controller.processtrace.ProcessTraceController;
import com.bs.fan.myjob.ui.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.*;

@Controller
public class MainFrameController extends AbstractFrameController {

    private MainFrame mainFrame;
    private DesignProcessViewController designProcessViewController;
    private MaterialTraceController materialTraceController;
    private ProcessTraceController processTraceController;

    @Override
    public void prepareAndOpenFrame() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setState(Frame.NORMAL);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setTitle("产品设计辅助工具-SpringBoot&Maven&Mybatis");
        mainFrame.initMenu();
        //事件处理
        registerMenuItemAction(mainFrame.getMenuAbout(),e->{onAbout();});
        registerMenuItemAction(mainFrame.getMenuChemTrace(),e->{onChemTrace();});
        registerMenuItemAction(mainFrame.getMenuMaterialTrace(),e->{onMaterialTrace();});
        registerMenuItemAction(mainFrame.getMenuOrderTrace(),e->{onOrderTrace();});
        registerMenuItemAction(mainFrame.getMenuProcessDesign(),e->{onProcessDesign();});
        registerMenuItemAction(mainFrame.getMenuProductComplainReport(),
                e->{onProductComplainReport();});
        registerMenuItemAction(mainFrame.getMenuSteelCompare(),e->{onSteelCompare();});
        registerMenuItemAction(mainFrame.getMenuProcessTrace(),e->{onProcessTrace();});


        mainFrame.setVisible(true);

    }

    private void onProcessTrace() {
        processTraceController.prepareAndOpenFrame();
    }

    private void onSteelCompare() {
    }

    private void onProductComplainReport() {
    }

    private void onProcessDesign() {
//        mainFrame.getCustTabbedPane().addOrSelectTab(
//                mainFrame.getMenuProcessDesign().getText(),
//                null, JMainProcessDesignView.class,null,true
//        );
        designProcessViewController.prepareAndOpenFrame();
    }

    private void onOrderTrace() {
    }

    private void onMaterialTrace() {
        materialTraceController.prepareAndOpenFrame();
    }

    private void onChemTrace() {
    }

    private void onAbout() {
    }

    @Autowired
    public MainFrameController(MainFrame mainFrame){
        this.mainFrame=mainFrame;
    }

    @Autowired
    public void setDesignProcessViewController(DesignProcessViewController designProcessViewController) {
        this.designProcessViewController = designProcessViewController;
    }

    @Autowired
    public void setMaterialTraceController(MaterialTraceController materialTraceController) {
        this.materialTraceController = materialTraceController;
    }

    @Autowired
    public void setProcessTraceController(ProcessTraceController processTraceController) {
        this.processTraceController = processTraceController;
    }
}
