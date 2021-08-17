package com.jennifer;

import java.util.Arrays;

/**
 * ClassName Main
 * author by jennifer
 * Date 2021/8/17
 */
public class Main {
    public static void main(String[] args) {
        int arr[] = {3,9,7,5,2};
        //Sort.sort(arr);
        //System.out.println(Arrays.toString(arr));

        Comparable<Cat>[] comparable = new Comparable[]{new Cat(3,4),new Cat(5,7),new Cat(2,8)};
        //Sort.sort(comparable);
        //System.out.println(Arrays.toString(comparable));

        //使用comparator比较器进行数组比较
        Cat[] cats = new Cat[]{new Cat(3, 4), new Cat(5, 7), new Cat(2, 8)};
        Sort<Cat> sort = new Sort<>();
        Comparator<Cat> comparator = new CatWeightComparator();
        sort.sort(cats, comparator);
        System.out.println(Arrays.toString(cats));

        Comparator<Cat> heightComparator = new CatHeightComparator();
        sort.sort(cats,heightComparator);
        System.out.println(Arrays.toString(cats));
    }
}
