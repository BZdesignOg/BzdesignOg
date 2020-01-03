package com.bs.fan.myjob.ui;

import org.springframework.stereotype.Repository;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JAboutDialog extends JDialog {

    public JAboutDialog() {
        super();
        setSize(new Dimension(500, 300));
        setResizable(false);
        setModal(true);
        setLocation(100, 100);
        setTitle("About...");

        setLayout(null);

        JLabel label=new JLabel("Programmer：" +
                "fanyanghua，2019年." );
        label.setForeground(new Color(0,0,255));
        label.setBackground(new Color(0,25,34));
        label.setBounds(20,20,300,40);

        JTextArea versions=new JTextArea();
        versions.setAutoscrolls(true);
        versions.setColumns(20);
        versions.setEditable(false);
        versions.setBackground(new Color(179,179,179));
        versions.setForeground(new Color(255,255,255));
        JScrollPane scrollPane=new JScrollPane(versions);
        scrollPane.setBounds(20,55,300,100);
//记录版本调整信息
        List<String> versionStrs=new ArrayList<>();
        versionStrs.add("Version:2019.10.16.0000");
        versionStrs.add("=================================");
        versionStrs.add("1)-增加<JMainProcessDesignView>输出按钮功能");
        versionStrs.add("2)-调整<JMaterialTraceView>表格控件");
        versionStrs.add("3)-调整<JTablePanel>表格控件,可隐藏显示字段");
        versionStrs.add("4)-调整<Db2DataSource>性能评估数据查询逻辑queryCoilMechanicByMFI" );
        versionStrs.add("  -第1遍查询历史和在线档" );
        versionStrs.add("  -如果记录数小于50条，进行第2遍查询历史和在线档，忽略厚度" );
        versionStrs.add("5)-修改<>Db2DataSource>模块材料跟踪查询逻辑queryMaterialTrackDatas" );
        versionStrs.add("  -第1步修改为循环获取材料跟踪号，而不是单笔。避免出现板坯号跟踪链不完整." );
        versionStrs.add("Version:2019.10.17.0000");
        versionStrs.add("=================================");
        versionStrs.add("1)-增加<JMaterialTraceView>一贯制工艺查询功能");
        versionStrs.add("  -增加C112,C512,C612退火工艺查询");
        versionStrs.add("2)-增加右侧内容动态增加功能");
        versionStrs.add("=================================");
        versionStrs.add("Version:2019.10.18.0000");
        versionStrs.add("1)-增加<JMaterialTraceView>一贯制工艺查询按钮，多线程模式");
        versionStrs.add("Version:2019.10.23.0000");
        versionStrs.add("1)-调整<JMainProcessDesignView>输出性能实绩，命名mfi");
        versionStrs.add("2)-新增<JMaterialTraceView>普冷C312/C212退火工艺查询逻辑，补全张力空缺字段");
        versionStrs.add("Version:2019.10.24.0000");
        versionStrs.add("1)-调整<JMaterialTraceView>中工艺参数表格显示方式");
        versionStrs.add("Version:2019.10.28.0000");
        versionStrs.add("Version:2019.10.30.0000");
        versionStrs.add("1)-调整<JMainProcessDesignView>中性能数据增加PSR和牌号");
        versionStrs.add("2)-调整<JMaterialTraceView>中增加热轧工艺追溯");
        versionStrs.add("Version:2019.10.31.0000");
        versionStrs.add("1)-新增<JMaterialTraceView>中炼钢成分");
        versionStrs.add("Version:2019.11.8.0000");
        versionStrs.add("1)-新增<JMainProcessDesignView>中性能数据增加热轧工序和退火工序材料工艺信息");
        versionStrs.add("Version:2019.11.9.0000");
        versionStrs.add("1)-新增<JMainProcessDesignView>中性能数据增加炼钢工艺信息");
        versionStrs.add("Version:2019.11.12.0000");
        versionStrs.add("1)-新增<JMaterialTraceView>罩式炉信息追溯");
        versionStrs.add("Version:2019.11.14.0000");
        versionStrs.add("1)-新增<MechanicAndProcessData>合同号字段");
        versionStrs.add("2)-修改POI一个bug:如果是空字段的情况，抛NullPointerException错误，导出不成功。");
        versionStrs.add("Version:2019.11.15.0000");
        versionStrs.add("1)-修改POI输出数值格式。");
        versionStrs.add("Version:2019.12.4.0000");
        versionStrs.add("1)增加多数据源功能(annotation,aop技术)!!!注意：暂无事务功能!!!加事务功能后" +
                "dao的aop失败，找不到动态数据源");
        versionStrs.add("2)dao,service架构建立。修改窗体" +
                "对象由spring管理，便于注入service等依赖");
        versionStrs.add("Version:2019.12.6.0000");













        for(String v:versionStrs){
            versions.append(v);
            versions.append("\n");
        }
//        JLabel label1=new JLabel("Version:2019.10.12.0000");
//        label1.setForeground(new Color(0,214,122));
//        label1.setBounds(20,35,200,40);

        JLabel label2=new JLabel("Steel Plate Engineering Division,MMD,Baosteel.");
        label2.setForeground(new Color(0,214,122));
        label2.setBounds(20,145,300,40);

        add(label);
        add(scrollPane);
        add(label2);

    }
}
