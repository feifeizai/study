package com.xhf;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuShukai
 * @version V1.0
 * @description 处理Excel，将读取到数据保存为对象并输出
 * @date 2018/11/6  16:44
 */
public class ExcelListener<T extends BaseRowModel> extends AnalysisEventListener<T> {
    /**
     * 自定义用于暂时存储data。
     * 可以通过实例获取该值
     */
    private final List<T> data = new ArrayList<T>();

    @Override
    public void invoke(T object, AnalysisContext context) {
        //数据存储
        data.add(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<T> getData() {
        return data;
    }

}