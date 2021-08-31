package com.jennifer;

/**
 * ClassName ArrayList_
 * author by jennifer
 * Date 2021/8/31
 * 数组和链表
 * 如何统一实现数组和链表的统一遍历，ArrayList2
 */
public class ArrayList_  implements Collections_{

    private Object[] objects = new Object[10];
    private int index;

    public int size(){
        return objects.length;
    }

    public void add(Object object){
        //如果数组长度超出则进进行数组长度的动态扩充,jdk中默认的数组扩种是按照50%
        if (index == objects.length){
            Object[] newObject = new Object[objects.length * 2];
            System.arraycopy(objects,0,newObject,0,objects.length);
            objects = newObject;
        }

        objects[index] = object;
        index ++;
    }
}

//链表的方式存储数据,链表存储2部分数据，存储当前对象以及指向下一个对象的值
class LinkedList_ implements Collections_ {

    private Node head;
    private Node tail;

    private int size;

    public void add(Object object){
       Node node = new Node(object);
       node.next = null;
       if (head == null){
           head = node;
           tail = node;
       }

       tail.next = node;
       tail = node;
       size ++;
    }

    class Node{
        private Object object;
        private Node next;

        Node(Object object){
            this.object = object;
        }
    }

    public int size(){
        return size;
    }

}

interface Collections_{
    public void add(Object object);
    int size();
}

class Test{
    public static void main(String[] args) {
        Collections_ collections_ = new ArrayList_();
        for (int i = 0; i < 20; i++)
            collections_.add("s"+i);
        System.out.println(collections_.size());

        Collections_ collections1_ = new LinkedList_();
        for (int i = 0; i <20; i++)
            collections1_.add("s"+i);
        System.out.println(collections1_.size());

    }
}
