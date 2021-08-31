package com.jennifer.day03;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * ClassName Tank
 * author by jennifer
 * Date 2021/8/31
 * 另一种代理方式cglib,生成方式相对简单,但不能代理final类
 * 使用增强对象enhancer,被代理对象可以不用继承接口
 * 但是不能代理final对象
 */
public class Tank{

    public void movable() {
        System.out.println("tank tututu.......");
    }
}

//拦截器,类似invocationHandler
class TankLogInterception implements MethodInterceptor{

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("tank 开始移动.......");
        Object result = proxy.invokeSuper(obj,args);
        System.out.println("tank 结束移动.......");
        return result;
    }
}




class Test{
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TankLogInterception());
        Tank tank = (Tank) enhancer.create();
        tank.movable();
    }
}


