package com.mmz.factory;

import com.mmz.service.AccountService;
import com.mmz.service.impl.AccountServiceImpl;

/**
 * @Classname InstanceFactory
 * @Description TODO
 * @Date 2020/5/8 11:36
 * @Created by mmz
 */
public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
