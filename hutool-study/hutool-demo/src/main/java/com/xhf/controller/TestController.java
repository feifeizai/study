package com.xhf.controller;

import com.xhf.model.GroupVO;
import com.xhf.model.ItemVO;
import com.xhf.model.Option;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-6 22:01
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public GroupVO get() {
        List<ItemVO> itemList = getItemList();

        Option option = getOption();

        GroupVO groupVO = new GroupVO(itemList, option);

        return groupVO;
    }

    @PostMapping
    public GroupVO post() {
        List<ItemVO> itemList = getItemList();

        Option option = getOption();

        GroupVO groupVO = new GroupVO(itemList, option);

        return groupVO;
    }

    @DeleteMapping
    public GroupVO delete() {
        List<ItemVO> itemList = getItemList();

        Option option = getOption();

        GroupVO groupVO = new GroupVO(itemList, option);

        return groupVO;
    }


    private List<ItemVO> getItemList() {
        ItemVO item1 = new ItemVO();
        item1.setId("1");
        item1.setName("item1");
        item1.setCount(1);

        ItemVO item2 = new ItemVO();
        item2.setId("2");
        item2.setName("item2");
        item2.setCount(2);

        ItemVO item3 = new ItemVO();
        item3.setId("3");
        item3.setName("item3");
        item3.setCount(3);

        ArrayList<ItemVO> list = new ArrayList<ItemVO>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        return list;
    }

    private Option getOption() {
        Option option = new Option();
        option.setCategory(getCategoryList());
        return option;
    }

    private List<Option.Catogory> getCategoryList() {
        Option.Catogory catogory1 = new Option.Catogory();
        catogory1.setCategoryId("100");
        catogory1.setName("c1");

        Option.Catogory catogory2 = new Option.Catogory();
        catogory2.setCategoryId("200");
        catogory2.setName("c2");

        Option.Catogory catogory3 = new Option.Catogory();
        catogory3.setCategoryId("300");
        catogory3.setName("c3");

        ArrayList<Option.Catogory> list = new ArrayList<Option.Catogory>();
        list.add(catogory1);
        list.add(catogory2);
        list.add(catogory3);

        return list;
    }
}
