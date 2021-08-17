package com.jennifer;

/**
 * ClassName Sort
 * author by jennifer
 * Date 2021/8/17
 */
public class Sort<T> {

    //设置一个比较器进行比较
    public void sort(T[] arr,Comparator<T> comparator){
        for (int i = 0; i <arr.length-1; i++){
            int minPop = i;
            for (int j = i + 1; j<arr.length; j++){
                minPop = comparator.compare(arr[minPop],arr[j]) == -1 ? minPop : j;
            }
            T temp = arr[i];
            arr[i] = arr[minPop];
            arr[minPop] = temp;
        }

    }

    //比较类继承comparable接口
    public static void sort(Comparable[] comparables){
        for (int i = 0;i<comparables.length - 1; i++){
            int minPop = i;
            for (int j = i+1; j<comparables.length; j++){
                minPop = comparables[minPop].compare(comparables[j]) == -1 ? minPop : j;
            }
            swap(comparables,i,minPop);
        }
    }

    static void swap(Comparable[] comparables,int i,int j){
        Comparable comparable = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = comparable;
    }

    public static void sort(int arr[]){
      for (int i = 0; i<arr.length - 1; i++){
          int minPop = i;
          for (int j = i+1;j<arr.length; j++){
              minPop = arr[minPop] > arr[j] ? j : minPop;
          }
          swap(arr,i,minPop);
      }
    }

    static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
