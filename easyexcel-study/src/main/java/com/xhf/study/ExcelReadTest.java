package com.xhf.study;

import com.xhf.ExcelUtil;
import com.xhf.bean.ExcelPropertyIndexModel;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-17 22:49
 */
public class ExcelReadTest {

    @Test
    public void read(){
        try {
            InputStream in = new FileInputStream("C:\\Users\\Administrator\\Desktop\\test.xlsx");
            BufferedInputStream bis = new BufferedInputStream(in);

            List<ExcelPropertyIndexModel> list = ExcelUtil.readExcel(bis, ExcelPropertyIndexModel.class);

            System.out.println(list.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
