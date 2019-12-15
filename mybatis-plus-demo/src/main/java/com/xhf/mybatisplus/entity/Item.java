package com.xhf.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
* @Description:
* @author 谢红飞
* @date 2019-12-15 17:14
*/
@ApiModel(value="com-xhf-mybatisplus-entity-Item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_item")
public class Item {
    /**
     * 商品id，同时也是商品编号
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="商品id，同时也是商品编号")
    private Long id;

    /**
     * 商品标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value="商品标题")
    private String title;

    /**
     * 商品卖点
     */
    @TableField(value = "sell_point")
    @ApiModelProperty(value="商品卖点")
    private String sellPoint;

    /**
     * 商品价格，单位为：分
     */
    @TableField(value = "price")
    @ApiModelProperty(value="商品价格，单位为：分")
    private Long price;

    /**
     * 库存数量
     */
    @TableField(value = "num")
    @ApiModelProperty(value="库存数量")
    private Integer num;

    /**
     * 商品条形码
     */
    @TableField(value = "barcode")
    @ApiModelProperty(value="商品条形码")
    private String barcode;

    /**
     * 商品图片
     */
    @TableField(value = "image")
    @ApiModelProperty(value="商品图片")
    private String image;

    /**
     * 所属类目，叶子类目
     */
    @TableField(value = "cid")
    @ApiModelProperty(value="所属类目，叶子类目")
    private Long cid;

    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
    @TableField(value = "status")
    @ApiModelProperty(value="商品状态，1-正常，2-下架，3-删除")
    private Byte status;

    /**
     * 创建时间
     */
    @TableField(value = "created")
    @ApiModelProperty(value="创建时间")
    private Date created;

    /**
     * 更新时间
     */
    @TableField(value = "updated")
    @ApiModelProperty(value="更新时间")
    private Date updated;
}