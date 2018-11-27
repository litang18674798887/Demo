package com.lt.poi;


import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * POI介绍
 *       Apache POI是Apache软件基金会的开源项目，POI提供API给Java程序对Microsoft Office格式档案读和写的功能。
 * POI结构说明
 *      包名称	说明
 *      HSSF	提供读写Microsoft Excel XLS格式档案的功能。
 *      XSSF	提供读写Microsoft Excel OOXML XLSX格式档案的功能。
 *      HWPF	提供读写Microsoft Word DOC格式档案的功能。
 *      HSLF	提供读写Microsoft PowerPoint格式档案的功能。
 *      HDGF	提供读Microsoft Visio格式档案的功能。
 *      HPBF	提供读Microsoft Publisher格式档案的功能。
 *      HSMF	提供读Microsoft Outlook格式档案的功能。
 * POI常用类说明
 *      类名                说明
 *      HSSFWorkbook        Excel的文档对象
 *      HSSFSheet	    Excel的表单
 *      HSSFRow	            Excel的行
 *      HSSFCell	    Excel的格子单元
 *      HSSFFont            Excel字体
 *      HSSFDataFormat      格子单元的日期格式
 *      HSSFHeader          Excel文档Sheet的页眉
 *      HSSFFooter          Excel文档Sheet的页脚
 *      HSSFCellStyle       格子单元样式
 *      HSSFDateUtil        日期
 *      HSSFPrintSetup      打印
 *      HSSFErrorConstants  错误信息表
 */
public class PoiTest {

    /**
     * 创建Workbook和Sheet
     * @throws IOException
     */
    @Test
    public void test01 () throws IOException {
        //文件路径
        String filePath="C:\\Users\\67382\\Desktop\\sample.xls";

        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet();

        //创建工作表(Sheet)
        sheet = workbook.createSheet("Test");
        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();

        System.out.println("OK!");
    }

    /**
     * 创建单元格
     * @throws IOException
     */
    @Test
    public void test02 () throws IOException {
        //文件路径
        String filePath="C:\\Users\\67382\\Desktop\\sample.xls";

        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet();

        // 创建行,从0开始
        HSSFRow row = sheet.createRow(0);
        // 创建行的单元格,也是从0开始
        HSSFCell cell = row.createCell(0);
        // 设置单元格内容
        cell.setCellValue("李志伟");
        // 设置单元格内容,重载
        row.createCell(1).setCellValue(false);
        // 设置单元格内容,重载
        row.createCell(2).setCellValue(new Date());
        // 设置单元格内容,重载
        row.createCell(3).setCellValue(12.345);

        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }

    /**
     * 创建文档摘要信息
     * @throws IOException
     */
    @Test
    public void test03 () throws IOException {
        //文件路径
        String filePath="C:\\Users\\67382\\Desktop\\sample.xls";
        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet();

        //创建文档信息
        workbook.createInformationProperties();
        //摘要信息
        DocumentSummaryInformation dsi= workbook.getDocumentSummaryInformation();
        //类别
        dsi.setCategory("类别:Excel文件");
        //管理者
        dsi.setManager("管理者:李唐");
        //公司
        dsi.setCompany("公司:--");
        //摘要信息
        SummaryInformation si = workbook.getSummaryInformation();
        //主题
        si.setSubject("主题:--");
        //标题
        si.setTitle("标题:测试文档");
        //作者
        si.setAuthor("作者:李志伟");
        //备注
        si.setComments("备注:POI测试文档");

        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }

    /**
     * 创建批注
     *
     *  创建批注位置HSSFPatriarch.createAnchor(dx1, dy1, dx2, dy2, col1, row1, col2, row2)方法参数说明：
     *      dx1         第1个单元格中x轴的偏移量
     *      dy1         第1个单元格中y轴的偏移量
     *      dx2         第2个单元格中x轴的偏移量
     *      dy2         第2个单元格中y轴的偏移量
     *      col1        第1个单元格的列号
     *      row1        第1个单元格的行号
     *      col2        第2个单元格的列号
     *      row2        第2个单元格的行号
     * @throws IOException
     */
    @Test
    public void test04 () throws IOException {
        //文件路径
        String filePath="C:\\Users\\67382\\Desktop\\sample.xls";
        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet("Test");
        HSSFPatriarch patr = sheet.createDrawingPatriarch();
        //创建批注位置
        HSSFClientAnchor anchor = patr.createAnchor(0, 0, 0, 0, 5, 1, 8, 3);
        //创建批注
        HSSFComment comment = patr.createCellComment(anchor);
        //设置批注内容
        comment.setString(new HSSFRichTextString("这是一个批注段落！"));
        //设置批注作者
        comment.setAuthor("李志伟");
        //设置批注默认显示
        comment.setVisible(true);
        HSSFCell cell = sheet.createRow(2).createCell(1);
        cell.setCellValue("测试");
        //把批注赋值给单元格
        cell.setCellComment(comment);


        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }

    /**
     * 创建页眉和页脚
     *
     *  也可以使用Office自带的标签定义，你可以通过HSSFHeader或HSSFFooter访问到它们，都是静态属性，列表如下：
     *      HSSFHeader.tab                  &A	表名
     *      HSSFHeader.file                 &F	文件名
     *      HSSFHeader.startBold            &B	粗体开始
     *      HSSFHeader.endBold              &B	粗体结束
     *      HSSFHeader.startUnderline       &U	下划线开始
     *      HSSFHeader.endUnderline         &U	下划线结束
     *      HSSFHeader.startDoubleUnderline &E	双下划线开始
     *      HSSFHeader.endDoubleUnderline   &E	双下划线结束
     *      HSSFHeader.time                 &T	时间
     *      HSSFHeader.date                 &D	日期
     *      HSSFHeader.numPages             &N	总页面数
     *      HSSFHeader.page                 &P	当前页号
     *
     * @throws IOException
     */
    @Test
    public void test05() throws IOException {
        //文件路径
        String filePath = "C:\\Users\\67382\\Desktop\\sample.xls";
        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet("Test");

        //得到页眉
        HSSFHeader header = sheet.getHeader();
        header.setLeft("页眉左边");
        header.setRight("页眉右边");
        header.setCenter("页眉中间");
        //得到页脚
        HSSFFooter footer = sheet.getFooter();
        footer.setLeft("页脚左边");
        footer.setRight("页脚右边");
        footer.setCenter("页脚中间");

        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }








}
