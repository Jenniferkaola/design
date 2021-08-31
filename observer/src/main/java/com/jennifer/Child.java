package com.jennifer;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName Child
 * author by jennifer
 * Date 2021/8/30
 */
public class Child {

    private List<Observer> observers = new ArrayList(){
        {
            add(new DadObserver());
            add(new MumObserver());
            add(new DogObserver());
        }
    };

    private Boolean cry = false;

    public void cry(){
        cry = true;
    }

    private void wakeUp(){
        if (cry){
            WeakUpEvent weakUpEvent = new WeakUpEvent(System.currentTimeMillis(),"bed",this);
            for (Observer observer : observers)
                observer.actionOnWakeUp(weakUpEvent);
        }

    }

    public static void main(String[] args) {
        Child child = new Child();
        child.cry();
        child.wakeUp();
    }
}

interface Event<T>{

}

class WeakUpEvent implements Event<Child>{
    private long time;
    private String loc;
    private Child source;

    public WeakUpEvent(long time,String loc,Child source){
        this.time = time;
        this.loc = loc;
        this.source = source;
    }
}

interface Observer{
    public void actionOnWakeUp(Event event);
}


class DadObserver implements Observer{

    @Override
    public void actionOnWakeUp(Event event) {
        System.out.println("dab feeding.........");
    }
}

class MumObserver implements Observer{

    @Override
    public void actionOnWakeUp(Event event) {
        System.out.println("mum hugging.......");
    }
}

class DogObserver implements Observer{

    @Override
    public void actionOnWakeUp(Event event) {
        System.out.println("dog wangwangwang......");
    }
}