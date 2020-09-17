package com.xhf.mapstruct;

import com.xhf.mapstruct.bean.Person;
import com.xhf.mapstruct.bean.PersonDTO;
import com.xhf.mapstruct.bean.User;
import com.xhf.mapstruct.bean1.Item;
import com.xhf.mapstruct.bean1.Sku;
import com.xhf.mapstruct.bean1.SkuDTO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MapstructApplicationTests {

    @Autowired
    private ItemConverter itemConverter;

    @Test
    public void test() {
        Person person = new Person(1L, "zhige", "zhige.me@gmail.com", new Date(), new User(1));
        PersonDTO personDTO = PersonConverter.INSTANCE.domain2dto(person);
        assertNotNull(personDTO);
        assertEquals(personDTO.getId(), person.getId());
        assertEquals(personDTO.getName(), person.getName());
        assertEquals(personDTO.getBirth(), person.getBirthday());
        String format = DateFormatUtils.format(personDTO.getBirth(), "yyyy-MM-dd HH:mm:ss");
        assertEquals(personDTO.getBirthDateFormat(), format);
        assertEquals(personDTO.getBirthExpressionFormat(), format);

        List<Person> people = new ArrayList<>();
        people.add(person);
        List<PersonDTO> personDTOs = PersonConverter.INSTANCE.domain2dto(people);
        assertNotNull(personDTOs);
    }

    @Test
    public void test2() {
        Item item = new Item(1L, "iPhone X");
        Sku sku = new Sku(2L, "phone12345", 1000000);
        SkuDTO skuDTO = itemConverter.domain2dto(item, sku);
        assertNotNull(skuDTO);
        assertEquals(skuDTO.getSkuId(), sku.getId());
        assertEquals(skuDTO.getSkuCode(), sku.getCode());
        assertEquals(skuDTO.getSkuPrice(), sku.getPrice());
        assertEquals(skuDTO.getItemId(), item.getId());
        assertEquals(skuDTO.getItemName(), item.getTitle());
    }
}
