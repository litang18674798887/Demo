package com.lt.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Excel的单元格操作
 *
 * @author : litang
 * @date : Create in 2018/11/27
 */
public class PoiCellTest {

    /**
     * 设置格式
     * <p>
     * HSSFDataFormat.getFormat和HSSFDataFormat.getBuiltinFormat的区别：
     *  当使用Excel内嵌的（或者说预定义）的格式时，直接用HSSFDataFormat.getBuiltinFormat静态方法即可。
     *  当使用自己定义的格式时，必须先调用HSSFWorkbook.createDataFormat()，因为这时在底层会先找有没有匹配的内嵌FormatRecord，
     *  如果没有就会新建一个FormatRecord，所以必须先调用这个方法，然后你就可以用获得的HSSFDataFormat实例的getFormat方法了，
     *  当然相对而言这种方式比较麻烦，所以内嵌格式还是用HSSFDataFormat.getBuiltinFormat静态方法更加直接一些。
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

        //设置日期格式--使用Excel内嵌的格式
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(new Date());
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
        cell.setCellStyle(style);

        //设置保留2位小数--使用Excel内嵌的格式
        cell = row.createCell(1);
        cell.setCellValue(12.3456789);
        style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        cell.setCellStyle(style);

        //设置货币格式--使用自定义的格式
        cell = row.createCell(2);
        cell.setCellValue(12345.6789);
        style = workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("￥#,##0"));
        cell.setCellStyle(style);

        //设置百分比格式--使用自定义的格式
        cell = row.createCell(3);
        cell.setCellValue(0.123456789);
        style = workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("0.00%"));
        cell.setCellStyle(style);

        //设置中文大写格式--使用自定义的格式
        cell = row.createCell(4);
        cell.setCellValue(12345);
        style = workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("[DbNum2][$-804]0"));
        cell.setCellStyle(style);

        //设置科学计数法格式--使用自定义的格式
        cell = row.createCell(5);
        cell.setCellValue(12345);
        style = workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("0.00E+00"));
        cell.setCellStyle(style);


        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }


    /**
     * 合并单元格
     * <p>
     * CellRangeAddress对象其实就是表示一个区域，其构造方法如下：CellRangeAddress(firstRow, lastRow, firstCol, lastCol)，参数的说明：
     *  firstRow        区域中第一个单元格的行号
     *  lastRow         区域中最后一个单元格的行号
     *  firstCol        区域中第一个单元格的列号
     *  lastCol         区域中最后一个单元格的列号
     *
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
        //合并列
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("合并列");
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 5);
        sheet.addMergedRegion(region);

        //合并行
        cell = row.createCell(6);
        cell.setCellValue("合并行");
        region = new CellRangeAddress(0, 5, 6, 6);
        sheet.addMergedRegion(region);

        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }

    /**
     * 单元格对齐
     *
     *    水平对齐相关参数
     *          如果是左侧对齐就是   HSSFCellStyle.ALIGN_FILL;
     *          如果是居中对齐就是   HSSFCellStyle.ALIGN_CENTER;
     *          如果是右侧对齐就是   HSSFCellStyle.ALIGN_RIGHT;
     *          如果是跨列举中就是   HSSFCellStyle.ALIGN_CENTER_SELECTION;
     *          如果是两端对齐就是   HSSFCellStyle.ALIGN_JUSTIFY;
     *          如果是填充就是       HSSFCellStyle.ALIGN_FILL;
     *    垂直对齐相关参数
     *          如果是靠上就是     HSSFCellStyle.VERTICAL_TOP;
     *          如果是居中就是     HSSFCellStyle.VERTICAL_CENTER;
     *          如果是靠下就是     HSSFCellStyle.VERTICAL_BOTTOM;
     *          如果是两端对齐就是 HSSFCellStyle.VERTICAL_JUSTIFY;
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

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell=row.createCell(0);
        cell.setCellValue("单元格对齐");
        HSSFCellStyle style=workbook.createCellStyle();
        //水平居中
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER); HSSFCellStyle.ALIGN_CENTER报错，是因为版本问题
        //枚举值表示单元格的水平对齐，即是否对齐普通，左，右，水平居中，填充（复制），合理，以多个单元为中心，或分布式。
        style.setAlignment(HorizontalAlignment.CENTER);

        //垂直居中
        //style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中 报错，是因为版本问题
        //该枚举值表示单元的垂直对齐类型，即是否对齐顶部，底部，垂直居中，对齐或分布。
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        //自动换行
        style.setWrapText(true);
        //缩进
        style.setIndention((short)5);
        //文本旋转，这里的取值是从-90到90，而不是0-180度。
        style.setRotation((short)60);
        cell.setCellStyle(style);

        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }

    /**
     * 使用边框
     *
     * @throws IOException
     */
    @Test
    public void test04() throws IOException {
        //文件路径
        String filePath = "C:\\Users\\67382\\Desktop\\sample.xls";
        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet("Test");

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell=row.createCell(1);
        cell.setCellValue("设置边框");
        HSSFCellStyle style=workbook.createCellStyle();
        //上边框
        style.setBorderTop(BorderStyle.THICK);
        //下边框
        style.setBorderBottom(BorderStyle.THICK);
        //左边框
        style.setBorderLeft(BorderStyle.THICK);
        //右边框
        style.setBorderRight(BorderStyle.THICK);
        //上边框颜色
        style.setTopBorderColor((short) 255);
        //下边框颜色
        style.setBottomBorderColor((short) 255);
        //左边框颜色
        style.setLeftBorderColor((short) 255);
        //右边框颜色
        style.setRightBorderColor((short) 255);
        cell.setCellStyle(style);

        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }

    /**
     * 设置字体
     *
     *       下划线选项值：
     *          单下划线 FontFormatting.U_SINGLE
     *          双下划线 FontFormatting.U_DOUBLE
     *          会计用单下划线 FontFormatting.U_SINGLE_ACCOUNTING
     *          会计用双下划线 FontFormatting.U_DOUBLE_ACCOUNTING
     * 	        无下划线 FontFormatting.U_NONE
     *       上标下标选项值：
     *          上标 FontFormatting.SS_SUPER
     *          下标 FontFormatting.SS_SUB
     *          普通，默认值 FontFormatting.SS_NONE
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
        HSSFRow row = sheet.createRow(0);


        HSSFCell cell = row.createCell(1);
        cell.setCellValue("设置字体");
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        //设置字体名称
        font.setFontName("华文行楷");
        //设置字号
        font.setFontHeightInPoints((short)28);
        //设置字体颜色
        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置下划线
        font.setUnderline(new Byte("1"));
        //设置上标下标
        font.setTypeOffset(new Byte("1"));
        //设置删除线
        font.setStrikeout(true);
        style.setFont(font);
        cell.setCellStyle(style);


        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }


    /**
     * 背景和纹理
     * @throws IOException
     */
    @Test
    public void test06() throws IOException {
        //文件路径
        String filePath = "C:\\Users\\67382\\Desktop\\sample.xls";
        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet("Test");
        HSSFRow row = sheet.createRow(0);

        HSSFCell cell = row.createCell(0);

        HSSFCellStyle style = workbook.createCellStyle();
        //设置图案颜色
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
        //设置图案背景色
        style.setFillBackgroundColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
        //设置图案样式
        style.setFillPattern(FillPatternType.FINE_DOTS);
        cell.setCellStyle(style);


        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }

    /**
     * 设置宽度和高度
     * @throws IOException
     */
    @Test
    public void test07() throws IOException {
        //文件路径
        String filePath = "C:\\Users\\67382\\Desktop\\sample.xls";
        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet("Test");


        HSSFRow row = sheet.createRow(1);
        HSSFCell cell = row.createCell(1);
        cell.setCellValue("123456789012345678901234567890");
        //设置第一列的宽度是31个字符宽度
        sheet.setColumnWidth(1, 31 * 256);
        //设置行的高度是50个点
        row.setHeightInPoints(50);



        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }

    @Test
    public void test08() throws IOException {
        //文件路径
        String filePath = "C:\\Users\\67382\\Desktop\\sample.xls";
        //创建Excel文件(Workbook)
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表(Sheet)
        HSSFSheet sheet = workbook.createSheet("Test");
        HSSFRow row = sheet.createRow(1);

        HSSFCell cell = row.createCell(1);
        //设置日期数据
        cell.setCellValue(new Date());
        //输出：false
        System.out.println(DateUtil.isCellDateFormatted(cell));
        HSSFCellStyle style =workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
        //设置日期样式
        cell.setCellStyle(style);
        //输出：true
        System.out.println(DateUtil.isCellDateFormatted(cell));


        FileOutputStream out = new FileOutputStream(filePath);
        //保存Excel文件
        workbook.write(out);
        //关闭文件流
        out.close();
        System.out.println("OK!");
    }





















}
