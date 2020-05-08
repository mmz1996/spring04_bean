**创建bean的三种方式**
第一种方式：使用默认构造函数创建，在spring的配置文件中使用bean标签，配以id和class属性，且没有其他属性和标签时。采用的就是默认构造函数创建bean对象，此时如果类没有默认构造函数，无法创建。

第二种方式：当我们想要调用别人写好的jar中的类，无法修改别人的类。
模拟创建factory下面的InstanceFactory

```bash
package com.mmz.factory;

import com.mmz.service.AccountService;
import com.mmz.service.impl.AccountServiceImpl;

/**
 * @Classname InstanceFactory
 * @Description TODO
 * @Date 2020/5/8 11:36
 * @Created by mmz
 */
public class InstanceFactory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}

```

```bash
    <bean id="instanceFactort" class="com.mmz.factory.InstanceFactory"></bean>
    <bean id="accountService" factory-bean="instanceFactort" factory-method="getAccountService"></bean>
```

第三种方式：使用静态工厂中静态方法创建对象，并存入spring容器中。

```bash
package com.mmz.factory;

import com.mmz.service.AccountService;
import com.mmz.service.impl.AccountServiceImpl;

/**
 * @Classname InstanceFactory
 * @Description TODO
 * @Date 2020/5/8 11:36
 * @Created by mmz
 */
public class InstanceFactory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}

```

```bash
    <bean id="accountService" class="com.mmz.factory.StaticFactory" factory-method="getAccountService"></bean>
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200508114059226.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2MzQ0Nzcx,size_16,color_FFFFFF,t_70)


**bean对象的作用范围**
bean标签中scope属性范围
作用：用于指定bean的范围
singleton 单例（也是默认值）
prototype 多例
request 作用于web应用的请求
session 作用于web应用的会话范围
global-session 作用于集群环境的会话范围（全局会话范围），当不是集群环境时，就是session



**bean对象的生命周期**
单例对象
出生：当容器创建对象出生
活着：只要容器一直在，对象一直存活
死亡：当容器销毁，对象消亡
总结：单例对象的生命周期和容器相同
多例对象
出生：当我们使用对象时，spring框架为我们创建
活着：使用过程一直活着
死亡：当对象长时间不用，且没有别的对象引用时。由java的回收器执行。

