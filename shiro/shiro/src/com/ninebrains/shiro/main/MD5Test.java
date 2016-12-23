package com.ninebrains.shiro.main;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Test {
        public static void main(String[] args) {
                String source="111111";
                String salt="qwerty";
                int hashIterations=1;
                Md5Hash md5=new Md5Hash(source, salt, hashIterations);
                String password=md5.toString();
                System.out.println(password);
        }
}
