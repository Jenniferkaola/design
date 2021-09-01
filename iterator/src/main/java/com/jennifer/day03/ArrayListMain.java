package com.jennifer.day03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * ClassName ArrayList
 * author by jennifer
 * Date 2021/9/1
 */
public class ArrayListMain {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i< 20; i++)
            arrayList.add("s"+i);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 50; i++)
            linkedList.add("s"+i);
        Iterator iterator1 = linkedList.iterator();
        while (iterator1.hasNext())
            System.out.println(iterator1.next());
    }
}
