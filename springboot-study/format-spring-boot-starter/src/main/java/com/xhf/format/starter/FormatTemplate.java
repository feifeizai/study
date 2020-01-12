package com.xhf.format.starter;

import com.xhf.format.starter.autoconfigure.ConfigProperties;
import com.xhf.format.starter.format.FormatProcessor;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 21:35
 */
public class FormatTemplate {

    private FormatProcessor formatProcessor;

    private ConfigProperties userProperties;

    public FormatTemplate(ConfigProperties userProperties,
                          FormatProcessor formatProcessor) {
        this.userProperties = userProperties;
        this.formatProcessor = formatProcessor;
    }

    public <T> String doFormat(T t) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("begin:Execute format").append("<br/>");
        stringBuilder.append("ConfigProperties:").append(formatProcessor.format(userProperties.getInfo())).append("<br/>");
        stringBuilder.append("Obj format result:").append(formatProcessor.format(t)).append("<br/>");
        return stringBuilder.toString();
    }

}
