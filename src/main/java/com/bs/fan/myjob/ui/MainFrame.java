package com.bs.fan.myjob.ui;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;


@Component
public class MainFrame extends JFrame  {

    //菜单
    private JMenuItem menuProcessDesign;
    private JMenuItem menuSteelCompare;
    private JMenuItem menuMaterialTrace;
    private JMenuItem menuChemTrace;
    private JMenuItem menuOrderTrace;
    private JMenuItem menuProductComplainReport;
    private JMenuItem menuAbout;

    private JMenuItem menuProcessTrace;

    private JCustTabbedPane custTabbedPane;



    //构造函数注入
    @Autowired
    public MainFrame(JCustTabbedPane custTabbedPane) {
        this.custTabbedPane=custTabbedPane;
        //设置内容区布局
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(custTabbedPane);
    }



    public void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu appMenu = new JMenu("一贯制工艺查询");
        menuBar.add(appMenu);
        // 增加菜单子项
        menuProcessDesign = new JMenuItem("工艺设计历史");
        appMenu.add(menuProcessDesign);


        JMenu designMenu = new JMenu("质量设计辅助");
        menuBar.add(designMenu);
        // 增加菜单子项
        menuSteelCompare = new JMenuItem("出钢记号比对");
        designMenu.add(menuSteelCompare);


        JMenu manuMenu = new JMenu("制造技术");
        menuBar.add(manuMenu);
        // 增加菜单子项
        menuMaterialTrace= new JMenuItem("材料追溯");
        manuMenu.add(menuMaterialTrace);
        menuChemTrace = new JMenuItem("成份监控");
        manuMenu.add(menuChemTrace);

        menuOrderTrace=new JMenuItem("合同跟踪");
        manuMenu.add(menuOrderTrace);

        manuMenu.addSeparator();

        menuProcessTrace=new JMenuItem("一页纸过程跟踪");
        manuMenu.add(menuProcessTrace);



        JMenu complainMenu = new JMenu("异议调查");
        menuBar.add(complainMenu);
        // 增加菜单子项
        menuProductComplainReport= new JMenuItem("异议报告生成");
        complainMenu.add(menuProductComplainReport);

        JMenu aboutMenu = new JMenu("关于");
        menuBar.add(aboutMenu);
        // 增加菜单子项

        menuAbout = new JMenuItem("About...");
        aboutMenu.add(menuAbout);

    }

    public JMenuItem getMenuProcessDesign() {
        return menuProcessDesign;
    }

    public JMenuItem getMenuSteelCompare() {
        return menuSteelCompare;
    }

    public JMenuItem getMenuMaterialTrace() {
        return menuMaterialTrace;
    }

    public JMenuItem getMenuChemTrace() {
        return menuChemTrace;
    }

    public JMenuItem getMenuOrderTrace() {
        return menuOrderTrace;
    }

    public JMenuItem getMenuProductComplainReport() {
        return menuProductComplainReport;
    }

    public JMenuItem getMenuAbout() {
        return menuAbout;
    }

    public JCustTabbedPane getCustTabbedPane() {
        return custTabbedPane;
    }

    public JMenuItem getMenuProcessTrace() {
        return menuProcessTrace;
    }
}
