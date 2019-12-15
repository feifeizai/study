package com.xhf.mybatisplus.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhf.mybatisplus.entity.Item;
import com.xhf.mybatisplus.mapper.ItemMapper;
import com.xhf.mybatisplus.service.ItemService;
/**  
* @Description:
* @author 谢红飞
* @date 2019-12-15 17:14
*/
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService{

}
