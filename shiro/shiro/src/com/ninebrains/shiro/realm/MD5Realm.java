package com.ninebrains.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class MD5Realm extends AuthenticatingRealm{
        
        @Override
        public void setName(String name) {
                super.setName("ZaiRealm");
        }

        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(
                        AuthenticationToken token)
                        throws AuthenticationException {
                String principal=(String) token.getPrincipal();
                String password="f3694f162729b7d0254c6e40260bf15c";
                String salt="qwerty";
                SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(principal, password, ByteSource.Util.bytes(salt), this.getName());
                System.out.println("zhdzhdzhd"+simpleAuthenticationInfo);
                return simpleAuthenticationInfo;
        }
        
        

}
