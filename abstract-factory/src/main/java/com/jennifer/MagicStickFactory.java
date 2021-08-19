package com.jennifer;

/**
 * ClassName MagicSticFactory
 * author by jennifer
 * Date 2021/8/19
 */
public class MagicStickFactory extends AbstractFactory{
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }
}
