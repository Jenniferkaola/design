package com.jennifer;

/**
 * ClassName Mgr03
 * author by jennifer
 * Date 2021/8/17
 * 静态内部类
 * JVM保证单例(类只会在内存中加载一次)
 * 加载外部类的时候不会家在静态内部类
 * 完美的写法之一
 */
public class Mgr03 {

    private Mgr03(){}

    private static class Mgr03Holder{
        private static Mgr03 INSTANCE = new Mgr03();
    }

    public static Mgr03 getInstance(){
        return Mgr03Holder.INSTANCE;
    }
}
