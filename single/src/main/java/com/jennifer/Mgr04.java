package com.jennifer;

/**
 * ClassName Mgr04
 * author by jennifer
 * Date 2021/8/17
 * 枚举的方式
 * 还可以防止序列化 枚举类没有构造方法，所有不能被序列化
 */
public enum Mgr04 {

    INSTANCE;

    public void m(){

    }

    public static void main(String[] args) {
        Mgr04.INSTANCE.m();
    }
}
