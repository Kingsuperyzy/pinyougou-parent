package com.pinyougou.pinyougouweb.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author：wdd
 * create time:2019/10/12
 * email：
 * tel：
 */
public class ShiroConfig {


    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
       ShiroFilterFactoryBean sfb = new ShiroFilterFactoryBean();
        sfb.setSecurityManager(securityManager);//添加securityManager，要不然没法认证
       /* sfb.setLoginUrl("/pageShop/toshoplogin");//设置登录页面的地址，默认login页面*/

        //拦截的规则 K:路径 v:拦截还是不拦截
        //- anon:所有url都都可以匿名访问
        //- authc: 需要认证才能进行访问
        //logout :注销
        Map<String , String> map = new LinkedHashMap<>();
        map.put("/logout","logout");//注销
        map.put("/pageShop/toshoplogin","anon");
        map.put("/shop/shoplogin","anon");
        //放开静态资源
        map.put("/js/**","anon");
        map.put("/css/**","anon");
        //其他的都拦截
        map.put("/**","authc");
        sfb.setFilterChainDefinitionMap(map);
        return sfb;

    }


    public SecurityManager securityManager(MyRealm myRealm){
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(myRealm);
        return dwsm;
    }


    public MyRealm test(){
        return new MyRealm();
    }
}
