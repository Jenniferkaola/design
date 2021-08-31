package com.jennifer.day02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName Tank
 * author by jennifer
 * Date 2021/8/31
 * 使用jdk的动态代理技术 proxy.newProxyInstance(ClassLoder classLoader,interfaces[],invocationHanlder)
 * 使用的是asm技术,asm技术可以直接修改二进制字节码,所以它可以动态代理final类
 * asm动态语言，直接在操作过程中直接修改类的属性和方法,可增删改查
 * 被代理对象必须继承接口
 */
public class Tank implements Movable{
    @Override
    public void movable() {
        System.out.println("tank tutututut.......");
    }
}

interface Movable{
    void movable();
}

class TankLogInvocationHandler implements InvocationHandler{

    private Movable movable;

    TankLogInvocationHandler(Movable movable){
        this.movable = movable;
    }

    /**
     * proxy 生成的代理对象
     * method : 被代理对象要执行的方法
     * arg 方法参数
     * **/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("tank开始移动.......");
        Object result = method.invoke(movable,args);
        System.out.println("tank结束移动.........");
        return result;
    }
}


class Test{
    public static void main(String[] args) {
        /**
         * classloader  被代理的对象使用类加载器load到内存中去
         * interfaces  代理对象需要继承的接口
         * invocationHandler 在调用被代理对象方法前后执行的方法
         * **/
        /*public static Object newProxyInstance(ClassLoader loader,
                Class<?>[] interfaces,
                InvocationHandler h)*/

        //代理类分析工具,将代理类的class文件打印出来
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},new TankLogInvocationHandler(new Tank()));
        movable.movable();
    }
}
