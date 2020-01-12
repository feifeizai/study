package com.xhf.an.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 18:10
 */
public class BeanImportSelector implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.xhf.an.bean.Bean3"};
    }
}
