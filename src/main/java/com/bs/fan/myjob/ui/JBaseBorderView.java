package com.bs.fan.myjob.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class JBaseBorderView extends JCustPanel {


    final public static String NORTH_PANEL = BorderLayout.NORTH;
    final public static String SOUTH_PANEL = BorderLayout.SOUTH;
    final public static String CENTER_PANEL = BorderLayout.CENTER;
    final public static String EAST_PANEL = BorderLayout.EAST;
    final public static String WEST_PANEL = BorderLayout.WEST;

    protected void generatePanels(List<BorderPaneDescription> innerPanels) {

        setLayout(new BorderLayout());

        for (BorderPaneDescription bpd : innerPanels) {
            Dimension dimension = new Dimension();
            if (bpd.position.equals("North") || bpd.position.equals("South")) {
                dimension.setSize(0, bpd.size);
            } else if (bpd.position.equals("West") || bpd.position.equals("East")) {
                dimension.setSize(bpd.size, 0);
            }
            JCustPanel panel = new JCustPanel();
            panel.setBorder(BorderFactory.createTitledBorder(bpd.title));
            panel.setPreferredSize(dimension);
            add(panel, bpd.position, null);
        }

        initDefaultLayout();

    }

    /**
     * 默认构造函数：默认设置各区块尺寸和标题
     */

    public JBaseBorderView() {
//
        List<BorderPaneDescription> defaultPanels = new ArrayList<>();
        defaultPanels.add(new BorderPaneDescription("North", 200, "查询条件"));
        defaultPanels.add(new BorderPaneDescription("Center", 200, "查询结果列表"));
        defaultPanels.add(new BorderPaneDescription("South", 40, ""));
        defaultPanels.add(new BorderPaneDescription("East", 400, "详细信息"));
//
        generatePanels(defaultPanels);

//        setCursor(new Cursor( Cursor.E_RESIZE_CURSOR));



    }

    /*
     *
     */
    public void setPanelVisible(String name, boolean visible) {
        getComponentByName(name).setVisible(visible);
        doLayout();
    }



    public void add(JComponent component, String name, String to) {

        JComponent toComp = null;

        if (to != null) {
            toComp = getComponentByName(to);
            toComp.add(component);
        } else {
            add(name, component);
        }


        map.put(name, component);
    }


    protected void initDefaultLayout() {
        JComponent comp;
        //North-平铺布局
        if ((comp = getComponentByName("North")) != null) {
            comp.setLayout(new BorderLayout());
        }
        //South-
        if ((comp = getComponentByName("South")) != null) {
            comp.setLayout(new BorderLayout());
        }
        //East-平铺布局
        if ((comp = getComponentByName("East")) != null) {
            comp.setLayout(new BorderLayout());
        }
        //Center-平铺布局
        if ((comp = getComponentByName("Center")) != null) {
            comp.setLayout(new BorderLayout());
        }

    }


}
