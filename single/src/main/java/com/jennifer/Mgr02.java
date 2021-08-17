package com.jennifer;

/**
 * ClassName Mgr02
 * author by jennifer
 * Date 2021/8/17
 * 懒汉模式 用到的时候才会进行初始化
 * 注意点:线程安全问题,可能会初始多个实例
 */
public class Mgr02 {
    private static Mgr02 INSTANCE = null;

    private Mgr02(){}

    //加入同步机制确保线程安全
    public static Mgr02 getInstance(){
        if (INSTANCE == null){
            synchronized (Mgr02.class){
                if (INSTANCE == null)
                    INSTANCE = new Mgr02();
            }
        }
        return INSTANCE;
    }
}
