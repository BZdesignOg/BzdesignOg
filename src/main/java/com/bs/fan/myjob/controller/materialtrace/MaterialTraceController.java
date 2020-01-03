package com.bs.fan.myjob.controller.materialtrace;

import com.bs.fan.myjob.controller.AbstractFrameController;
import com.bs.fan.myjob.model.MaterialTraceData;
import com.bs.fan.myjob.service.IMaterialTraceService;
import com.bs.fan.myjob.ui.JCustButton;
import com.bs.fan.myjob.ui.SwingWorkerProxy;
import com.bs.fan.myjob.ui.materialtrace.JMaterialTraceViewPanel;
import com.bs.fan.myjob.ui.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

@Controller
public class MaterialTraceController extends AbstractFrameController {

    @Autowired
    protected IMaterialTraceService materialTraceService;

    private JMaterialTraceViewPanel materialTraceViewPanel;

    @Override
    public void prepareAndOpenFrame() {

        MainFrame mf = applicationContext.getBean(MainFrame.class);
        String header = mf.getMenuMaterialTrace().getText();
        mf.getCustTabbedPane().addOrSelectTab(header, null, materialTraceViewPanel.getClass(), null,
                true);
        //事件处理
        JCustButton btnTracePath = materialTraceViewPanel.getBtnTracePath();
        if (!btnTracePath.isListening()) {
            registerButtonAction(btnTracePath, e -> {
                onTracePath();
                btnTracePath.setListening(true);
            });
        }

        JCustButton btnTraceProcess = materialTraceViewPanel.getBtnTraceProcess();
        if (!btnTraceProcess.isListening()) {
            registerButtonAction(btnTraceProcess, e -> {
                onTraceProcess();
            });
            btnTraceProcess.setListening(true);
        }
    }

    private void onTraceProcess() {

    }

    private void onTracePath()  {

        String strCoilno=materialTraceViewPanel.getMaterialNo();

        if(StringUtils.isEmpty(strCoilno.trim())){
            JOptionPane.showMessageDialog(null, "请输入查询材料号", "提示",
                JOptionPane.WARNING_MESSAGE, null);
            return;
        }
//启动一个工作线程查询数据
        materialTraceViewPanel.getBtnTracePath().setEnabled(false);
        SwingWorkerProxy<MaterialTraceData> worker=new SwingWorkerProxy<MaterialTraceData>(){
            @Override
            protected List<MaterialTraceData> triggerData() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
                return materialTraceService.getTraceDataByCoilno(strCoilno);
            }
            @Override
            protected void updateAfterDone(List<MaterialTraceData> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

                materialTraceViewPanel.getBtnTracePath().setEnabled(true);
                if(CollectionUtils.isEmpty(data))
                    return;
                ///填充数据
                try {
                    materialTraceViewPanel.getTablePanel().fillTable(Collections.singletonList(data));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }finally {
                }
            }
        };
        worker.work();


    }

    @Autowired
    MaterialTraceController(JMaterialTraceViewPanel materialTraceViewPanel) {
        this.materialTraceViewPanel = materialTraceViewPanel;
    }
}
