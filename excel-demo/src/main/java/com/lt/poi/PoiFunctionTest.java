package com.lt.poi;

import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/**
 * 使用Excel公式
 *
 * @author : litang
 * @date : Create in 2018/11/29
 */
public class PoiFunctionTest {


    /**
     * 基本计算
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        //文件路径
        String filePath = "C:\\Users\\67382\\Desktop\\sample.xls";
        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet("Test");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);

        //设置公式
        cell.setCellFormula("2+3*4");
        cell = row.createCell(1);
        cell.setCellValue(10);
        cell = row.createCell(2);
        //设置公式
        cell.setCellFormula("A1*B1");




        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }

    /**
     * SUM函数
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        //文件路径
        String filePath = "C:\\Users\\67382\\Desktop\\sample.xls";
        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet("Test");


        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue(1);
        row.createCell(1).setCellValue(2);
        row.createCell(2).setCellValue(3);
        row.createCell(3).setCellValue(4);
        row.createCell(4).setCellValue(5);
        row = sheet.createRow(1);
        //等价于"A1+C1"
        row.createCell(0).setCellFormula("sum(A1,C1)");
        //等价于"B1+C1+D1"
        row.createCell(1).setCellFormula("sum(B1:D1)");



        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }

    /**
     * 日期函数
     *
     *   以上代码中的公式说明：
     *         DATEDIF(A1,B1,\"y\")：取得A1单元格的日期与B1单元格的日期的时间间隔。(“y”:表示以年为单位,”m”表示以月为单位;”d”表示以天为单位)。
     *         CONCATENATE(str1,str2,…)：连接字符串。
     *         更多Excel的日期函数可参考： http://tonyqus.sinaapp.com/archives/286
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        //文件路径
        String filePath = "C:\\Users\\67382\\Desktop\\sample.xls";
        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet("Test");


        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("yyyy-mm-dd"));
        HSSFRow row = sheet.createRow(0);
        //日历对象
        Calendar date = Calendar.getInstance();
        HSSFCell cell = row.createCell(0);
        date.set(2011, 2, 7);
        cell.setCellValue(date.getTime());
        //第一个单元格开始时间设置完成
        cell.setCellStyle(style);
        cell = row.createCell(1);
        date.set(2014, 4, 25);
        cell.setCellValue(date.getTime());
        //第一个单元格结束时间设置完成
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellFormula("CONCATENATE(DATEDIF(A1,B1,\"y\"),\"年\")");
        cell = row.createCell(4);
        cell.setCellFormula("CONCATENATE(DATEDIF(A1,B1,\"m\"),\"月\")");
        cell = row.createCell(5);
        cell.setCellFormula("CONCATENATE(DATEDIF(A1,B1,\"d\"),\"日\")");


        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }



}
