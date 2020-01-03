package com.bs.fan.myjob.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Excel xlsx表格操作工具类
 *
 * @author LGX
 */
@SuppressWarnings("all")
public class POIUtil {

    /**
     * 创建Excel表格
     *
     * @throws Exception
     */
    public static boolean createXlsx(File target, String[] columnNames, Object[][] data) {
        try {
            int num = 0;
            // 创建工作簿
            HSSFWorkbook wb = new HSSFWorkbook();
            // 工作表
            HSSFSheet sheet = wb.createSheet("数据信息表");
            // 标头行，代表第一行
            HSSFRow header = sheet.createRow(num++);
            // 创建单元格，0代表第一行第一列
            for (int i = 0; i < columnNames.length; i++) {
                //设置excel表格某一行的值
                header.createCell(i).setCellValue(columnNames[i]);
            }

            for (int i = 0; i < data.length; i++) {
                //设置操作行为下一行
                HSSFRow row = sheet.createRow(num++);
                for (int j = 0; j < data[i].length; j++) {
                    //设置excel表格某一行的值
                    Object obj = data[i][j];
                    if (obj == null) {
                        obj = "";
                    }
                    row.createCell(j).setCellValue(obj.toString());//按字符串输出
                    /*String value = obj.toString();
                    if (NumberUtils.isDigits(value)) {//整数
                        if (value.startsWith("0")&&Integer.parseInt(value)!=0) {
                            row.createCell(j).setCellValue(value);
                        } else {
                            try {//超过整数范围的数字当字符串
                                row.createCell(j).setCellValue(Integer.parseInt(value));
                            } catch (NumberFormatException e) {
                                row.createCell(j).setCellValue(value);
                            }
                        }
                    } else if (NumberUtils.isNumber(value)) {//浮点数

                        float f=Float.parseFloat(value);
                        BigDecimal bd=new BigDecimal(f);
//                        bd=bd.round(new MathContext(4));//保留4位小数
//                        String s=bd.toString();
                        float v=bd.setScale(4,  BigDecimal.ROUND_HALF_UP).floatValue();
                        row.createCell(j).setCellValue(v);

                    } else {
                        row.createCell(j).setCellValue(value);
                    }*/
                }
            }

            /**
             * 输出表格
             */
            FileOutputStream fos = new FileOutputStream(target);
            wb.write(fos);
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createXlsx(File target, String[] columnNames1, Object[][] data1, String[] columnNames2, Object[][] data2) {
        try {
            int num = 0;
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("学生信息表");
            HSSFRow header = sheet.createRow(num++);
            for (int i = 0; i < columnNames1.length; i++) {
                header.createCell(i).setCellValue(columnNames1[i]);
            }
            for (int i = 0; i < data1.length; i++) {
                HSSFRow row = sheet.createRow(num++);
                for (int j = 0; j < data1[i].length; j++) {
                    row.createCell(j).setCellValue(data1[i][j].toString());
                }
            }
            num++; //下拉一行
            HSSFRow header2 = sheet.createRow(num++);
            for (int i = 0; i < columnNames2.length; i++) {
                header2.createCell(i).setCellValue(columnNames2[i]);
            }

            for (int i = 0; i < data2.length; i++) {
                HSSFRow row = sheet.createRow(num++);
                for (int j = 0; j < data2[i].length; j++) {
                    row.createCell(j).setCellValue(data2[i][j].toString());
                }
            }

            FileOutputStream fos = new FileOutputStream(target);
            wb.write(fos);
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        String[] columnNames1 = {"1", "2", "3"};
        Object[][] data1 = {
                {"q1", "w1", "e1"},
                {"q2", "w2", "e2"},
                {"q3", "w3", "e3"},
        };

        String[] columnNames2 = {"t1", "t2"};
        Object[][] data2 = {
                {"q1", "w1"},
                {"q2", "w2"},
                {"q3", "w3"},
        };


        POIUtil.createXlsx(new File("C:\\Users\\LGX\\Desktop\\新建文件夹\\test.xlsx"), columnNames1, data1, columnNames2, data2);
    }

    public static int isNumber(String str) {
        try {
            Integer.parseInt(str);
            return 0;
        } catch (NumberFormatException e) {
            return -1;
        }


    }

}
