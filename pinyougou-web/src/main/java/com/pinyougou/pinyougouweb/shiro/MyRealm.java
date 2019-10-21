package com.pinyougou.pinyougouweb.shiro;




import com.pinyougou.pojo.TbSeller;
import com.pinyougou.shop.service.ShopService;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * author：wdd
 * create time:2019/10/12
 * email：
 * tel：
 */
public class MyRealm extends AuthorizingRealm {

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
      /*  //获取用户登录的用户名
        String username = (String) authenticationToken.getPrincipal();
        //通过工具类获取bookService
       ShopService shopService = SpringBeanFactoryUtils.getBean("shopService", ShopService.class);
        //从数据库获取用户信息
        TbSeller seller = shopService.findUserByName(username);
        if(seller==null){
            return null;
        }
        //用户名(存入session)、密码、当前类名

        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(seller,seller.getPassword(),this.getName());
        return sai;*/
      return null;
    }
}
