package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试配置
 * Spring整合junit的配置
 * 1.导入spring整合junit的jar（坐标）
 * 2.使用junit提供的一个注解 @RunWith 把原有的main方法，替换成spring提供的
 * 3.告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置 @ContextConfiguration
 *   locations:指定xml文件的位置，加上classpath关键字，表示类路径下
 *   classes:指定注解类所在的位置
 * 当使用spring 5.x版本时，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountService {
    @Autowired
    private IAccountService as=null;

    @Test
    public void testFindAll() {
        //3.执行方法
        List<Account> accounts=as.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {

        //3.执行方法
        Account account=as.findAccountById(1);
        System.out.println(account);

    }

    @Test
    public void testSave() {
        Account account=new Account();
        account.setName("test");
        account.setMoney(12345f);

        //3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {

        //3.执行方法
        Account account =as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {

        //3.执行方法
        as.deleteAccount(4);
    }
}