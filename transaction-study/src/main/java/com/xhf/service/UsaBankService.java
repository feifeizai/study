package com.xhf.service;

import com.xhf.dao.UsaBankDao;
import com.xhf.entity.UsaBank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-2 15:44
 */
@Service
@Slf4j
public class UsaBankService {

    @Autowired
    private UsaBankDao usaBankDao;

    //todo test-1
    //todo REQUIRED: 如果存在一个事务，则支持当前事务。如果没有事务则开启
    //todo             1.当前不存在事务: 即outter()无@Transactional注解, inner方法异常受事务控制, outter方法内的异常不受事务控制
    //todo             2.当前存在事务: 即outter()有@Transactional注解, 将当前事务合并到outter中事务, 如论是inner或outter异常都会回滚
    /*@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void inner(Integer id, Integer count) throws Exception {
        UsaBank usaBank = usaBankDao.findById(id).orElse(null);
        usaBank.setAcount(usaBank.getAcount() + count);
        usaBankDao.save(usaBank);
        int j = 10;
        if(j == 10)
            throw new Exception("usaBank抛出异常");
    }*/


    //todo test-2
    //todo SUPPORTS: 如果存在一个事务，支持当前事务。如果没有事务，则非事务的执行
    //todo outter方法不开启事务, inner异常的时候不会回滚
    /*@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public void inner(Integer id, Integer count) throws Exception {
        UsaBank usaBank = usaBankDao.findById(id).orElse(null);
        usaBank.setAcount(usaBank.getAcount() + count);
        usaBankDao.save(usaBank);
        int j = 10;
        if(j == 10)
            throw new Exception("usaBank抛出异常");
    }*/

    //todo test-3
    //todo NOT_SUPPORTED: 总是非事务地执行，并挂起任何存在的事务
    //todo 无论outter()是否开始事务, inner()都以非事务方式运行, 即使outter异常,inner也不会回滚
    /*@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public void inner(Integer id, Integer count) throws Exception {
        UsaBank usaBank = usaBankDao.findById(id).orElse(null);
        usaBank.setAcount(usaBank.getAcount() + count);
        usaBankDao.save(usaBank);
        int j = 10;
        if(j == 10)
            throw new Exception("usaBank抛出异常");
    }*/

    //todo test-4
    //todo REQUIRES_NEW: 总是开启一个新的事务。如果一个事务已经存在，则将这个存在的事务挂起。
    //todo 无论outter是否开启事务,inner都会新开一个事务; 即使outter抛出异常,只要inner无异常inner就不会回滚
    /*@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void inner(Integer id, Integer count) throws Exception {
        UsaBank usaBank = usaBankDao.findById(id).orElse(null);
        usaBank.setAcount(usaBank.getAcount() + count);
        usaBankDao.save(usaBank);
        int j = 9;//todo 不抛出异常
        if(j == 10)
            throw new Exception("usaBank抛出异常");
    }*/

    //todo test-5
    //todo NESTED: 如果一个活动的事务存在，则运行在一个嵌套的事务中. 如果没有活动事务, 则按 REQUIRED 属性执行(新建一个事务)
    //todo          1. 当前不存在事务: 即outter()方法上没有开启@Transactional; inner发生异常回滚; outter异常inner和outter都不会回滚
    //todo          2. 当前存在事务: 即outter()方法上有开启@Transactional; inner发生异常回滚, outter事务可选择性回滚或者不不滚(try-catch)；outter事务回滚inner事务一定回滚;
    /*@Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void inner(Integer id, Integer count) throws Exception {
        UsaBank usaBank = usaBankDao.findById(id).orElse(null);
        usaBank.setAcount(usaBank.getAcount() + count);
        usaBankDao.save(usaBank);
        int j = 9;
        if(j == 10)
            throw new Exception("usaBank抛出异常");
    }*/

    //todo test-6
    //todo NEVER: 总是非事务地执行，如果存在一个活动事务，则抛出异常;
    //todo 如果outter开启了事务就报错
    /*@Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
    public void inner(Integer id, Integer count) throws Exception {
        UsaBank usaBank = usaBankDao.findById(id).orElse(null);
        usaBank.setAcount(usaBank.getAcount() + count);
        usaBankDao.save(usaBank);
        int j = 9;
        if(j == 10)
            throw new Exception("usaBank抛出异常");
    }*/

    //todo test-7
    //todo MANDATORY: 如果已经存在一个事务，支持当前事务。如果没有一个活动的事务，则抛出异常。
    //todo outter必须存在事务否则就抛出异常
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public void inner(Integer id, Integer count) throws Exception {
        UsaBank usaBank = usaBankDao.findById(id).orElse(null);
        usaBank.setAcount(usaBank.getAcount() + count);
        usaBankDao.save(usaBank);
        int j = 9;
        if(j == 10)
            throw new Exception("usaBank抛出异常");
    }

}
