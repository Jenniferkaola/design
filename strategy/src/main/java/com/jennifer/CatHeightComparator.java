package com.jennifer;

/**
 * ClassName CatHeightComparator
 * author by jennifer
 * Date 2021/8/17
 */
public class CatHeightComparator implements Comparator<Cat>{
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.getHeight() > o2.getHeight()) return 1;
        else if (o1.getHeight() < o2.getHeight()) return -1;
        else
        return 0;
    }
}
