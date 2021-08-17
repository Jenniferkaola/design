package com.jennifer;

/**
 * ClassName Main
 * author by feyman
 * Date 2021/8/17
 */
public class Main {

    public static void main(String[] args) {
        Mgr01 mgr01 = Mgr01.getInstance();
        Mgr01 mgr011 = Mgr01.getInstance();
        System.out.println(mgr011 == mgr01);
    }
}
