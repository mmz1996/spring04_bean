package com.mmz.service.impl;


import com.mmz.service.AccountService;

/**
 * @Classname AccountServiceImpl
 * @Description 账户的业务层实现类
 * @Date 2020/5/7 21:34
 * @Created by mmz
 */
public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了");
    }
}
