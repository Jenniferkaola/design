package com.jennifer;

/**
 * ClassName Mgr01
 * author by jennifer
 * Date 2021/8/17
 * 饿汉式模式 类加载到内存后就实例一个对象,JVM保证线程安全
 * 简单 唯一缺点在类即使不用的情况也被初始化
 *
 */
public class Mgr01 {

    public static final Mgr01 INSTANCE = new Mgr01();
    private Mgr01(){}

    //构造方法必须私有化,禁止其他类构造
    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }
}
