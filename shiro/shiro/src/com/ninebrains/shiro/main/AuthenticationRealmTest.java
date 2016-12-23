package com.ninebrains.shiro.main;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class AuthenticationRealmTest {
       
        public static void  main(String[]args){
                Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-realm.ini");
                SecurityManager securityManager=factory.getInstance();
                SecurityUtils.setSecurityManager(securityManager);
                Subject subject=SecurityUtils.getSubject();
                UsernamePasswordToken token=new UsernamePasswordToken("jarvis", "111111");
                try {
                        subject.login(token);
                } catch (AuthenticationException e) {
                        e.printStackTrace();
                }
                
                boolean isAuthenticated=subject.isAuthenticated();
                System.out.println(isAuthenticated);
                //判断是否授权
                boolean isPermitted=subject.isPermitted("user:create");
                System.out.println("是否授权"+isPermitted);
                
                boolean isPermittedAll=subject.isPermittedAll("user:create","user:delete");
                System.out.println("多个权限判断"+isPermittedAll);
        }
}
