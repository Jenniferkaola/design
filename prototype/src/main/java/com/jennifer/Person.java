package com.jennifer;

/**
 * ClassName Person
 * author by jennifer
 * Date 2021/9/1
 *
 * 必须继承接口cloneable接口,标记性接口,没有任何方法
 */
public class Person implements Cloneable{

    private String userName;
    private int age;
     Location loc;

    Person(String userName,int age,Location loc){
        this.age = age;
        this.userName  = userName;
        this.loc = loc;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //深拷贝
        Person person = (Person) super.clone();
        person.loc = (Location) this.loc.clone();
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", loc=" + loc +
                '}';
    }
}

class Location implements Cloneable{
    String street;

    Location(String street){
        this.street = street;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                '}';
    }
}

/**浅拷贝，当对象中包含对象时，改变要拷贝对象中的值会跟着改变,
 * 如果想确保location不发生变化,则需要进行深拷贝
 * 解决方案:location也继承cloneable接口
 * String 不用进行深拷贝也不会改变值  因为String变量指向的是内存中的常量字符,new String的对象则会发生改变
 * **/
class Test{
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("jennifer",32,new Location("苏州"));
        Person person1 = (Person) person.clone();
        System.out.println(person1);
        person.loc.street = "上海";
        System.out.println(person1);
    }
}
