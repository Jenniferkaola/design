package com.jennifer.day01;

/**
 * ClassName Tank1
 * author by jennifer
 * Date 2021/8/31
 * 如果不仅想用TankLogProxy代理tank，还可以代理其他任意的对象，该如何解决?
 * 分离代理行为与被代理对象，使用java自带的动态代理技术,详细代码看day02
 */
public class Tank1 implements Movable1{

    public void movable(){
       System.out.println("tank tututututtu.......");
    }
}

interface Movable1{
    void movable();
}

class Tank1TimeProxy implements Movable1{

    private Movable1 movable1;

    Tank1TimeProxy(Movable1 movable1){
        this.movable1 = movable1;
    }

    @Override
    public void movable() {
        System.out.println("tank的移动时间:"+System.currentTimeMillis());
        movable1.movable();
        System.out.println("tank结束移动时间"+System.currentTimeMillis());
    }
}

class Tank1LogProxy implements Movable1{
    private Movable1 movable1;

    Tank1LogProxy(Movable1 movable){
        this.movable1 = movable;
    }


    @Override
    public void movable() {
        System.out.println("tank开始的移动轨迹");
        movable1.movable();
        System.out.println("tank结束移动轨迹");
    }
}

class Test1{
    public static void main(String[] args) {
        Tank1LogProxy logProxy = new Tank1LogProxy(new Tank1TimeProxy(new Tank1()));
       // logProxy.movable();

        Tank1TimeProxy timeProxy = new Tank1TimeProxy(new Tank1LogProxy(new Tank1()));
        timeProxy.movable();
    }
}

