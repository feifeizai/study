package com.xhf.service;

import com.xhf.dao.ChinaBankDao;
import com.xhf.entity.ChinaBank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-2 15:45
 */
@Service
@Slf4j
public class ChinaBankService {

    @Autowired
    private ChinaBankDao chinaBankDao;
    @Autowired
    private UsaBankService usaBankService;

    //todo test-1
    //todo REQUIRED
    /*@Transactional(rollbackFor = Exception.class)
    public void outter() throws Exception {
        ChinaBank chinaBank = chinaBankDao.findById(1).orElse(null);

        try {
            usaBankService.inner(1, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        chinaBank.setAcount(chinaBank.getAcount() - 100);
        chinaBankDao.save(chinaBank);
        int i = 10;
        if (i == 10)
            throw new Exception("chinaBank抛出异常");
    }*/

    //todo test-2
    //todo 这个方法不开启事务的时候以非事务方式运行,如果开启时事务就以事务方式运行
    /*public void outter() throws Exception {
        ChinaBank chinaBank = chinaBankDao.findById(1).orElse(null);

        usaBankService.inner(1, 100);

        chinaBank.setAcount(chinaBank.getAcount() - 100);
        chinaBankDao.save(chinaBank);
        int i = 10;
        if (i == 10)
            throw new Exception("chinaBank抛出异常");
    }*/

    //todo test-3
    //todo 无论outter是否以事务方式运行,inner()都以非事务方式运行
    /*@Transactional(rollbackFor = Exception.class)
    public void outter() throws Exception {
        ChinaBank chinaBank = chinaBankDao.findById(1).orElse(null);

        usaBankService.inner(1, 100);

        chinaBank.setAcount(chinaBank.getAcount() - 100);
        chinaBankDao.save(chinaBank);
        int i = 10;
        if (i == 10)
            throw new Exception("chinaBank抛出异常");
    }*/

    //todo test-4
    //todo outter的事务只能决定outter会不会回滚, 不能决定inner能不能回滚
    /*@Transactional(rollbackFor = Exception.class)
    public void outter() throws Exception {
        ChinaBank chinaBank = chinaBankDao.findById(1).orElse(null);

        usaBankService.inner(1, 100);

        chinaBank.setAcount(chinaBank.getAcount() - 100);
        chinaBankDao.save(chinaBank);
        int i = 10;
        if (i == 10)
            throw new Exception("chinaBank抛出异常");
    }*/

    //todo test-5
    //todo NESTED
    /*@Transactional(rollbackFor = Exception.class)
    public void outter() throws Exception {
        ChinaBank chinaBank = chinaBankDao.findById(1).orElse(null);

        try {
            usaBankService.inner(1, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        chinaBank.setAcount(chinaBank.getAcount() - 100);
        chinaBankDao.save(chinaBank);
        int i = 10;
        if (i == 10)
            throw new Exception("chinaBank抛出异常");
    }*/

    //todo test-6
    //todo never
    /*@Transactional(rollbackFor = Exception.class)
    public void outter() throws Exception {
        ChinaBank chinaBank = chinaBankDao.findById(1).orElse(null);

        usaBankService.inner(1, 100);

        chinaBank.setAcount(chinaBank.getAcount() - 100);
        chinaBankDao.save(chinaBank);
        int i = 10;
        if (i == 10)
            throw new Exception("chinaBank抛出异常");
    }*/

    //todo test-7
    //todo MANDATORY
    @Transactional(rollbackFor = Exception.class)
    public void outter() throws Exception {
        ChinaBank chinaBank = chinaBankDao.findById(1).orElse(null);

        usaBankService.inner(1, 100);

        chinaBank.setAcount(chinaBank.getAcount() - 100);
        chinaBankDao.save(chinaBank);
        int i = 10;
        if (i == 10)
            throw new Exception("chinaBank抛出异常");
    }

}
