package com.xhf.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xhf.mybatisplus.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-15 17:18
 */
@SpringBootTest
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Test
    public void getById(){
        Item item = itemService.getById(562379);
        System.out.println(item.toString());
    }

    @Test
    public void findByPage(){
        Page<Item> page = new Page<>(1, 2);
        IPage<Item> itemIPage = itemService.page(page);
        System.out.println(itemIPage.getRecords().toString());
    }

    @Test
    public void findByPage1(){
        Page<Item> page = new Page<>(1, 2);
        QueryWrapper<Item> wrapper = new QueryWrapper<>();
        Item item = new Item();
        item.setCid(560L);
        wrapper.setEntity(item);
        IPage<Item> itemIPage = itemService.page(page, wrapper);
        System.out.println(itemIPage.getRecords().toString());
    }

    @Test
    public void findNotIn(){
        Page<Item> page = new Page<>(1, 2);
        QueryWrapper<Item> wrapper = new QueryWrapper<>();
        Item item = new Item();
        wrapper.setEntity(item);
        List<Long> list = Arrays.asList(536563L, 562379L);
        wrapper.notIn("sell_point", list);
        IPage<Item> itemIPage = itemService.page(page, wrapper);
        System.out.println(itemIPage.getRecords().toString());
    }

    @Test
    public void findByOrder() throws JsonProcessingException {
        Page<Item> page = new Page<>(1, 2);
        QueryWrapper<Item> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        IPage<Item> itemIPage = itemService.page(page, wrapper);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(itemIPage));
    }
}
