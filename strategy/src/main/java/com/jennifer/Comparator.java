package com.jennifer;

/**
 * ClassName Comparator
 * author by jennifer
 * Date 2021/8/17
 * 遵循设计模式的开闭原则,当比较属性变化时只需要创建一个比较器即可
 * comparable无法遵循这个原则
 */
public interface Comparator<T> {

    int compare(T o1,T o2);
}
