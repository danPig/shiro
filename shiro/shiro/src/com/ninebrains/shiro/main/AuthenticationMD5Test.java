package com.ninebrains.shiro.main;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class AuthenticationMD5Test {
        public static void main(String[] args) {
                Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-MD5.ini");
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
                System.out.println("ÊÇ·ñÍ¨¹ý"+isAuthenticated);
                subject.logout();
                
        }
}
