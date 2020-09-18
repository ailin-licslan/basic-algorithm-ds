package com.licslan.week03;

import com.licslan.week01.InsertionSort;
import com.licslan.week01.SelectionSortGeneric;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class SortingHelper {

    private SortingHelper(){}
    //判断排序完的数组是否有序
    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i = 1; i < arr.length; i++)
            if(arr[i-1].compareTo(arr[i])>0)return false;

        return true;
    }

    /**
     * 非反射方式
     * */
    public static <E extends Comparable<E>> void testSort(String sortName, E[] arr){

        long start = System.nanoTime();

        //这里可以使用反射的方式改写
        if(sortName.equals("SelectionSort")) {
            //选择排序法
            SelectionSortGeneric.sort(arr);
        }
        else if(sortName.equals("InsertionSort")) {
            //插入排序法 （交换位置写法）
            InsertionSort.insertSort(arr);
        }
        else if(sortName.equals("InsertionSort2")) {
            //插入排序法 （不交换位置）
            InsertionSort.insertSort2(arr);
        }
        else if(sortName.equals("MergeSort")){
            //归并排序法
            MergeSort.sort(arr);
        }
        long end = System.nanoTime();
        double time = (end-start)/1000000000.0;
        //System.out.println(time+"s");

        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortName+" failed");

        System.out.println(String.format("%s, n = %d : %f s",sortName,arr.length,time));
    }

    /**
     * 反射方式
     * */
    public static<E extends Comparable<E>> void sortTest(Class cl,E[]arr){
        long start=System.nanoTime();
        if(cl.equals(SelectionSortGeneric.class)){
            System.out.println("是选择排序类");
            SelectionSortGeneric.sort(arr);
        }else if(cl.equals(InsertionSort.class)){
            System.out.println("是插入排序类");
            InsertionSort.insertSort2(arr);
        }else if(cl.equals(MergeSort.class)){
            System.out.println("是归并排序类");
            MergeSort.sort(arr);
        }
        else if(cl.equals(QuickSort.class)){
            System.out.println("是快速排序类");
            QuickSort.sort(arr);
        }else if(cl.equals(QuickSortOptimized.class)){
            System.out.println("是快速排序优化类");
            QuickSortOptimized.sort2(arr);
        }
        else if(cl.equals(QuickSort2Ways.class)){
            System.out.println("是双路快速排序类");
            QuickSort2Ways.sort2ways(arr);
        }
        else {
            System.out.println("其他类插入法");
        }
        long end=System.nanoTime();
        double res=(end-start)/1000000000.0;
        System.out.println(cl.getName()+" 长度:"+arr.length+",单位: "+res+"s");
        if(!SortingHelper.isSorted(arr)){
            throw new RuntimeException("不是有效的排序方法");
        }
    }
}
