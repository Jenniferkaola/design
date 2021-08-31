package com.jennifer.day02;

/**
 * ClassName ArrayList_
 * author by jennifer
 * Date 2021/8/31
 */
public class ArrayList_ implements Collections_{
    private Object[] objects = new Object[10];
    private int index;

    public int size(){
        return index;
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

    public Iterator_ iterator(){
        return new ArrayListIterator_();
    }

    //定义内部类实现数组的遍历
    class ArrayListIterator_ implements Iterator_{

        private int index = 0;

        @Override
        public boolean hasNext() {
            if (index < size())
             return true;
            else return false;
        }

        @Override
        public Object next() {
            return objects[index ++];
        }
    }

}

class LinkedList implements Collections_{

    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public void add(Object object) {
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

    //定义iterator遍历链表
    class LinkedListIterator_ implements Iterator_{

        private Node current = head;

        @Override
        public boolean hasNext() {
            if (current == null)
                return false;
            return true;
        }

        @Override
        public Object next() {
            if (current !=null){
                Node returnNode = current;
                current = current.next;
                return returnNode.object;
            }
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator_();
    }

    class Node{
        Node next;
        Object object;

        Node(Object object){
            this.object = object;
        }
    }
}

interface Collections_ {
    void add(Object object);
    int size();
    Iterator_ iterator();
}

//统一遍历数组和链表,必须实现2个接口
interface Iterator_{
    boolean hasNext();
    Object next();
}

class Test{
    public static void main(String[] args) {
       /* Collections_ collections_ = new ArrayList_();
        for (int i = 0; i<60;i++)
            collections_.add("s"+i);
        Iterator_ iterator_ = collections_.iterator();
        while (iterator_.hasNext()){
            System.out.println(iterator_.next());
        }*/

        Collections_ collections_ = new LinkedList();
        for (int i = 0; i <60; i++)
            collections_.add("s"+i);
        Iterator_ iterator = collections_.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
