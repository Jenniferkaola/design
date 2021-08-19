package com.jennifer;

/**
 * ClassName Main
 * author by jennifer
 * Date 2021/8/19
 * 抽象工厂,定义一个产品族
 * 1 定义一系列的抽象产品
 * 2 定义一个抽象工厂，生产一系列的抽象产品，即一系列的产品族
 * 3 定义具体的工厂，继承抽象的工厂，定义一个产品族一系列的生产过程
 * 4 当需要扩展一个产品族时,扩展一个具体的工厂即可
 */
public class Main {
    public static void main(String[] args) {
        //定义一个现代人的产品族
        Car car = new Car();
        //car.go();
        AK47 ak47 = new AK47();
       // ak47.shoot();
        Bread bread = new Bread();
        //bread.printName();
        //定义一个魔法世界人的产品族

        MagicStick magicStick = new MagicStick();
       // magicStick.shoot();
        MushRoom mushRoom = new MushRoom();
       // mushRoom.printName();
        Broom broom = new Broom();
        //broom.go();

        //思考：如何灵活的扩展产品一组，但不用改太多的东西
        AbstractFactory factory = new ModernFactory();
        factory.createFood().printName();
        factory.createVehicle().go();
        factory.createWeapon().shoot();

    }
}
