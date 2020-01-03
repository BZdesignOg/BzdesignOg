package com.bs.fan.myjob.ui;


import com.bs.fan.myjob.exception.OutOfRowIndexException;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 @Scope("prototype")，多例模式创建bean。否则单例模式的话，每个面板都共用1个tablepanel显然是不合理的。
 是否是多例，可以看该panel的hashcode是否相等就可以了。
 */

@org.springframework.stereotype.Component
@Scope("prototype")
@Lazy
public class JTablePanel extends JPanel {

    protected DefaultTableModel dtm = null;//数据表模型
    protected Map<String, String> headerNamesMap = new HashMap<>();//存放列标题/字段映射
    //需要隐藏显示的字段存放列字段名
    protected List<String> hideFields = new ArrayList<>();
    //存放列字段名
    protected String[] names = null;
    //存放列标题名
    protected String[] headerNames = null;
    protected JTable resultTable = null;
    protected JTextArea text=null;
    protected List<Object> dataList = null;

    public void fillTable(List<Object> objects) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        dataList = (List<Object>) objects.get(0);
        if (dataList == null || dataList.size() == 0)
            return;

        Object modelTmp = dataList.get(0);
        Class cls = modelTmp.getClass();

        //初始化列表头-开始
        Field[] flds = cls.getDeclaredFields();
        headerNames = new String[flds.length - hideFields.size()];
        names = new String[flds.length - hideFields.size()];

        int i = 0, j = 0;
        for (Field fld : flds) {

            String headerName = fld.getName();//默认初始化：列标题就是列字段名
            if (hideFields.indexOf(headerName) >= 0) {//跳过需隐藏显示的字段
                System.out.println("hide find.");
                continue;
            }
            names[i++] = headerName;

            String mapName = headerNamesMap.get(headerName);
            if (mapName != null) {
                headerName = mapName;
            }
            headerNames[j++] = headerName;
        }
        //初始化列表头-结束

        if (resultTable == null) {
            createDataTable();
        }

        removeAllRows();
        for (Object model : dataList) {//往表中加数据
            int cols = names.length;
            Object[] row = new Object[cols];

            for (int k = 0; k < cols; k++) {
                String name = names[k];
                String firstA = name.toUpperCase().substring(0, 1);
                name = "get" + firstA + name.substring(1, name.length());
                Method method = cls.getDeclaredMethod(name);
                Object modelx = method.invoke(model);
                row[k] = modelx == null ? "" : modelx;
            }

            dtm.addRow(row);

        }


    }

    public JTablePanel() {
        setLayout(new BorderLayout());
        setBounds(0, 0, 250, 250);
        initHeaderNames();
        setBackground(new Color(196, 196, 196));
//        createDataTable();

    }

    //给某行着色
    public void setRowColor(int rowIdx, Color color) throws OutOfRowIndexException {
        if (rowIdx >= resultTable.getRowCount() || rowIdx < 0)
            throw new OutOfRowIndexException("行标越界");
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (rowIdx == row) {
                    setBackground(color);//设置行背景色
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };

        int columnCount = resultTable.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            resultTable.getColumn(resultTable.getColumnName(i)).setCellRenderer(dtcr);
        }

    }

    private void createDataTable() {

        dtm = new DefaultTableModel(null, headerNames);
        resultTable = new JTable(dtm) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;//默认表格不可编辑
            }

        };
        resultTable.setAutoCreateRowSorter(true);
        //关闭自动调整尺寸，横向滚动条
        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //增加行row选中监听事件
        resultTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int[] rows =
                            resultTable.getSelectedRows();
                    if (rows != null && rows.length > 0)
                        rowSelected(rows);

                }
            }
        });
//双击列线自动调整列宽
        JTableHeader header = resultTable.getTableHeader();
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 当光标处于两个列表间的分隔线上时，表头的光标呈东西调整的样式，通过
                // 鼠标的样式和点击次数来判断是否需要进行列宽调整
                int cursorType = header.getCursor().getType();
                if (cursorType == Cursor.E_RESIZE_CURSOR || cursorType == Cursor.W_RESIZE_CURSOR) {
                    if (e.getClickCount() == 2) {
                        // 获取光标点击位置的列号，这里将X的坐标减去3个像素,是为了保证取到的点始终是分隔线前的列号
//                        int col = resultTable.getTableHeader().getColumnModel().getColumnIndexAtX(e.getX() - 3);
                        int colcnt = resultTable.getTableHeader().getColumnModel().getColumnCount();
                        for (int i = 0; i < colcnt; i++) {//调整所有列
                            adjustColumnPreferredWidths(resultTable, i);
                        }

                    }
                }

            }
        });

        JScrollPane scrollPane = new JScrollPane(resultTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 800, 800);
        scrollPane.setBackground(new Color(0,0,220));

        add(scrollPane);
//刷新布局。
        doLayout();



    }

    private void adjustColumnPreferredWidths(JTable table, int col) {
        // strategy - get max width for cells in column and
        // make that the preferred width
        TableColumnModel columnModel = table.getColumnModel();
        int maxwidth = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer rend =
                    table.getCellRenderer(row, col);
            Object value = table.getValueAt(row, col);
            Component comp =
                    rend.getTableCellRendererComponent(table,
                            value,
                            false,
                            false,
                            row,
                            col);
            maxwidth = Math.max(comp.getPreferredSize().width, maxwidth);
        } // for row
        TableColumn column = columnModel.getColumn(col);
        column.setPreferredWidth(maxwidth + 3);
    }

    public void removeAllRows() {

        if (dtm == null) return;

        while (dtm.getRowCount() > 0) {
            dtm.removeRow(dtm.getRowCount() - 1);
        }
    }

    public JTable getResultTable() {
        return resultTable;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public String[] getColumnNames() {

        String[] names = new String[getResultTable().getColumnCount()];
        for (int i = 0; i < getResultTable().getColumnCount(); i++) {
            names[i] = getResultTable().getColumnName(i);
        }
        return names;
    }

    public int getColumnIdxByName(String name) {
        JTable table = getResultTable();
        int columnCnt = table.getColumnCount();
        for (int i = 0; i < columnCnt; i++) {
            if (table.getColumnName(i).equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Object[][] getData() {
        int row = getResultTable().getRowCount();
        int col = getResultTable().getColumnCount();
        Object[][] objects = new Object[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                objects[i][j] = getResultTable().getValueAt(i, j);
            }
        }
        return objects;
    }

    public List<Object> getDataList() {
        return dataList;
    }

    protected void rowSelected(int[] rowIdxs) {

    }

    //Overideable---填充列表头
    protected void initHeaderNames() {
    }

    public JTextArea getText() {
        return text;
    }
}
