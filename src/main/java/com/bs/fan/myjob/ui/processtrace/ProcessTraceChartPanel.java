package com.bs.fan.myjob.ui.processtrace;

import com.bs.fan.myjob.ui.JCustPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class ProcessTraceChartPanel extends JCustPanel {
    private TimeSeries total;
    private TimeSeries free;

    static Class class$org$jfree$data$time$Millisecond;

    public class DataGenerator extends Timer implements ActionListener {

        public DataGenerator(int i) {
            super(i, null);
            addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            long l = Runtime.getRuntime().freeMemory();
            long l_0_ = Runtime.getRuntime().totalMemory();

            ProcessTraceChartPanel.this.addTotalObservation((double) l_0_);
            ProcessTraceChartPanel.this.addFreeObservation((double) l);

        }

    }

    public void addChart(ChartPanel chartPanel,String name){
        add(chartPanel);
        map.put(name,chartPanel);
    }

    public ProcessTraceChartPanel() {
        setLayout(new GridLayout(2,3));
//        total = new TimeSeries(
//                "Total Memory",
//                (class$org$jfree$data$time$Millisecond == null ?
//                        (class$org$jfree$data$time$Millisecond = class$("org.jfree.data.time.Millisecond"))
//                        : class$org$jfree$data$time$Millisecond));
//        total.setMaximumItemAge((long) i);
//        free = new TimeSeries(
//                "Free Memory",
//                (class$org$jfree$data$time$Millisecond == null ?
//                        (class$org$jfree$data$time$Millisecond=class$("org.jfree.data.time.Millisecond")):
//        class$org$jfree$data$time$Millisecond ));
//        free.setMaximumItemAge((long) i);
//        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
//        timeseriescollection.addSeries(total);
//        timeseriescollection.addSeries(free);
//        DateAxis dateaxis = new DateAxis("Time");
//        NumberAxis numberaxis = new NumberAxis("Memory");
//        dateaxis.setTickLabelFont(new Font("SansSerif", 0, 12));
//        numberaxis.setTickLabelFont(new Font("SansSerif", 0, 12));
//        dateaxis.setLabelFont(new Font("SansSerif", 0, 14));
//        numberaxis.setLabelFont(new Font("SansSerif", 0, 14));
//        XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(
//                true, false);
//        xylineandshaperenderer.setSeriesPaint(0, Color.red);
//        xylineandshaperenderer.setSeriesPaint(1, Color.green);
//        xylineandshaperenderer.setSeriesStroke(0, new BasicStroke(3.0F, 0, 2));
//        xylineandshaperenderer.setSeriesStroke(1, new BasicStroke(3.0F, 0, 2));
//        XYPlot xyplot = new XYPlot(timeseriescollection, dateaxis, numberaxis,
//                xylineandshaperenderer);
//        xyplot.setBackgroundPaint(Color.lightGray);
//        xyplot.setDomainGridlinePaint(Color.white);
//        xyplot.setRangeGridlinePaint(Color.white);
//        xyplot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
//        dateaxis.setAutoRange(true);
//        dateaxis.setLowerMargin(0.0);
//        dateaxis.setUpperMargin(0.0);
//        dateaxis.setTickLabelsVisible(true);
//        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//
//        JFreeChart jf1 = new JFreeChart("JVM1", new Font(
//                "SansSerif", 1, 24), xyplot, true);
//        jf1.setBackgroundPaint(Color.white);
//        ChartPanel cp1 = new ChartPanel(jf1, true);
//        cp1.setBorder(BorderFactory.createCompoundBorder(BorderFactory
//                .createEmptyBorder(4, 4, 4, 4), BorderFactory
//                .createLineBorder(Color.black)));
//
//        JFreeChart jf2=new JFreeChart("JVM2", new Font(
//                "SansSerif", 1, 24), xyplot, true);
//        ChartPanel cp2=new ChartPanel(jf2,false);
//        cp2.setBorder(BorderFactory.createCompoundBorder(BorderFactory
//                .createEmptyBorder(4, 4, 4, 4), BorderFactory
//                .createLineBorder(Color.black)));
//
//
//        JFreeChart jf3=new JFreeChart("JVM3", new Font(
//                "SansSerif", 1, 24), xyplot, true);
//        ChartPanel cp3=new ChartPanel(jf3,false);
//        cp3.setBorder(BorderFactory.createCompoundBorder(BorderFactory
//                .createEmptyBorder(4, 4, 4, 4), BorderFactory
//                .createLineBorder(Color.black)));
//
//        JFreeChart jf4=new JFreeChart("JVM4", new Font(
//                "SansSerif", 1, 24), xyplot, true);
//        ChartPanel cp4=new ChartPanel(jf4,false);
//        cp4.setBorder(BorderFactory.createCompoundBorder(BorderFactory
//                .createEmptyBorder(4, 4, 4, 4), BorderFactory
//                .createLineBorder(Color.black)));
//
//        JFreeChart jf5=new JFreeChart("JVM5", new Font(
//                "SansSerif", 1, 24), xyplot, true);
//        ChartPanel cp5=new ChartPanel(jf5,false);
//        cp5.setBorder(BorderFactory.createCompoundBorder(BorderFactory
//                .createEmptyBorder(4, 4, 4, 4), BorderFactory
//                .createLineBorder(Color.black)));
//
//        JFreeChart jf6=new JFreeChart("JVM6", new Font(
//                "SansSerif", 1, 24), xyplot, true);
//        ChartPanel cp6=new ChartPanel(jf6,false);
//        cp6.setBorder(BorderFactory.createCompoundBorder(BorderFactory
//                .createEmptyBorder(4, 4, 4, 4), BorderFactory
//                .createLineBorder(Color.black)));
//
//        add(cp1);
//        map.put("cp1",cp1);
//
//        add(cp2);
//        map.put("cp2",cp2);
//
//        add(cp3);
//        map.put("cp3",cp3);

    }

    private void addTotalObservation(double d){
        total.add(new Millisecond(),d);
    }

    private void addFreeObservation(double d){
        free.add(new Millisecond(),d);
    }


}
