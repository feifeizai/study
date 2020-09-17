package com.xhf.mapstruct;

import com.xhf.mapstruct.bean1.Item;
import com.xhf.mapstruct.bean1.Sku;
import com.xhf.mapstruct.bean1.SkuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @Mapper 只有在接口加上这个注解， MapStruct 才会去实现该接口
 *     componentModel: 主要是指定实现类的类型，一般用到两个
 *          default：默认，可以通过 Mappers.getMapper(Class) 方式获取实例对象
 *          spring：在接口的实现类上自动添加注解 @Component，可通过 @Autowired 方式注入
 * @Mapping：属性映射，若源对象属性与目标对象名字一致，会自动映射对应属性
 *     source：源属性
 *     target：目标属性
 *     dateFormat：String 到 Date 日期之间相互转换，通过 SimpleDateFormat，该值为 SimpleDateFormat              的日期格式
 *     ignore: 忽略这个字段
 * @Mappings：配置多个@Mapping
 * @MappingTarget 用于更新已有对象
 * @InheritConfiguration 用于继承配置
 *
 */
@Mapper(componentModel = "spring")
public interface ItemConverter {

    @Mappings({
            @Mapping(source = "sku.id",target = "skuId"),
            @Mapping(source = "sku.code",target = "skuCode"),
            @Mapping(source = "sku.price",target = "skuPrice"),
            @Mapping(source = "item.id",target = "itemId"),
            @Mapping(source = "item.title",target = "itemName")
    })
    SkuDTO domain2dto(Item item, Sku sku);
}