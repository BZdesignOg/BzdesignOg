package com.bs.fan.myjob.ui.processtrace;

import com.bs.fan.myjob.ui.BorderPaneDescription;
import com.bs.fan.myjob.ui.JBaseBorderView;
import com.bs.fan.myjob.ui.JCustButton;
import org.jfree.chart.ChartPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component//向spring注册bean
public class JProcessTraceViewPanel extends JBaseBorderView {

    private ProcessTraceCmdPanel processTraceCmdPanel;
    private ProcessTraceChartPanel processTraceChartPanel;

    @Autowired
    JProcessTraceViewPanel(ProcessTraceCmdPanel processTraceCmdPanel,ProcessTraceChartPanel processTraceChartPanel){
        this.processTraceCmdPanel=processTraceCmdPanel;
        this.processTraceChartPanel=processTraceChartPanel;

        List<BorderPaneDescription> panels = new ArrayList<>();
        panels.add(new BorderPaneDescription("North", 200, "跟踪目标产品定义"));
        panels.add(new BorderPaneDescription("South", 40, ""));
        panels.add(new BorderPaneDescription("Center", 0, "一页纸结果"));
        generatePanels(panels);

        add(processTraceCmdPanel,null,"South");
        add(processTraceChartPanel,null,"Center");

    }

    public JCustButton getBtnGenerateChart(){
        return processTraceCmdPanel.getBtnGenerateChart();
    }
    public JCustButton getBtnSaveChart(){return processTraceCmdPanel.getBtnSaveChart();}

    public ProcessTraceChartPanel getProcessTraceChartPanel() {
        return processTraceChartPanel;
    }

    public ChartPanel getChartPanelByName(String name){
        return (ChartPanel) processTraceChartPanel.getComponentByName(name);
    }
    public void addChartPanel(ChartPanel chartPanel,String name){
        processTraceChartPanel.add(chartPanel,name);
    }
}
