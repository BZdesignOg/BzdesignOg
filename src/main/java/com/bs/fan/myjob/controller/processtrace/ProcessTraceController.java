package com.bs.fan.myjob.controller.processtrace;

import com.bs.fan.myjob.controller.AbstractFrameController;
import com.bs.fan.myjob.ui.JCustButton;
import com.bs.fan.myjob.ui.MainFrame;
import com.bs.fan.myjob.ui.processtrace.JProcessTraceViewPanel;
import com.bs.fan.myjob.ui.processtrace.ProcessTraceChartPanel;
import com.bs.fan.myjob.util.DateUtil;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.*;
import java.io.IOException;

import static com.bs.fan.myjob.util.ReflectUtil.class$;

@Controller
public class ProcessTraceController extends AbstractFrameController {
    private JProcessTraceViewPanel processTraceViewPanel;

    @Override
    public void prepareAndOpenFrame() {

        MainFrame mf = applicationContext.getBean(MainFrame.class);
        String header = mf.getMenuProcessTrace().getText();
        mf.getCustTabbedPane().addOrSelectTab(header, null, processTraceViewPanel.getClass(), null,
                true);

        //添加事件处理
        JCustButton btnTraceProcess = processTraceViewPanel.getBtnGenerateChart();
        if (!btnTraceProcess.isListening()) {
            registerButtonAction(btnTraceProcess, e -> {
                onTraceProcess();
            });
            btnTraceProcess.setListening(true);/*test*/
        }

        JCustButton btnSaveChart = processTraceViewPanel.getBtnSaveChart();
        if (!btnSaveChart.isListening()) {
            registerButtonAction(btnSaveChart, e -> {
                onSaveChart();
            });
            btnSaveChart.setListening(true);
        }


    }

    private void onSaveChart() {

        ProcessTraceChartPanel ptcp = (ProcessTraceChartPanel) processTraceViewPanel.getComponentByName("processTraceChartPanel");
        ChartPanel cp1 = (ChartPanel) ptcp.getComponentByName("cp1");
        try {
            cp1.doSaveAs();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void onTraceProcess() {
        ChartPanel chartPanel = createTimeSeriesChartPanel();
        processTraceViewPanel.addChartPanel(chartPanel, "s1");
        processTraceViewPanel.getProcessTraceChartPanel().revalidate();//重绘图区
    }

    private ChartPanel createTimeSeriesChartPanel() {

        return new ChartPanel(createTimeSeriesChart(), true);
    }

    private XYDataset createDataset() {

        Class class$org$jfree$data$time$Second = null;

        TimeSeries timeseries = new TimeSeries(
                "L&G European Index Trust",
                class$org$jfree$data$time$Second != null?class$org$jfree$data$time$Second:
        (class$org$jfree$data$time$Second = class$("org.jfree.data.time.Second")));

//        timeseries.addOrUpdate(new Second(1,1,2019), 181.8);

        timeseries.addOrUpdate(new Second(DateUtil.dateByString("20191207174723")), 254);
        timeseries.addOrUpdate(new Second(DateUtil.dateByString("20191208113441")), 271);
        timeseries.addOrUpdate(new Second(DateUtil.dateByString("20191208113442")), 265);
        timeseries.addOrUpdate(new Second(DateUtil.dateByString("20191208113448")), 259);
        timeseries.addOrUpdate(new Second(DateUtil.dateByString("20191208113451")), 249);
        timeseries.addOrUpdate(new Second(DateUtil.dateByString("20191208113454")), 264);
        timeseries.addOrUpdate(new Second(DateUtil.dateByString("20191212153500")), 271);
        timeseries.addOrUpdate(new Second(DateUtil.dateByString("20191222232957")), 275);
        timeseries.addOrUpdate(new Second(DateUtil.dateByString("20191223120047")), 243);



        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries);

        return timeseriescollection;

    }


    private JFreeChart createTimeSeriesChart() {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "屈服强度趋势",
                "日期",
                "屈服强度",
                createDataset(),//data
                true,//legend?
                true,//general tooltips
                false//general urls
        );

        //显示中文
        XYPlot plot=chart.getXYPlot();//获取图表区域对象
        Axis domainAxis=plot.getDomainAxis();     //水平底部列表
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12)); //垂直标题
        domainAxis.setLabelFont(new Font("黑体", Font.BOLD,14));     //水平底部标题
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
//显示数据点
        XYLineAndShapeRenderer xyLineAndShapeRenderer= (XYLineAndShapeRenderer) plot.getRenderer();
        xyLineAndShapeRenderer.setBaseLinesVisible(true);
        xyLineAndShapeRenderer.setBaseShapesFilled(false);
        xyLineAndShapeRenderer.setBaseShapesVisible(true);

        return chart;
    }


    @Autowired
    ProcessTraceController(JProcessTraceViewPanel processTraceViewPanel) {
        this.processTraceViewPanel = processTraceViewPanel;
    }
}
