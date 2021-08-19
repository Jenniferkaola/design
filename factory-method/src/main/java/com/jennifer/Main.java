package com.jennifer;

/**
 * ClassName Main
 * author by jennifer
 * Date 2021/8/18
 *工厂方法:任意定义一个产品 继承moveable即可
 * 任意定义一个产品的生产过程,使用factory的create方法
 *
 */
public class Main {
    public static void main(String[] args) {
        //Car car = new Car();
       // car.go();
        //Plane plane = new Plane();
        //plane.go();

        //Broom broom = new Broom();
       // broom.go();
       // Moveable moveable = new Car();
        //moveable.go();
        Moveable moveable = new CarFactory().create();
        moveable.go();
    }
}
