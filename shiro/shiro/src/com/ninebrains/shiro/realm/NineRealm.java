package com.ninebrains.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class NineRealm extends AuthorizingRealm{
        
        @Override
        public void setName(String name) {
                super.setName("DanRealm");
        }

        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(
                        AuthenticationToken token)
                        throws AuthenticationException {
                String principal=(String) token.getPrincipal();
                System.out.println(principal);
                String password="111111";
                SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(principal, password, this.getName());
                return simpleAuthenticationInfo;
        }

        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(
                        PrincipalCollection principals) {
                String usercode=(String) principals.getPrimaryPrincipal();
                System.out.println("授权"+usercode);
                //模拟数据库查询出权限数据
                List<String> permissions=new ArrayList<String>();
                permissions.add("user:create");
                permissions.add("user:delete");
                SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
                simpleAuthorizationInfo.addStringPermissions(permissions);
                return simpleAuthorizationInfo;
        }
        
       

}
