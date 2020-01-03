package com.bs.fan.myjob.ui.materialtrace;


import com.bs.fan.myjob.model.*;
import com.bs.fan.myjob.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.*;
import java.util.List;

@Component
//@Scope("prototype") //多例模式：设置为动态创建，每调用一次当前类就创建一次.
// 这个地方不能用多例模式，否则，其中的组件会被覆盖。
@Lazy //设置为懒加载
public class JMaterialTraceViewPanel extends JBaseBorderView {

    private MaterialTraceSearchByPanel materialTraceSearchByPanel;
    private MaterialTraceCmdPanel materialTraceCmdPanel;
    private JTablePanel tablePanel;
    ////////////
    private Long timeCount;
    protected List<MatTrackData> trackDataList = null;
    protected SwingWorkerProxy<ContinuousAnnealingParameters> resultingContinuousAnnealProcessWorker = null;
    protected SwingWorkerProxy<HotrollingParameters> resultingHotrollProcessWorker =null;
    protected SwingWorkerProxy<SteelMakingParameters> resultingSteelMakingProcessWorker=null;
    protected SwingWorkerProxy<BatchAnnealingParmameters> resultingBatchAnnealProcessWorker=null;

    @Autowired
    public JMaterialTraceViewPanel(MaterialTraceSearchByPanel materialTraceSearchByPanel,
                                   MaterialTraceCmdPanel materialTraceCmdPanel) {
        this.materialTraceSearchByPanel=materialTraceSearchByPanel;
        this.materialTraceCmdPanel=materialTraceCmdPanel;
        this.tablePanel=new JTablePanel(){
            @Override
            protected void initHeaderNames() {
                //初始化列表头
                headerNamesMap.put("inMatno", "入口卷号");
                headerNamesMap.put("matThick", "材料厚度");
                headerNamesMap.put("matWeight", "卷重");
                headerNamesMap.put("matWidth", "宽度");
                headerNamesMap.put("orderNo", "合同号");
                headerNamesMap.put("outMatno", "出口卷号");
                headerNamesMap.put("preUnitcode", "前工序");
                headerNamesMap.put("controlTemp", "控制温度");
                headerNamesMap.put("prodEndtime", "生成时间");
                headerNamesMap.put("sgSign", "牌号");
                headerNamesMap.put("stNo", "出钢记号");
                headerNamesMap.put("trackMatno", "材料跟踪号");
                hideFields.add("trackMatno");//隐藏材料跟踪号
            }
        };



        List<BorderPaneDescription> panels = new ArrayList<>();
        panels.add(new BorderPaneDescription("North", 150, "查询条件"));
        panels.add(new BorderPaneDescription("South", 40, ""));
        panels.add(new BorderPaneDescription("Center", 0, "查询结果"));
        panels.add(new BorderPaneDescription("East", 600, "工艺追溯"));
        generatePanels(panels);

        add(materialTraceSearchByPanel,null,"North");
        add(materialTraceCmdPanel,null,"South");
        add(this.tablePanel,null,"Center");
//        JLabel lblCoilno = new JLabel("输入材料号:");
//        lblCoilno.setBounds(20, 20, 100, 20);// left x,left y,width,height
//        add(lblCoilno, "lblCoilno", "North");
//        JTextField textCoilno = new JTextField();
//        textCoilno.setBounds(125, 40, 150, 30);
//        add(textCoilno, "textCoilno", "North");

//        //增加底部组件
//        JButton btnQuery = new JButton("查询");
//        add(btnQuery, "btnQuery", "South");
//        btnQuery.addActionListener(e -> {
//            doQueryProducePath();
//        });//注册事件
//
//        JButton btnQueryProcess = new JButton("查询一贯制工艺");
//        btnQueryProcess.setEnabled(false);
//        add(btnQueryProcess, "btnQueryProcess", "South");
//        btnQueryProcess.addActionListener(e -> {
//            doQueryResultingProcess();
//        });//注册事件
//
//        JLabel labelMsg = new JLabel();
//        add(labelMsg, "lblMessage", "South");
//
//        //增加搜索条件
//        JLabel lblCoilno = new JLabel("输入材料号:");
//        lblCoilno.setBounds(20, 20, 100, 20);// left x,left y,width,height
//        add(lblCoilno, "lblCoilno", "North");
//        JTextField textCoilno = new JTextField();
//        textCoilno.setBounds(125, 40, 150, 30);
//        add(textCoilno, "textCoilno", "North");

    }

    public JCustButton getBtnTracePath(){
        return materialTraceCmdPanel.getBtnTracePath();
    }

    public JCustButton getBtnTraceProcess(){
        return materialTraceCmdPanel.getBtnTraceProcess();
    }

    public MaterialTraceSearchByPanel getMaterialTraceSearchByPanel() {
        return materialTraceSearchByPanel;
    }

    public MaterialTraceCmdPanel getMaterialTraceCmdPanel() {
        return materialTraceCmdPanel;
    }
    public String getMaterialNo(){
        return materialTraceSearchByPanel.getMaterialNo();
    }

//    private void addResultingProcess(String title, JPanel panel) {
//        //获得右边East内comp的个数
//        JPanel east = (JPanel) getComponentByName("East");
//        int n = east.getComponentCount();
//        int width = east.getWidth() - 20;
//        int height = east.getHeight() / 4;
//
//
//        panel.setBackground(new Color(192, 192, 192));
//        panel.setBorder(BorderFactory.createTitledBorder(title));
////        try {
////            ((JTablePanel) panel).setRowColor(1, new Color(0, 233, 0));
////        } catch (OutOfRowIndexException e) {
////            e.printStackTrace();
////        }
//
//        panel.setBounds(2, 20 + n * height, width, height);
//        add(panel, "panel", "East");
//
//        east.revalidate();
////        east.repaint();
//
//    }
//
//    private String getAnnealUnitCode() {
//        if (trackDataList != null) {
//            for (MatTrackData mtd : trackDataList) {
//                String s = mtd.getPreUnitcode().substring(2);
//                if (s.equals("12") || s.equals("22") || s.equals("08")) {
//                    return mtd.getPreUnitcode();
//                }
//            }
//        }
//        return "";
//    }
//
//    private MatTrackData getSteelMakingTrackData(){
//        if (trackDataList != null) {
//            for (MatTrackData mtd : trackDataList) {
//                String s = mtd.getPreUnitcode();
//                if (s.equals("S001")||s.equals("S002")||s.equals("S005") ) {
//                    return mtd;
//                }
//            }
//        }
//        return null;
//    }
//
//    private MatTrackData getAnnealingTrackData(){
//        if (trackDataList != null) {
//            for (MatTrackData mtd : trackDataList) {
//                String s = mtd.getPreUnitcode();
//                if (s.substring(2).equals("12")||s.equals("C103")) {
//                    return mtd;
//                }
//            }
//        }
//        return null;
//    }
//
//    private MatTrackData getHotrollingTrackData(){
//        if (trackDataList != null) {
//            for (MatTrackData mtd : trackDataList) {
//                String s = mtd.getPreUnitcode();
//                if (s.equals("H032")||s.equals("H033")||s.equals("H031") ) {
//                    return mtd;
//                }
//            }
//        }
//        return null;
//    }
//
//    private void doQueryHotrollingResultingProcess() {
//        MatTrackData mtd=getHotrollingTrackData();
//        if(mtd==null)return;
//
//        if (resultingHotrollProcessWorker != null && resultingHotrollProcessWorker.isWorking()) {
//            ((JLabel) getComponentByName("lblMessage")).setText("查询太频繁！请稍等...");
//            return;
//        }
//        resultingHotrollProcessWorker=new SwingWorkerProxy<HotrollingParameters>() {
//            @Override
//            protected List<HotrollingParameters> triggerData()  {
//                return null;
//            }
//
//            @Override
//            protected void updateAfterDone(List<HotrollingParameters> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//
//                if (data != null) {
//                    JTablePanel tablePanel = new JTablePanel() {
//                        @Override
//                        protected void initHeaderNames() {
//                            headerNamesMap.put("dischTempAct","出炉温度实绩");
//                            headerNamesMap.put("tempFmMax","FT_最大");
//                            headerNamesMap.put("tempFmMin","FT_最小");
//                            headerNamesMap.put("tempFmAve","FT_平均");
//                            headerNamesMap.put("tempCtMax","CT_最大");
//                            headerNamesMap.put("tempCtMin","CT_最小");
//                            headerNamesMap.put("tempCtAve","CT_平均");
//                            headerNamesMap.put("coldPatternCode","层冷");
//                            headerNamesMap.put("matNo","热卷号");
//                            headerNamesMap.put("planNo","热轧计划号");
//                            headerNamesMap.put("recCreateTime","创建时间");
//                            headerNamesMap.put("slabNo","板坯号");
//                        }
//                    };
//                    tablePanel.fillTable(Collections.singletonList(data));
//                    addResultingProcess("热轧工艺", tablePanel);
//                }
//                ((JLabel) getComponentByName("lblMessage")).setText("热轧工艺追溯完毕！");
//                getComponentByName("btnQuery").setEnabled(true);
//
//            }
//        };
//
//        ((JLabel) getComponentByName("lblMessage")).setText("热轧工艺追溯开始...");
//        getComponentByName("btnQuery").setEnabled(false);//追溯期，禁止查询履历
//        resultingHotrollProcessWorker.work();
//
//    }
//
//    private void doQuerySteelMakingResultingProcess() {
//        MatTrackData mtd=getSteelMakingTrackData();
//        if(mtd==null)return;
//        if (resultingSteelMakingProcessWorker != null && resultingSteelMakingProcessWorker.isWorking()) {
//            ((JLabel) getComponentByName("lblMessage")).setText("查询太频繁！请稍等...");
//            return;
//        }
//        resultingSteelMakingProcessWorker=new SwingWorkerProxy<SteelMakingParameters>() {
//            @Override
//            protected List<SteelMakingParameters> triggerData()  {
//                return null;
//            }
//            @Override
//            protected void updateAfterDone(List<SteelMakingParameters> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//                if(data!=null){
//                    System.out.println(data.size());
//                    JTablePanel tablePanel=new JTablePanel(){
//                        @Override
//                        protected void initHeaderNames() {
//                            headerNamesMap.put("pono","pono号");
//                            headerNamesMap.put("slabNo","板坯号");
//                            headerNamesMap.put("stNo","出钢记号");
//                        }
//                    };
//                    tablePanel.fillTable(Collections.singletonList(data));
//                    addResultingProcess("炼钢工艺", tablePanel);
//                }
//                ((JLabel) getComponentByName("lblMessage")).setText("炼钢工艺追溯完毕！");
//                getComponentByName("btnQuery").setEnabled(true);
//            }
//        };
//
//        ((JLabel) getComponentByName("lblMessage")).setText("炼钢工艺追溯开始...");
//        getComponentByName("btnQuery").setEnabled(false);//追溯期，禁止查询履历
//        resultingSteelMakingProcessWorker.work();
//
//    }
//
//
//    private void doQueryAnnealResultingProcess() {
//        //查询退火工艺
//        MatTrackData mtd = getAnnealingTrackData();
//        if (mtd==null) return;
//
//        if(mtd.getPreUnitcode().equals("C103")){
//            if(resultingBatchAnnealProcessWorker!=null&&resultingBatchAnnealProcessWorker.isWorking()){
//                return;
//            }
//
//            resultingBatchAnnealProcessWorker=new SwingWorkerProxy<BatchAnnealingParmameters>() {
//                @Override
//                protected List<BatchAnnealingParmameters> triggerData()  {
//                    return null;
//                }
//
//                @Override
//                protected void updateAfterDone(List<BatchAnnealingParmameters> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//                    if(data!=null&&data.size()>0){
//                        JTablePanel tablePanel=new JTablePanel(){
//                            @Override
//                            protected void initHeaderNames() {
//                                headerNamesMap.put("position", "装炉位置");
//                                headerNamesMap.put("designAnnealingDiagramCode","设计曲线");
//                                headerNamesMap.put("matNo","卷号");
//                                headerNamesMap.put("planNo","计划号");
//                                headerNamesMap.put("sign","牌号");
//                                headerNamesMap.put("socketNo","炉台号");
//                                headerNamesMap.put("thick","厚度");
//                                headerNamesMap.put("width","宽度");
//                                headerNamesMap.put("weight","卷重");
//                            }
//                        };
//                        tablePanel.fillTable(Collections.singletonList(data));
//                        addResultingProcess("罩退装炉情况", tablePanel);
//                    }
//                    ((JLabel) getComponentByName("lblMessage")).setText("罩退追溯完毕！");
//                    getComponentByName("btnQuery").setEnabled(true);
//                }
//            };
//
//            ((JLabel) getComponentByName("lblMessage")).setText("退火工艺追溯开始...");
//            getComponentByName("btnQuery").setEnabled(false);//追溯期，禁止查询履历
//            resultingBatchAnnealProcessWorker.work();
//
//            return;
//        }
//
//        if (resultingContinuousAnnealProcessWorker != null && resultingContinuousAnnealProcessWorker.isWorking()) {
//            ((JLabel) getComponentByName("lblMessage")).setText("查询太频繁！请稍等...");
//            return;
//        }
//
//        resultingContinuousAnnealProcessWorker = new SwingWorkerProxy<ContinuousAnnealingParameters>() {
//            @Override
//            protected List<ContinuousAnnealingParameters> triggerData() {
//                return null;
//            }
//
//            @Override
//            protected void updateAfterDone(List<ContinuousAnnealingParameters> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//                if (data != null) {
//                    JTablePanel tablePanel = new JTablePanel() {
//                        @Override
//                        protected void initHeaderNames() {
//                            headerNamesMap.put("annealCode", "实际退火曲线号");
//                            headerNamesMap.put("matNo", "出口材料号");
//                            headerNamesMap.put("matTrackNo", "材料跟踪号");
//                            headerNamesMap.put("nextTensionAve", "后张均值");
//                            headerNamesMap.put("preTensionAve", "前张均值");
//                            headerNamesMap.put("oaTempAve", "OA温度均值");
//                            headerNamesMap.put("planCode", "生产计划号");
//                            headerNamesMap.put("rollForceAve", "平整轧制力均值");
//                            headerNamesMap.put("sfTempAve", "退火温度实绩");
//                            headerNamesMap.put("speed", "退火速度实绩");
//                            headerNamesMap.put("tpmRateAve", "平整率实绩");
//                            hideFields.add("matTrackNo");
//                        }
//                    };
//                    tablePanel.fillTable(Collections.singletonList(data));
//                    addResultingProcess("连退工艺", tablePanel);
//                }
//                ((JLabel) getComponentByName("lblMessage")).setText("退火工艺追溯完毕！");
//                getComponentByName("btnQuery").setEnabled(true);
//
//            }
//        };
//        ((JLabel) getComponentByName("lblMessage")).setText("退火工艺追溯开始...");
//        getComponentByName("btnQuery").setEnabled(false);//追溯期，禁止查询履历
//        resultingContinuousAnnealProcessWorker.work();
//    }
//
//    private void doQueryResultingProcess() {
//
//        //获得材料跟踪号
//
//        Set<String> trackNos = new HashSet<>();
//        if (trackDataList != null) {
//            trackDataList.forEach(a -> {
//                trackNos.add(a.getTrackMatno());
//            });
//        }
//        List<String> trackNos1 = new ArrayList<>(trackNos);
//        if (trackNos1.size() == 0) return;
//        //查询热轧工艺-根据热轧卷号
//        doQueryHotrollingResultingProcess();
//        //查询退火工艺-根据材料跟踪号(BA根据卷号)
//        doQueryAnnealResultingProcess();
//
//        //查询炼钢工艺
//        doQuerySteelMakingResultingProcess();
//
//    }
//
//    @Override
//    protected void initDefaultLayout() {
//        super.initDefaultLayout();
//
//    }
//
//
//    private void resetResultingProcess() {
//
//        if (tablePanel != null) tablePanel.removeAllRows();
//        trackDataList = null;
//
//        JPanel east = (JPanel) getComponentByName("East");
//        int cnt = east.getComponentCount();
//        while (cnt > 0) {
//            east.remove(cnt - 1);
//            cnt--;
//        }
//        east.repaint();
//    }
//
//    private String getCoilno() {
//        String coilNo = null;
//        JTextField textField = (JTextField) getComponentByName("textCoilno");
//        if (textField != null) {
//            coilNo = textField.getText();
//        }
//
//        return coilNo == null ? "" : coilNo;
//
//    }
//
//    protected void doQueryProducePath() {
//
//
//        if (getCoilno().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "请设置查询参数", "警告",
//                    JOptionPane.WARNING_MESSAGE, null);
//            return;
//        }
//
//        //清空右侧内容
//        resetResultingProcess();
//
//
//        // 指派一个worker线程查询数据
//        SwingWorker<List<MatTrackData>, Object> worker = new SwingWorker<List<MatTrackData>, Object>() {
//
//            @Override
//            protected List<MatTrackData> doInBackground()
//                    throws Exception {
//                // TODO Auto-generated method stub
//
//                return null;
//            }
//
//            @Override
//            protected void process(List<Object> arg0) {
//                // TODO Auto-generated method stub
//                super.process(arg0);
//            }
//
//            @Override
//            protected void done() {
//                // TODO Auto-generated method stub
//                // super.done();
//                try {
//                    trackDataList = get();
//
//                    JLabel label = (JLabel) getComponentByName("lblMessage");
//                    timeCount = (System.currentTimeMillis() - timeCount) / 1000;
//
//                    label.setForeground(new Color(68, 136, 109));
//                    label.setText("查询成功!" + "花时" + timeCount + "秒," + "共获得" + trackDataList.size() + "条记录.");
//
//                    getComponentByName("btnQuery").setEnabled(true);
//                    if (trackDataList.size() >= 2)
//                        getComponentByName("btnQueryProcess").setEnabled(true);
//                    if (tablePanel == null) {
//                        tablePanel = new JTablePanel() {
//                            @Override
//                            protected void initHeaderNames() {
//                                //初始化列表头
//                                headerNamesMap.put("inMatno", "入口卷号");
//                                headerNamesMap.put("matThick", "材料厚度");
//                                headerNamesMap.put("matWeight", "卷重");
//                                headerNamesMap.put("matWidth", "宽度");
//                                headerNamesMap.put("orderNo", "合同号");
//                                headerNamesMap.put("outMatno", "出口卷号");
//                                headerNamesMap.put("preUnitcode", "前工序");
//                                headerNamesMap.put("controlTemp", "控制温度");
//                                headerNamesMap.put("prodEndtime", "生成时间");
//                                headerNamesMap.put("sgSign", "牌号");
//                                headerNamesMap.put("stNo", "出钢记号");
//                                headerNamesMap.put("trackMatno", "材料跟踪号");
//                                hideFields.add("trackMatno");//隐藏材料跟踪号
//                            }
//                        };
//                        getComponentByName("Center").setLayout(new BorderLayout());
//                        add(tablePanel, "tablePanel", "Center");
//                    }
//
//                    tablePanel.fillTable(Collections.singletonList(trackDataList));
//                    getComponentByName("btnQuery").setEnabled(true);
//
//
//                } catch (InterruptedException | ExecutionException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//                    // TODO Auto-generated catch block
//                    String message = e.getMessage();
//
//                    JLabel label = (JLabel) getComponentByName("lblMessage");
//                    label.setForeground(new Color(255, 0, 0));
//                    label.setText("查询失败!" + message);
//                    getComponentByName("btnQuery").setEnabled(true);
//                    getComponentByName("btnQueryProcess").setEnabled(false);
////                    removeAllRows();
//                    e.printStackTrace();
//                } finally {
//                    getComponentByName("btnQuery").setEnabled(true);
//                }
//            }
//        };
//        JLabel label = (JLabel) getComponentByName("lblMessage");
//        label.setText("开始查询...");
//
//        getComponentByName("btnQuery").setEnabled(false);
//        getComponentByName("btnQueryProcess").setEnabled(false);
//        timeCount = System.currentTimeMillis();
//        worker.execute();
//
//    }

    public void setMaterialTraceSearchByPanel(MaterialTraceSearchByPanel materialTraceSearchByPanel) {
        this.materialTraceSearchByPanel = materialTraceSearchByPanel;
    }

    public void setMaterialTraceCmdPanel(MaterialTraceCmdPanel materialTraceCmdPanel) {
        this.materialTraceCmdPanel = materialTraceCmdPanel;
    }

    public JTablePanel getTablePanel() {
        return tablePanel;
    }

    public void setTablePanel(JTablePanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    public JTextArea getText(){
        return tablePanel.getText();
    }
}
