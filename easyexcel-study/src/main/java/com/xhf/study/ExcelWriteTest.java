package com.xhf.study;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.xhf.bean.ExcelPropertyIndexModel;
import com.xhf.bean.MultiLineHeadExcelModel;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelWriteTest {

    private OutputStream out;

    /**
     * 每行数据是List<String>无表头
     *
     * @throws IOException
     */
    @Test
    public void writeWithoutHead() throws IOException {
        OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("sheet1");
        List<List<String>> data = new ArrayList<List<String>>();
        for (int i = 0; i < 100; i++) {
            List<String> item = new ArrayList<String>();
            item.add("item0" + i);
            item.add("item1" + i);
            item.add("item2" + i);
            data.add(item);
        }
        writer.write0(data, sheet1);
        writer.finish();
    }


    @Test
    public void writeWithHead() throws IOException {
        OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("sheet1");
        List<List<String>> data = new ArrayList<List<String>>();
        for (int i = 0; i < 100; i++) {
            List<String> item = new ArrayList<String>();
            item.add("item0" + i);
            item.add("item1" + i);
            item.add("item2" + i);
            data.add(item);
        }
        List<List<String>> head = new ArrayList<List<String>>();
        List<String> headCoulumn1 = new ArrayList<String>();
        List<String> headCoulumn2 = new ArrayList<String>();
        List<String> headCoulumn3 = new ArrayList<String>();
        headCoulumn1.add("第一列");
        headCoulumn1.add("wwwww");
        headCoulumn2.add("第二列");
        headCoulumn3.add("第三列");
        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);
        Table table = new Table(1);
        table.setHead(head);
        writer.write0(data, sheet1, table);
        writer.finish();
    }


    @Test
    public void writeBeanWithHead() throws IOException {
        OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        Sheet sheet1 = new Sheet(1, 5, ExcelPropertyIndexModel.class);
        sheet1.setSheetName("实体");
        List<ExcelPropertyIndexModel> data = new ArrayList<ExcelPropertyIndexModel>();
        for (int i = 0; i < 100; i++) {
            ExcelPropertyIndexModel item = new ExcelPropertyIndexModel();
            item.setName("name" + i);
            item.setAge("age" + i);
            item.setEmail("email" + i);
            item.setAddress("address" + i);
            item.setHeigh("heigh" + i);
            item.setBirth("2019-12-02");
            item.setSax("sax" + i);
            data.add(item);
        }
        writer.write(data, sheet1);
        writer.finish();
    }

    @Test
    public void writeWithMultiHead() throws IOException {
        OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        Sheet sheet1 = new Sheet(2, 0, MultiLineHeadExcelModel.class);
        sheet1.setSheetName("sheet1");
        List<MultiLineHeadExcelModel> data = new ArrayList<MultiLineHeadExcelModel>();
        for (int i = 0; i < 100; i++) {
            MultiLineHeadExcelModel item = new MultiLineHeadExcelModel();
            item.setP1("p1" + i);
            item.setP2("p2" + i);
            item.setP3("p3" + i);
            item.setP4("p4" + i);
            item.setP5("p5" + i);
            item.setP6("p6" + i);
            item.setP7("p7" + i);
            item.setP8("p8" + i);
            item.setP9("p9" + i);
            data.add(item);
        }
        writer.write(data, sheet1);
        writer.finish();
    }

    @Test
    public void writeWithMultiTable() throws IOException {
        OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("sheet1");

        // 数据全是List<String> 无模型映射关系
        Table table1 = new Table(1);
        List<List<String>> data1 = new ArrayList<List<String>>();
        for (int i = 0; i < 5; i++) {
            List<String> item = new ArrayList<String>();
            item.add("item0" + i);
            item.add("item1" + i);
            item.add("item2" + i);
            data1.add(item);
        }
        writer.write0(data1, sheet1, table1);

        // 模型上有表头的注解
        Table table2 = new Table(2);
        table2.setClazz(MultiLineHeadExcelModel.class);
        List<MultiLineHeadExcelModel> data2 = new ArrayList<MultiLineHeadExcelModel>();
        for (int i = 0; i < 5; i++) {
            MultiLineHeadExcelModel item = new MultiLineHeadExcelModel();
            item.setP1("p1" + i);
            item.setP2("p2" + i);
            item.setP3("p3" + i);
            item.setP4("p4" + i);
            item.setP5("p5" + i);
            item.setP6("p6" + i);
            item.setP7("p7" + i);
            item.setP8("p8" + i);
            item.setP9("p9" + i);
            data2.add(item);
        }
        writer.write(data2, sheet1, table2);

        // 模型上没有注解，表头数据动态传入,此情况下模型field顺序与excel现实顺序一致
        List<List<String>> head = new ArrayList<List<String>>();
        List<String> headCoulumn1 = new ArrayList<String>();
        List<String> headCoulumn2 = new ArrayList<String>();
        List<String> headCoulumn3 = new ArrayList<String>();
        headCoulumn1.add("第一列");
        headCoulumn2.add("第二列");
        headCoulumn3.add("第三列");
        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);
        Table table3 = new Table(3);
        table3.setHead(head);
        writer.write0(data1, sheet1, table3);

        writer.finish();
    }


}


