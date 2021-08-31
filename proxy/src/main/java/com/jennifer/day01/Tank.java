package com.jennifer.day01;

import com.jennifer.Main;

/**
 * ClassName Tank
 * author by jennifer
 * Date 2021/8/31
 * 静态代理
 * 1 怎样设置代理的嵌套,设置代理的顺序?
 * 解决:看tank1实现类,代理对象直接代理movable接口而不是代理具体的实现类
 */
public class Tank implements Movable{

    @Override
    public void movable() {
        System.out.println("tank kukukuuku........");
    }
}

//tank的时间代理，获取tank移动的开始时间以及结束时间
 class TankTimeProxy implements Movable{

    private Tank tank;

    public TankTimeProxy(Tank tank){
        this.tank = tank;
    }

    @Override
    public void movable() {
        System.out.println("tank开始移动时间"+System.currentTimeMillis());
        tank.movable();
        System.out.println("tank结束移动时间"+System.currentTimeMillis());
    }
}

//tank移动轨迹描述代理
class TankLogProxy implements Movable{

    private Tank tank;

    public TankLogProxy(Tank tank){
        this.tank = tank;
    }

    @Override
    public void movable() {
        System.out.println("tank开始移动....");
        tank.movable();
        System.out.println("tank结束移动.......");
    }
}

 interface Movable{
    void movable();
}

class Test{
    public static void main(String[] args) {
        Tank tank = new Tank();
        TankTimeProxy tankTimeProxy = new TankTimeProxy(tank);
        tankTimeProxy.movable();
        TankLogProxy tankLogProxy = new TankLogProxy(tank);
        tankLogProxy.movable();
    }
}
