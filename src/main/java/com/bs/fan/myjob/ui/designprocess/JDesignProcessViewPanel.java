package com.bs.fan.myjob.ui.designprocess;


import com.bs.fan.myjob.ui.BorderPaneDescription;
import com.bs.fan.myjob.ui.JBaseBorderView;
import com.bs.fan.myjob.ui.JCustButton;
import com.bs.fan.myjob.ui.JTablePanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.*;

@Component
public class JDesignProcessViewPanel extends JBaseBorderView {

    private DesignProcessSearchByPanel designProcessSearchByPanel;
    private DesignProcessCmdPanel designProcessCmdPanel;
    private JTablePanel tablePanel;

    @Autowired
    public JDesignProcessViewPanel(DesignProcessSearchByPanel designProcessSearchByPanel,
                                   DesignProcessCmdPanel designProcessCmdPanel,
                                   JTablePanel tablePanel){
        this.designProcessSearchByPanel = designProcessSearchByPanel;
        this.tablePanel=tablePanel;
        this.designProcessCmdPanel=designProcessCmdPanel;

        List<BorderPaneDescription> panels = new ArrayList<>();
        panels.add(new BorderPaneDescription("North", 100, "查询条件"));
        panels.add(new BorderPaneDescription("South", 40, ""));
        panels.add(new BorderPaneDescription("Center", 0, "设计工艺清单"));
        panels.add(new BorderPaneDescription("East", 600, "材质性能分析"));
        generatePanels(panels);

        add(designProcessSearchByPanel,null,"North");
        add(tablePanel,null,"Center");
        add(designProcessCmdPanel,null,"South");
    }

//    protected void rowsSelected(int[] rows) {
////        super.rowsSelected(rows);
//        int row = rows[0];
//        JTable table = tablePanel.getResultTable();
//        MechanicFourIndex mti = new MechanicFourIndex();
//
//        int colThick = tablePanel.getColumnIdxByName("合同厚度");
//        int colSteel = tablePanel.getColumnIdxByName("出钢记号");
//        int colSgCode = tablePanel.getColumnIdxByName("钢级");
//        int colLn = tablePanel.getColumnIdxByName("产线族");
//
//        mti.setOrderThick(table.getValueAt(row, colThick).toString());
//        mti.setOrderSteel(table.getValueAt(row, colSteel).toString());
//        mti.setOrderSgCode(table.getValueAt(row, colSgCode).toString());
//        mti.setSignLineNo(table.getValueAt(row, colLn).toString());
//
//        setBufferCurrentMechannicFourIndex(mti);
//        resetStatisticLabels();
//        if (refreshUIByLocalData(mti)) {
//            return;
//        }
//
//        if (workerMech != null && !workerMech.isDone() && !workerMech.isCancelled()) {
//            ((JLabel) getComponentByName("lblMessage")).setText("查询太频繁！请稍等...");
//            return;
//        }
//        workerMech = new SwingWorker<List<MechanicAndProcessData>, Object>() {
//            @Override
//            protected List<MechanicAndProcessData> doInBackground() throws Exception {
//                return null;
//            }
//
//            @Override
//            protected void done() {
//                try {
//                    ((JLabel) getComponentByName("lblMessage")).setText("完成获取性能数据");
//                    List<MechanicAndProcessData> list = get();
//                    bufferLocalMechanicData.put(mti, list);
//                    setBufferCurrentRenderedMechanicCoils(list);
//                    refreshMechStatUI();
//                    //刷新过程数据
//                    refreshProcessData(list);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    ((JLabel) getComponentByName("lblMessage")).setText(e.getClass().getSimpleName());
//                } catch (ExecutionException | InvocationTargetException | IllegalAccessException e) {
//                    ((JLabel) getComponentByName("lblMessage")).setText(e.getClass().getSimpleName());
//                    e.printStackTrace();
//                }
//            }
//        };
//        ((JLabel) getComponentByName("lblMessage")).setText("准备获取性能数据");
//        workerMech.execute();
//
//    }
//
//    private void refreshPercentageUI() throws InvocationTargetException, IllegalAccessException {
//
//
//        Map<String, List<Float>> map = generateDataMap();
//        if (map == null) return;
//
//        float[] valueArray = new float[4];//4cols;
//        Percentile percentile = new Percentile(); // 百分位数
//
//        double[] values = listDoubleTransfer(map.get("0"));
//        valueArray[0] = (float) percentile.evaluate(values, percentage);
//        values = listDoubleTransfer(map.get("1"));
//        valueArray[1] = (float) percentile.evaluate(values, percentage);
//        values = listDoubleTransfer(map.get("9"));
//        valueArray[2] = (float) percentile.evaluate(values, percentage);
//        values = listDoubleTransfer(map.get("a"));
//        valueArray[3] = (float) percentile.evaluate(values, percentage);
//
//        for (int i = 0; i < 4; i++) {
//            ((JLabel) getComponentByName("lbl6" + (i + 1))).setText(dfStat.format(valueArray[i]));
//        }
//
//    }
//
//    //本视图局部变量
//    private Long timeCount;
//    private DecimalFormat dfStat = new DecimalFormat("#0.0");//默认的统计区数据格式
//    private Map<String, String> nameToFieldMap = new HashMap<>();
//    private Map<MechanicFourIndex, List<MechanicAndProcessData>> bufferLocalMechanicData =
//            new HashMap<>();//缓存机械性能数据,避免重复远程查询.
//    private List<MechanicAndProcessData> bufferCurrentRenderedMechanicCoils = null;//当前渲染的机械性能数据
//    private MechanicFourIndex bufferCurrentMechannicFourIndex = null;
//    private int percentage = 10;
//    private SwingWorker<List<MechanicAndProcessData>, Object> workerMech = null;//机械性能worker
//    //主体工艺worker。注意一个worker
//    // 只从事一类业务
//    private SwingWorkerProxy<MechanicAndProcessData> workerQuickMechanic = null;
//    private SwingWorker<List<MainProcessDesign>, Object> workerProcess = null;
//    private SwingWorkerProxy<MatTrackData> matTrackWorker = null;
//    private SwingWorkerProxy<ContinuousAnnealingParameters> annealWorker=null;
//    private SwingWorkerProxy<HotrollingParameters> hotrollWorker=null;
//    private SwingWorkerProxy<SteelMakingParameters> steelmakingWorker=null;
//    private SwingWorkerProxy<TensileTestOrder> tensileTestOrderWorker=null;
//    private SwingWorkerProxy<HardnessTestOrder> hardnessTestOrderWorker=null;
//
//    private ButtonGroup bg = new ButtonGroup();//选项组
//    protected JTablePanel tablePanel = null;
//
//    private String getCurrentMechItem() {//返回当前选定机械性能项目
//        return bg.getSelection().getActionCommand();
//    }
//
//    public List<MechanicAndProcessData> getBufferCurrentRenderedMechanicCoils() {
//        return bufferCurrentRenderedMechanicCoils;
//    }
//
//    public void setBufferCurrentRenderedMechanicCoils(List<MechanicAndProcessData> bufferCurrentRenderedMechanicCoils) {
//        this.bufferCurrentRenderedMechanicCoils = bufferCurrentRenderedMechanicCoils;
//    }
//
//    private List<MechanicAndProcessData> getBufferCoilMechanicSimpleByMFI(MechanicFourIndex mti) {
//        return bufferLocalMechanicData.get(mti);
//    }
//
//    public MechanicFourIndex getBufferCurrentMechannicFourIndex() {
//        return bufferCurrentMechannicFourIndex;
//    }
//
//    public void setBufferCurrentMechannicFourIndex(MechanicFourIndex mti) {
//        this.bufferCurrentMechannicFourIndex = mti;
//    }
//
//    public void refreshMechStatUI() throws InvocationTargetException, IllegalAccessException {
//        //刷新title显示.
//        JLabel lblTitle = (JLabel) getComponentByName("title");
//        lblTitle.setText(getBufferCurrentMechannicFourIndex().toString());
//        //
//        Map<String, List<Float>> map = generateDataMap();
//        if (map == null) return;
//        float[][] valueArray = generateLblValueArray(map);
//        //刷新数据显示
////        DecimalFormat df = new DecimalFormat("#0.0");//保留1位小数
//        for (int row = 0; row < 5; row++)
//            for (int col = 0; col < 4; col++) {
//                String name = "lbl" + (row + 1) + (col + 1);
//                JLabel label = (JLabel) getComponentByName(name);
//                label.setText(dfStat.format(valueArray[row][col]));
//            }
//        refreshPercentageUI();
//
//    }
//
//    private float[][] generateLblValueArray(Map<String, List<Float>> map) {
//        float[][] valueArray = new float[6][4];//6rows*4cols;
//        //第一行数据计算
//        valueArray[0][0] = map.get("0").size();
//        valueArray[0][1] = map.get("1").size();
//        valueArray[0][2] = map.get("9").size();
//        valueArray[0][3] = map.get("a").size();
//        //其他行数据计算
//        Min min = new Min();
//        Mean mean = new Mean();
//        Max max = new Max();
//        StandardDeviation standardDeviation = new StandardDeviation();//标准差
//        Percentile percentile = new Percentile(); // 百分位数
//
//        double[] values = listDoubleTransfer(map.get("0"));
//        valueArray[1][0] = (float) min.evaluate(values);
//        valueArray[2][0] = (float) mean.evaluate(values);
//        valueArray[3][0] = (float) max.evaluate(values);
//        valueArray[4][0] = (float) standardDeviation.evaluate(values);
//        valueArray[5][0] = (float) percentile.evaluate(values, 10);
//
//
//        values = listDoubleTransfer(map.get("1"));
//        valueArray[1][1] = (float) min.evaluate(values);
//        valueArray[2][1] = (float) mean.evaluate(values);
//        valueArray[3][1] = (float) max.evaluate(values);
//        valueArray[4][1] = (float) standardDeviation.evaluate(values);
//        valueArray[5][1] = (float) percentile.evaluate(values, 10);
//
//
//        values = listDoubleTransfer(map.get("9"));
//        valueArray[1][2] = (float) min.evaluate(values);
//        valueArray[2][2] = (float) mean.evaluate(values);
//        valueArray[3][2] = (float) max.evaluate(values);
//        valueArray[4][2] = (float) standardDeviation.evaluate(values);
//        valueArray[5][2] = (float) percentile.evaluate(values, 10);
//
//
//        values = listDoubleTransfer(map.get("a"));
//        valueArray[1][3] = (float) min.evaluate(values);
//        valueArray[2][3] = (float) mean.evaluate(values);
//        valueArray[3][3] = (float) max.evaluate(values);
//        valueArray[4][3] = (float) standardDeviation.evaluate(values);
//        valueArray[5][3] = (float) percentile.evaluate(values, 10);
//
//
//        return valueArray;
//    }
//
//    private double[] listDoubleTransfer(List<Float> dbs) {
//        double[] dbsx = new double[dbs.size()];
//        int i = 0;
//        for (Float db : dbs) {
//            dbsx[i++] = db.doubleValue();
//        }
//        return dbsx;
//    }
//
//    private Map<String, List<Float>> generateDataMap() throws InvocationTargetException,
//            IllegalAccessException {
//
//        List<MechanicAndProcessData> coils = getBufferCurrentRenderedMechanicCoils();
//        if (coils == null || coils.size() == 0) return null;
//        String item = getCurrentMechItem();
//
//        Map<String, List<Float>> map = new HashMap<>();
//        //头中尾，以及全部
//        map.put("0", new ArrayList<Float>());
//        map.put("1", new ArrayList<Float>());
//        map.put("9", new ArrayList<Float>());
//        map.put("a", new ArrayList<Float>());
//
//        String methName = null;
//        switch (item) {
//            case "屈服强度":
//                methName = "getRpstd";//默认是标准过的屈服强度
//                dfStat = new DecimalFormat("#0.0");
//                break;
//            case "抗拉强度":
//                methName = "getTs";
//                dfStat = new DecimalFormat("#0.0");
//                break;
//            case "延伸率":
//                methName = "getEl";
//                dfStat = new DecimalFormat("#0.0");
//                break;
//            case "硬度":
//                methName = "getHardness";
//                dfStat = new DecimalFormat("#0.0");
//                break;
//            case "n平均":
//                methName = "getNavg";
//                dfStat = new DecimalFormat("#0.00");
//                break;
//            case "r平均":
//                methName = "getRavg";
//                dfStat = new DecimalFormat("#0.00");
//                break;
//            case "r90":
//                methName = "getR90";
//                dfStat = new DecimalFormat("#0.00");
//                break;
//            case "n90":
//                methName = "getN90";
//                dfStat = new DecimalFormat("#0.00");
//                break;
//            case "屈服延伸率":
//                methName = "getYsEl";
//                dfStat = new DecimalFormat("#0.00");
//                break;
//            case "DeltaR":
//                methName = "getDeltaR";
//                dfStat = new DecimalFormat("#0.00");
//                break;
//        }
//
//        Class cls = MechanicAndProcessData.class;
//        Method methodItem = null;
//        Method methodPos = null;
//        try {
//            methodItem = cls.getDeclaredMethod(methName);
//            methodPos = cls.getDeclaredMethod("getSamplePosition");
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//
//        for (MechanicAndProcessData coil : coils) {
//            Object o = methodItem.invoke(coil);
//            Float v = Float.parseFloat(o.toString());
//            o = methodPos.invoke(coil);
//            String pos = o.toString();
//            if (v == 0.0) continue;//0值不算
//            map.get(pos).add(v);
//            map.get("a").add(v);
//        }
//
//        return map;
//    }
//
//    public JDesignProcessViewPanel() {
//
//        ////
//        List<BorderPaneDescription> panels = new ArrayList<>();
//        panels.add(new BorderPaneDescription("North", 170, "查询条件"));
//        panels.add(new BorderPaneDescription("South", 40, ""));
//        panels.add(new BorderPaneDescription("Center", 0, "查询结果"));
//        panels.add(new BorderPaneDescription("East", 400, "性能统计"));
//        generatePanels(panels);
//        //增加底部组件
//        JButton btnQuery = new JButton("查询");
//        add(btnQuery, "btnQuery", "South");
//        btnQuery.addActionListener(e -> {
//            doQueryMainProcess();
//        });//注册事件
//
//        JButton btnQueryQuick = new JButton("快速评估性能");
//        btnQueryQuick.setBackground(new Color(130, 210, 178));
//        add(btnQueryQuick, "btnQueryQuick", "South");
//        btnQueryQuick.setEnabled(false);
//        btnQueryQuick.addActionListener(e -> {
//            doQueryQuickMechanic();
//        });//注册事件
//
//        JButton btnQueryCancel = new JButton("取消查询");
//        add(btnQueryCancel, "btnQueryCancel", "South");
//        btnQueryCancel.addActionListener(e -> {
//            doCancelQuery();
//        });//注册事件
//
//        JButton btnHideShow = new JButton("显示/隐藏");
//        add(btnHideShow, "btnHideShow", "South");
//        btnHideShow.addActionListener(e -> {
//            doHideShow();
//        });//注册事件
//
//        JButton btnPoi = new JButton("导出数据");
//        btnPoi.setEnabled(false);
//        add(btnPoi, "btnPoi", "South");
//
//        btnPoi.addActionListener(e -> {
//            doPoi();
//        });//注册事件
//
//        JLabel labelMsg = new JLabel();
//        labelMsg.setForeground(new Color(0, 0, 255));
//        add(labelMsg, "lblMessage", "South");
//
//        //增加搜索条件组件
//        initSearchPanel();
//        //初始化右边组件
//        initEastPanel();
////   默认的DecimalFormat
//
//
//    }
//
//    private void doQueryQuickMechanic() {
//
//        JButton jb = (JButton) getComponentByName("btnQueryQuick");
//        MechanicFourIndex mfi = new MechanicFourIndex();
//
//
//        mfi.setSignLineNo(((JTextField) getComponentByName("line")).getText().trim());
//        mfi.setOrderSgCode(((JTextField) getComponentByName("sg")).getText().trim());
//        mfi.setOrderSteel(((JTextField) getComponentByName("steel")).getText().trim());
//        String thick = ((JTextField) getComponentByName("thick")).getText().trim();
//        thick = thick.isEmpty() ? "0.0" : thick;
//        mfi.setOrderThick(thick);
//
//        setBufferCurrentMechannicFourIndex(mfi);
//        if (refreshUIByLocalData(mfi)) {
//            return;
//        }
//
//        workerQuickMechanic = new SwingWorkerProxy<MechanicAndProcessData>() {
//            @Override
//            protected List<MechanicAndProcessData> triggerData() {
//                return null;
//            }
//
//            @Override
//            protected void updateAfterDone(List<MechanicAndProcessData> data) {
//
//                ((JLabel) getComponentByName("lblMessage")).setText("完成获取性能数据");
//                setBufferCurrentMechannicFourIndex(mfi);
//                bufferLocalMechanicData.put(mfi, data);
//                setBufferCurrentRenderedMechanicCoils(data);
//
//                try {
//                    refreshMechStatUI();//更新统计
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//
//                listenTextFields();
//                refreshProcessData(getBufferCurrentRenderedMechanicCoils());
//            }
//        };
//        resetStatisticLabels();
//        ((JLabel) getComponentByName("lblMessage")).setText("开始获取快速性能评估数据");
//        workerQuickMechanic.work();
//        jb.setEnabled(false);
//    }
//
//    private void refreshProcessData(List<MechanicAndProcessData> list) {
//
//        if (list == null || list.size() == 0) return;
//        //获得跟踪号
//        List<String> mattracknos = new ArrayList<>();
//        list.forEach(cms -> {
//            mattracknos.add(cms.getMatTrackNo());
//        });
//
//        matTrackWorker = new SwingWorkerProxy<MatTrackData>() {
//            @Override
//            protected List<MatTrackData> triggerData() {
//                return null;
//            }
//
//            @Override
//            protected void updateAfterDone(List<MatTrackData> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//                if (data != null && data.size() > 0) {
//                    //补全退火机组号、热轧机组号、热轧入口、出口数据
//                    //提取退火、热轧、炼钢查询条件
//                    Map<String,Set<String>> lineAndCodeAnneal=new HashMap<>(),
//                            lineAndCodeHotroll=new HashMap<>();
//                    Set<String> ponos=new HashSet<>();
//
//                    list.forEach(cms -> {
//                        //提取炼钢ponos
//                        ponos.add(cms.getPono());
//                        //提取退火与热轧
//                        data.forEach(mtd -> {
//                            if (cms.getMatTrackNo().equals(mtd.getTrackMatno())) {
////                                if (mtd.isAnnealMatTrackData()) {
////                                    cms.setAnnealUnit(mtd.getPreUnitcode());
////                                    addStringSetByKey(lineAndCodeAnneal,mtd.getPreUnitcode(),
////                                            mtd.getTrackMatno());
////                                }
////                                if (mtd.isHotMatTrackData()) {
////                                    cms.setHotUnit(mtd.getPreUnitcode());
////                                    cms.setHotMatNo(mtd.getOutMatno());
////                                    cms.setHotInMatNo(mtd.getInMatno());
////                                    addStringSetByKey(lineAndCodeHotroll,mtd.getPreUnitcode()+"I",
////                                            mtd.getOutMatno());//以热轧出口号查询热轧工艺
////                                }
//                            }
//                        });
//                    });
//                    //补全退火工艺实绩
//                    annealWorker=new SwingWorkerProxy<ContinuousAnnealingParameters>() {
//                        @Override
//                        protected List<ContinuousAnnealingParameters> triggerData()  {
//                            return null;
//                        }
//                        @Override
//                        protected void updateAfterDone(List<ContinuousAnnealingParameters> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//                            if(data!=null && data.size()>0){
//                                list.forEach(cms->{
//                                    data.forEach(ap->{
//                                        if(ap.getMatTrackNo().equals(cms.getMatTrackNo())){
//                                            cms.setAnnealCode(ap.getAnnealCode());
//                                            cms.setNextTensionAve(ap.getNextTensionAve());
//                                            cms.setPreTensionAve(ap.getPreTensionAve());
//                                            cms.setOaTempAve(ap.getOaTempAve());
//                                            cms.setRollForceAve(ap.getRollForceAve());
//                                            cms.setSfTempAve(ap.getSfTempAve());
//                                            cms.setSpeed(ap.getSpeed());
//                                            cms.setTpmRateAve(ap.getTpmRateAve());
//                                            cms.setPlanCode(ap.getPlanCode());
//                                            cms.setSfTempAveFur(ap.getSfTempAveFur());
//                                        }
//                                    });
//                                });
//                            }
//                            getComponentByName("btnDownload").setBackground(new Color(0,0,255));
//
//                        }
//                    };
//                    annealWorker.work();
//                    //补全热轧工艺实绩
//                    hotrollWorker=new SwingWorkerProxy<HotrollingParameters>() {
//                        @Override
//                        protected List<HotrollingParameters> triggerData()  {
//                            return null;
//                        }
//
//                        @Override
//                        protected void updateAfterDone(List<HotrollingParameters> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//                            if(data!=null&&data.size()>0) {
//                                list.forEach(cms -> {
//                                    data.forEach(hp -> {
//                                        if (hp.getMatNo().equals(cms.getHotMatNo())) {
//                                            cms.setColdPatternCode(hp.getColdPatternCode());
//                                            cms.setDischTempAct(hp.getDischTempAct());
//                                            cms.setTempCtAve(hp.getTempCtAve());
//                                            cms.setTempCtMax(hp.getTempCtMax());
//                                            cms.setTempCtMin(hp.getTempCtMin());
//                                            cms.setTempFmAve(hp.getTempFmAve());
//                                            cms.setTempFmMax(hp.getTempFmMax());
//                                            cms.setTempFmMin(hp.getTempFmMin());
//                                        }
//                                    });
//                                });
//                            }
//                            getComponentByName("btnDownload").setBackground(new Color(255,0,0));
//                        }
//                    };
//                    hotrollWorker.work();
//                    //补全炼钢工艺设计
//                    steelmakingWorker=new SwingWorkerProxy<SteelMakingParameters>() {
//                        @Override
//                        protected List<SteelMakingParameters> triggerData()  {
//                            return null;
//                        }
//
//                        @Override
//                        protected void updateAfterDone(List<SteelMakingParameters> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//                            if(data!=null&&data.size()>0) {
//                                list.forEach(cms -> {
//                                    data.forEach(sp -> {
//                                        if (sp.getPono().equals(cms.getPono())) {
//                                           cms.setEleAltAct(sp.getEleAltAct());
//                                           cms.setEleBAct(sp.getEleBAct());
//                                           cms.setEleCAct(sp.getEleCAct());
//                                           cms.setEleMnAct(sp.getEleMnAct());
//                                           cms.setEleNAct(sp.getEleNAct());
//                                           cms.setEleNbAct(sp.getEleNbAct());
//                                           cms.setEleOAct(sp.getEleOAct());
//                                           cms.setElePAct(sp.getElePAct());
//                                           cms.setEleSAct(sp.getEleSAct());
//                                           cms.setEleSiAct(sp.getEleSiAct());
//                                           cms.setEleTiAct(sp.getEleTiAct());
//                                        }
//                                    });
//                                });
//                            }
//                            getComponentByName("btnDownload").setBackground(new Color(0,255,0));
//                        }
//                    };
//                    steelmakingWorker.work();
//                }
//            }
//        };
//        matTrackWorker.work();
//    }
//
//    private void addStringSetByKey(Map<String,Set<String>> map,String key,String value){
//        if(map.get(key)==null){
//            Set<String> set=new HashSet<>();
//            set.add(value);
//            map.put(key,set);
//        }else {
//            map.get(key).add(value);
//        }
//    }
//
//    private boolean refreshUIByLocalData(MechanicFourIndex mfi) {
//        List<MechanicAndProcessData> data = getBufferCoilMechanicSimpleByMFI(mfi);
//        if (data != null) {//如果本地能查到数据则更新UI，返回
//            ((JLabel) getComponentByName("lblMessage")).setText("本地数据，开始更新UI");
//            setBufferCurrentRenderedMechanicCoils(data);
//            try {
//                refreshMechStatUI();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//            return true;
//        }
//        return false;
//    }
//
//    private void initEastPanel() {
//        //指标选项
//        JPanel panelOption = new JPanel();
//        int dx = 10;
//        panelOption.setBorder(BorderFactory.createTitledBorder("指标选项"));
//        panelOption.setBounds(dx, 20, 400, 80);
//        panelOption.setBackground(new Color(196, 196, 196));
//        panelOption.setLayout(new BorderLayout());
//        add(panelOption, "options", "East");
//        //指标单选项
//        ActionListener al = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Object sourceObject = e.getSource();
//                if (sourceObject instanceof JRadioButton) {
//                    JRadioButton sourceButton = (JRadioButton) sourceObject;
//                    actionOfRadioClick(sourceButton.getText());
//                }
//            }
//        };
//        JRadioButton rb1 = new JRadioButton("屈服强度", true);
//        rb1.setActionCommand("屈服强度");
//
//        JRadioButton rb2 = new JRadioButton("抗拉强度");
//        rb2.setActionCommand("抗拉强度");
//
//        JRadioButton rb3 = new JRadioButton("延伸率");
//        rb3.setActionCommand("延伸率");
//
//        JRadioButton rb4 = new JRadioButton("硬度");
//        rb4.setActionCommand("硬度");
//
//        JRadioButton rb5 = new JRadioButton("n90");
//        rb5.setActionCommand("n90");
//
//        JRadioButton rb6 = new JRadioButton("r90");
//        rb6.setActionCommand("r90");
//
//        JRadioButton rb7 = new JRadioButton("n平均");
//        rb7.setActionCommand("n90");
//
//        JRadioButton rb8 = new JRadioButton("r平均");
//        rb8.setActionCommand("r90");
//
//        JRadioButton rb9 = new JRadioButton("屈服延伸率");
//        rb9.setActionCommand("屈服延伸率");
//
//        JRadioButton rb10 = new JRadioButton("DeltaR");
//        rb10.setActionCommand("DeltaR");
//
//        rb1.addActionListener(al);
//        rb2.addActionListener(al);
//        rb3.addActionListener(al);
//        rb4.addActionListener(al);
//        rb5.addActionListener(al);
//        rb6.addActionListener(al);
//        rb7.addActionListener(al);
//        rb8.addActionListener(al);
//        rb9.addActionListener(al);
//        rb10.addActionListener(al);
//
//        bg.add(rb1);
//        bg.add(rb2);
//        bg.add(rb3);
//        bg.add(rb4);
//        bg.add(rb5);
//        bg.add(rb6);
//        bg.add(rb7);
//        bg.add(rb8);
//        bg.add(rb9);
//        bg.add(rb10);
//
//        JPanel panel = new JPanel();
//        panel.add(rb1);
//        panel.add(rb2);
//        panel.add(rb3);
//        panel.add(rb4);
//        panel.add(rb5);
//        panel.add(rb6);
//        panel.add(rb7);
//        panel.add(rb8);
//        panel.add(rb9);
//        panel.add(rb10);
//        add(panel, "panel", "options");
//
//        //图表展示区
//        JPanel panelGraph = new JPanel();
//        panelGraph.setBorder(BorderFactory.createTitledBorder("图表"));
//        panelGraph.setBounds(dx, 110, 400, 230);
//        panelGraph.setBackground(new Color(196, 196, 196));
//        add(panelGraph, "graph", "East");
//        //统计展示区
//        JPanel panelStat = new JPanel();
//        panelStat.setBorder(BorderFactory.createTitledBorder("统计"));
//        panelStat.setBounds(dx, 350, 400, 240);
//        panelStat.setBackground(new Color(196, 196, 196));
//        panelStat.setLayout(null);
//        //格式化统计数据项目展示项
//
//
//        int startx = 90, starty = 70;
//        int lblW = 50, lblH = 20, lblIntW = 10, lblIntH = 10;
//        JLabel lbl = new JLabel("部位0");
//        lbl.setBounds(startx + lblW * 0, starty, lblW, lblH);
//        panelStat.add(lbl);
//        lbl = new JLabel("部位1");
//        lbl.setBounds(startx + lblW * 1 + lblIntW, starty, lblW, lblH);
//        panelStat.add(lbl);
//        lbl = new JLabel("部位9");
//        lbl.setBounds(startx + lblW * 2 + lblIntW, starty, lblW, lblH);
//        panelStat.add(lbl);
//        lbl = new JLabel("全部");
//        lbl.setBounds(startx + lblW * 3 + lblIntW, starty, lblW, lblH);
//        panelStat.add(lbl);
//        //统计item列印
//        int line = 1;
//        lbl = new JLabel("计数:");
//        lbl.setBounds(20, starty + line * lblH, lblW, lblH);
//        panelStat.add(lbl);
//        line++;
//        lbl = new JLabel("最小:");
//        lbl.setBounds(20, starty + line * (lblH), lblW, lblH);
//        panelStat.add(lbl);
//        line++;
//        lbl = new JLabel("均值:");
//        lbl.setBounds(20, starty + line * (lblH), lblW, lblH);
//        panelStat.add(lbl);
//        line++;
//        lbl = new JLabel("最大:");
//        lbl.setBounds(20, starty + line * (lblH), lblW, lblH);
//        panelStat.add(lbl);
//        line++;
//        lbl = new JLabel("标准差:");
//        lbl.setBounds(20, starty + line * (lblH), lblW, lblH);
//        panelStat.add(lbl);
//        line++;
//
//
//        add(panelStat, "stat", "East");
//
//        lbl = new JLabel(percentage + "百分位:");
//        lbl.setBounds(20, starty + line * (lblH), lblW + 15, lblH);
//        add(lbl, "lblPercentage", "stat");
//        //控制percentage的2个按钮
//        JButton btnUp = new JButton("+");
//        btnUp.setBounds(0, starty + line * (lblH), 15, 16);
//        JButton btnDown = new JButton("-");
//        btnDown.setBounds(0, starty + line * (lblH) + 16, 15, 16);
//        ActionListener listener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int max = 100;
//                int min = (int) (((float) (1 / getBufferCurrentRenderedMechanicCoils().size())) * 100);
//                if (min == 0) min = 1;
//                int tmp = percentage;
//                String txt = ((JButton) e.getSource()).getText();
//                if (txt.equals("+")) {
//                    if (tmp >= 90 || tmp <= 20)
//                        tmp += 1;
//                    else
//                        tmp += 5;
//                } else {
//                    if (tmp <= 20 || tmp >= 90)
//                        tmp -= 1;
//                    else
//                        tmp -= 5;
//                }
//                if (tmp > max || tmp < min) return;
//                percentage = tmp;
//                ((JLabel) getComponentByName("lblPercentage")).setText(percentage + "百分位:");
//                try {
//                    refreshPercentageUI();
//                } catch (InvocationTargetException e1) {
//                    e1.printStackTrace();
//                } catch (IllegalAccessException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        };
//        btnUp.addActionListener(listener);
//        btnDown.addActionListener(listener);
//
//        add(btnUp, null, "stat");
//        add(btnDown, null, "stat");
//
//        //生成6行*4列的label阵列
//        Color[] colors = new Color[]{
//                new Color(255, 0, 0),
//                new Color(204, 0, 255),
//                new Color(0, 102, 102),
//                new Color(0, 0, 255)
//        };
//        for (int i = 1; i <= 6; i++)
//            for (int j = 1; j <= 4; j++) {
//                JLabel label = new JLabel();
//                label.setForeground(colors[j - 1]);
//                label.setBounds(startx + (j - 1) * lblW + lblIntW,
//                        starty + i * lblH, lblW, lblH);
//                String name = "lbl" + i + j;
//                add(label, name, "stat");
//            }
//
//        //title
//        JLabel title = new JLabel();
//        title.setBounds(5, 30, 350, 30);
//        add(title, "title", "stat");
//        //download按钮
//        JButton btnDownload = new JButton("DL");
//        btnDownload.setBounds(220, 20, 20, 20);
//        add(btnDownload, "btnDownload", "stat");
//        btnDownload.addActionListener(e -> {
//            List<MechanicAndProcessData> bufferMech = getBufferCurrentRenderedMechanicCoils();
//            if (bufferMech == null || bufferMech.size() == 0) return;
//            String[] columnNames = getFieldNames(bufferMech.get(0));
//            Object[][] data = new Object[bufferMech.size()][columnNames.length];
//            for (int row = 0; row < data.length; row++) {
//                Object coil = bufferMech.get(row);
//                Class cls = coil.getClass();
//                for (int col = 0; col < data[row].length; col++) {
//                    String methodName = "get" + (columnNames[col].toUpperCase()).substring(0, 1) +
//                            columnNames[col].substring(1, columnNames[col].length());
//                    try {
//                        Method method = cls.getDeclaredMethod(methodName);
//                        data[row][col] = method.invoke(coil);
//                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            }
//            Date date = new Date();
//            SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
//            String fileName = format.format(date);
//
//
//            POIUtil.createXlsx(new File("d:\\" + fileName + "性能实绩.xls"), columnNames,
//                    data);
//        });
//    }
//
//    public void resetStatisticLabels() {
//        //复位统计性能数据
//        for (int i = 1; i <= 6; i++)
//            for (int j = 1; j <= 4; j++) {
//                JLabel label = (JLabel) getComponentByName("lbl" + i + j);
//                label.setText("0.0");
//            }
//        //复位title
//        JLabel title = (JLabel) getComponentByName("title");
//        title.setText("");
//        //复位按钮downLoad颜色
//        getComponentByName("btnDownload").setBackground(new Color(247,247,247));
//    }
//
//    private String[] getFieldNames(Object obj) {
//        Class cls = obj.getClass();
//        Field[] fields = cls.getDeclaredFields();
//        String[] names = new String[fields.length];
//        int i = 0;
//        for (Field fld : fields) {
//            names[i++] = fld.getName();
//        }
//
//        return names;
//    }
//
//    private void actionOfRadioClick(String name) {
//        try {
//            refreshMechStatUI();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void doCancelQuery() {
//        if (workerMech != null && !workerMech.isCancelled()) {
//
//            workerMech.cancel(true);
//            workerMech = null;
//
//        }
//    }
//
//    private void initSearchPanel() {
//
//
//        //初始化字段值
//        JComboBox cbField = new JComboBox<String>();
//        cbField.setSize(150, 30);
//        cbField.setLocation(20, 20);
//        String[] names = null;
//        String[] fields = null;
//        int i = 0;
////        for (String name : names) {
////            cbField.addItem(name);
////            nameToFieldMap.put(name, fields[i]);
////            i++;
////        }
//
//        //初始化操作符值
//        JComboBox cbOperator = new JComboBox<String>();
//        cbOperator.setSize(150, 30);
//        cbOperator.setLocation(180, 20);
//        cbOperator.addItem(">=");
//        cbOperator.addItem("=");
//        cbOperator.addItem("<=");
//        cbOperator.addItem(">");
//        cbOperator.addItem("<");
//        cbOperator.addItem("like");
//        cbOperator.addItem("in");
//        cbOperator.addItem("not in");
//        //值
//        JTextField txt = new JTextField(200);
//        txt.setSize(500, 30);
//        txt.setLocation(340, 20);
//        txt.setBackground(new Color(255, 235, 205));
//        txt.setForeground(new Color(255, 0, 100));
//        //选择结果展示列
//        JTextArea resultTxt = new JTextArea(20, 20);
//        resultTxt.setLocation(125, 60);
//        resultTxt.setSize(600, 100);
//        resultTxt.setBorder(new LineBorder(new Color(0, 0, 0)));
//        //按钮-新增条件
//        JButton btn = new JButton("增加条件");
//        btn.setLocation(20, 60);
//        btn.setSize(100, 30);
//        btn.addActionListener(e -> {
//            if (txt.getText().isEmpty())
//                return;
//            String strFieldValue = nameToFieldMap.get(cbField.getSelectedItem());
//            String a = strFieldValue + opAndValue(cbOperator.getSelectedItem().toString(), txt.getText(),
//                    isNum(strFieldValue));
//            resultTxt.append(a);
//            resultTxt.append("\n");
//
//        });
//
//        //按钮-删除条件
//        JButton btnDel = new JButton("删除条件");
//        btnDel.setLocation(735, 60);
//        btnDel.setSize(100, 30);
//        btnDel.addActionListener(e -> {
//            String strOrg = resultTxt.getText();
//            String[] rows = strOrg.split("\n");
//            resultTxt.setText("");
//            for (int x = 0; x < rows.length - 1; x++) {
//                resultTxt.append(rows[x]);
//                resultTxt.append("\n");
//            }
//        });
//        //按钮-复位条件
//        JButton btnDelAll = new JButton("清空条件");
//        btnDelAll.setLocation(735, 100);
//        btnDelAll.setSize(100, 30);
//        btnDelAll.addActionListener(e -> {
//            resultTxt.setText("");
//        });
//
//
//        JPanel panel = (JPanel) getComponentByName("North");
//        panel.add(cbField);
//        panel.add(cbOperator);
//        panel.add(txt);
//        panel.add(btn);
//        panel.add(btnDel);
//        panel.add(btnDelAll);
//        add(resultTxt, "resultTxt", "North");
//        ///增加快速查询条件
//
//        JPanel panelq = new JPanel();
//        TitledBorder border = BorderFactory.createTitledBorder("设置快速评估条件");
//        border.setTitleColor(new Color(214, 96, 244));
//        border.setTitleJustification(TitledBorder.CENTER);
//        panelq.setBackground(new Color(130, 210, 178));
//        panelq.setBorder(border);
//        panelq.setBounds(880, 20, 600, 130);
//        add(panelq, "panelq", "North");
//
//        panelq.setLayout(null);
//        JLabel lblThick = new JLabel("厚度:");
//        lblThick.setBounds(20, 20, 50, 30);
//        add(lblThick, "lblThick", "panelq");
//
//        JTextField thick = new JTextField(10);
//        thick.setBounds(72, 20, 50, 30);
//        add(thick, "thick", "panelq");
//
//        JLabel lblSt = new JLabel("出钢记号:");
//        lblSt.setBounds(225, 20, 100, 30);
//        add(lblSt, "lblSt", "panelq");
//
//        JTextField steel = new JTextField(20);
//        steel.setBounds(327, 20, 100, 30);
//        add(steel, "steel", "panelq");
//
//        JLabel lblSg = new JLabel("钢级:");
//        lblSg.setBounds(225, 70, 150, 30);
//        add(lblSg, "lblSg", "panelq");
//        JTextField sg = new JTextField(20);
//        sg.setBounds(327, 70, 100, 30);
//        add(sg, "sg", "panelq");
//
//        JLabel lblLine = new JLabel("产线族:");
//        lblLine.setBounds(20, 55, 50, 30);
//        add(lblLine, "lblLine", "panelq");
//        JTextField line = new JTextField(20);
//        line.setBounds(72, 70, 50, 30);
//        add(line, "line", "panelq");
//
//        //增加公共监听器
//        DocumentListener dl = new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                listenTextFields();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                listenTextFields();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//            }
//        };
//        sg.getDocument().addDocumentListener(dl);
//        steel.getDocument().addDocumentListener(dl);
////       thick.getDocument().addDocumentListener(dl);
//        line.getDocument().addDocumentListener(dl);
//
//    }
//
//    private void listenTextFields() {
//
//        if (workerQuickMechanic != null &&
//                workerQuickMechanic.isWorking()) return;
//
//        JTextField sg = (JTextField) getComponentByName("sg");
//        boolean bSg = !sg.getText().trim().isEmpty();
//        JTextField steel = (JTextField) getComponentByName("steel");
//        boolean bSteel = !steel.getText().trim().isEmpty();
//        JTextField thick = (JTextField) getComponentByName("thick");
//        boolean bThick = !thick.getText().trim().isEmpty();
//        JTextField line = (JTextField) getComponentByName("line");
//        boolean bLine = !line.getText().trim().isEmpty();
//
//        if (bLine && bSg && bSteel) {
//            ((JButton) getComponentByName("btnQueryQuick")).setEnabled(true);
//        } else
//            ((JButton) getComponentByName("btnQueryQuick")).setEnabled(false);
//    }
//
//    private boolean isNum(String field) {
//        String[] fieldNum = null;
//        List<String> fields = new ArrayList<>(Arrays.asList(fieldNum));
//        return fields.contains(field);
//
//    }
//
//    private String opAndValue(String op, String value, boolean isNum) {
//        StringBuffer sb = new StringBuffer();
//        sb.append(" ");
//        sb.append(op);
//        sb.append(" ");
//        if (op.equals("in") || op.equals("not in")) {
//            sb.append("(");
//            String[] vals = value.split("[,\\s]");//逗号或空格split
//            for (String val : vals) {
//                sb.append("'");
//                sb.append(val);
//                sb.append("'");
//                sb.append(",");
//            }
//            sb.deleteCharAt(sb.lastIndexOf(","));
//            sb.append(")");
//        } else {
//            if (!isNum) {
//                sb.append("'");
//                sb.append(value);
//                sb.append("'");
//            } else {
//                sb.append(value);
//            }
//
//        }
//
//        return sb.toString();
//    }
//
//    private void doPoi() {
//
//        JTablePanel table = (JTablePanel) getComponentByName("tablePanel");
//        Object[][] dat = table.getData();
//        String[] columnNames = table.getColumnNames();
//
//        Date date = new Date();
//
//        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
//        String fileName = format.format(date);
//
//        String mfis = bufferCurrentMechannicFourIndex.getOrderSgCode() + "_" +
//                bufferCurrentMechannicFourIndex.getOrderSteel() + "_" +
//                bufferCurrentMechannicFourIndex.getSignLineNo() + "_" +
//                bufferCurrentMechannicFourIndex.getOrderThick();
//        System.out.println(mfis);
//        //创建目录
////        File file=new File("d:/myjobs/mainprocs/");
////        file.mkdir();
//        POIUtil.createXlsx(new File("d:/" + mfis + "工艺设计实绩" +
//                        ".xls"),
//                columnNames,
//                dat);
//
//    }
//
//    private void doHideShow() {
//        boolean visible = getComponentByName("North").isVisible();
//        boolean visible1 = getComponentByName("East").isVisible();
//        setPanelVisible("North", !visible);
//        setPanelVisible("East", !visible1);
//    }
//
//    @Override
//    protected void initDefaultLayout() {
//        super.initDefaultLayout();
//    }
//
//
//    private void doQueryMainProcess() {
//        //复位导出按钮
//        getComponentByName("btnPoi").setEnabled(false);
//        //获取查询条件
//        JTextArea txtArea = (JTextArea) getComponentByName("resultTxt");
//        String[] strings = txtArea.getText().split("\n");
//
//        if (strings.length == 1 && strings[0].isEmpty()) {
//            JLabel label = (JLabel) getComponentByName("lblMessage");
//            label.setForeground(new Color(255, 0, 0));
//            label.setText("请设置查询条件！");
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(" ");
//        for (String s : strings) {
//            sb.append(s);
//            sb.append(" and ");
//        }
//        sb.delete(sb.lastIndexOf("and"), sb.length() - 1);
//
//        // 指派一个worker线程查询数据
//
//        workerProcess = new SwingWorker<List<MainProcessDesign>, Object>() {
//
//            @Override
//            protected List<MainProcessDesign> doInBackground()
//                    throws Exception {
//                // TODO Auto-generated method stub
//
//                 List<MainProcessDesign> list=null;
//
//
//                return list;
//
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
//
//                    if (isCancelled()) {
//                        ((JLabel) (getComponentByName("lblMessage"))).setText("查询取消");
//                        getComponentByName("btnQuery").setEnabled(true);
//                        return;
//                    }
//                    List<MainProcessDesign> mainProcessDesigns = get();
//                    //更新poi按钮状态
//                    getComponentByName("btnPoi").setEnabled(mainProcessDesigns.size() > 0);
//                    //统计查询结果
//                    timeCount = (System.currentTimeMillis() - timeCount) / 1000;
//                    JLabel label = (JLabel) getComponentByName("lblMessage");
//                    label.setForeground(new Color(68, 136, 109));
//                    label.setText("查询成功!" + "花时" + timeCount + "秒," + "共获得" + mainProcessDesigns.size() + "条记录.");
//
//                    //填充表格数据
//                    if (tablePanel == null) {
//                        tablePanel = new JTablePanel() {
//                            @Override
//                            protected void rowSelected(int[] rowIdxs) {
//                                rowsSelected(rowIdxs);
//                            }
//
//                            @Override
//                            protected void initHeaderNames() {
//                                //初始化列表头
//                                headerNamesMap.put("orderNo", "合同号");
//                                headerNamesMap.put("orderStatus", "合同状态");
//                                headerNamesMap.put("orderThick", "合同厚度");
//                                headerNamesMap.put("signCode", "钢级");
//                                headerNamesMap.put("signLineNo", "产线族");
//                                headerNamesMap.put("stNo", "出钢记号");
//                                headerNamesMap.put("annealDiagramCode", "退火曲线号");
//                                headerNamesMap.put("controlTemp", "控制温度");
//                                headerNamesMap.put("oakTempAim", "退火温度目标");
//                                headerNamesMap.put("tpmRateAim", "平整率目标");
//                                headerNamesMap.put("annealUnit", "退火机组");
//                                headerNamesMap.put("sgStd", "订货标准");
//                                headerNamesMap.put("orderWidth", "合同宽度");
//                                headerNamesMap.put("orderInnerDia", "合同内径");
//                                headerNamesMap.put("orderDeliveryDate", "交货期");
//                                headerNamesMap.put("sgSign", "牌号");
//                                headerNamesMap.put("orderWt", "订货重量");
//                                headerNamesMap.put("psr", "PSR");
//                                headerNamesMap.put("mic", "MIC");
//                                headerNamesMap.put("apn", "APN");
//                                headerNamesMap.put("finUserName", "订货用户");
//                                headerNamesMap.put("heatTempAim", "热轧加热温度");
//                                headerNamesMap.put("afftTempAim", "热轧终轧温度");
//                                headerNamesMap.put("coilTempAim", "热轧卷曲温度");
//                                headerNamesMap.put("hotUnit", "热轧机组");
//                                headerNamesMap.put("sprayCtrlModeCode", "层冷代码");
//                                headerNamesMap.put("hotThick", "热轧厚度");
//                                headerNamesMap.put("deformRate", "变形量");
//                                headerNamesMap.put("idxNoQ1", "拉伸试验");
//                                headerNamesMap.put("idxNoQ6", "冷弯试验");
//                                headerNamesMap.put("idxNoQ8", "硬度试验");
//                                headerNamesMap.put("dynCtIdx", "热轧动态CT");
////                                hideFields.add("orderNo");
////                                hideFields.add("dynCtIdx");
////                                hideFields.add("idxNoQ8");
////                                hideFields.add("idxNoQ6");
////                                hideFields.add("idxNoQ1");
////                                hideFields.add("deformRate");
////                                hideFields.add("hotThick");
////                                hideFields.add("sprayCtrlModeCode");
////                                hideFields.add("hotUnit");
////                                hideFields.add("coilTempAim");
////                                hideFields.add("afftTempAim");
////                                hideFields.add("finUserName");
////                                hideFields.add("orderStatus");
////                                hideFields.add("controlTemp");
////                                hideFields.add("tpmRateAim");
////                                hideFields.add("sgStd");
////                                hideFields.add("oakTempAim");
//                            }
//                        };
//                        getComponentByName("Center").setLayout(new BorderLayout());
//                        add(tablePanel, "tablePanel", "Center");
//                    }
//                    tablePanel.fillTable(Collections.singletonList(mainProcessDesigns));
//                    getComponentByName("btnQuery").setEnabled(true);
//
//
//                } catch (InterruptedException | ExecutionException e) {
//                    // TODO Auto-generated catch block
////                    String message = e.getClass().getSimpleName();
//                    String message = "数据库连接失败或查询语句错误！";
//                    JLabel label = (JLabel) getComponentByName("lblMessage");
//                    label.setForeground(new Color(255, 0, 0));
//                    label.setText("查询失败!" + message);
//                    getComponentByName("btnQuery").setEnabled(true);
//
//                    e.printStackTrace();
//                } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                } finally {
//                    getComponentByName("btnQuery").setEnabled(true);
//                }
//
//            }
//        };
//
//        JLabel label = (JLabel) getComponentByName("lblMessage");
//        label.setForeground(new Color(0, 0, 255));
//        label.setText("开始查询...");
//
//        if (tablePanel != null) tablePanel.removeAllRows();
//        getComponentByName("btnQuery").setEnabled(false);
//        timeCount = System.currentTimeMillis();
//        workerProcess.execute();
//    }
//
//    private JLabel getStatLabel(int row, int col) {
//        String name = "lbl" + Integer.toString(row) + Integer.toString(col);
//        return (JLabel) getComponentByName(name);
//
//    }


    public DesignProcessSearchByPanel getDesignProcessSearchByPanel() {
        return designProcessSearchByPanel;
    }

    public void setDesignProcessSearchByPanel(DesignProcessSearchByPanel designProcessSearchByPanel) {
        this.designProcessSearchByPanel = designProcessSearchByPanel;
    }

    public JTablePanel getTablePanel() {
        return tablePanel;
    }

    public void setTablePanel(JTablePanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    public JCustButton getBtnDesignProcess(){
        return designProcessCmdPanel.getBtnDesignProcess();
    }
}
