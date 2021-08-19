package com.jennifer;

/**
 * ClassName CarFactory
 * author by jennifer
 * Date 2021/8/19
 * 简单工厂
 */
public class CarFactory {

    Moveable create(){
        return new Car();
    }
}
