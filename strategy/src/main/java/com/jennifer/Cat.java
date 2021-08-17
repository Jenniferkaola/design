package com.jennifer;

/**
 * ClassName Cat
 * author by jennifer
 * Date 2021/8/17
 */
public class Cat implements Comparable<Cat>{

    private int weight;
    private int height;

    Cat(int weight,int height){
        this.weight = weight;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int compare(Cat obj) {
        if (this.weight > obj.weight)
            return 1;
        else if (this.weight < obj.weight) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
