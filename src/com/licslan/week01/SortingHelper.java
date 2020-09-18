package com.licslan.week01;

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
            SelectionSortGeneric.sort(arr);
        }
        else if(sortName.equals("InsertionSort")) {
            InsertionSort.insertSort(arr);
        }
        else if(sortName.equals("InsertionSort2")) {
            InsertionSort.insertSort2(arr);
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
        }else {
            System.out.println("其他类插入法");
        }
        long end=System.nanoTime();
        double res=(end-start)/1000000000.0;
        System.out.println("长度:"+arr.length+",单位:"+res+"s");
        if(!SortingHelper.isSorted(arr)){
            throw new RuntimeException("不是有效的排序方法");
        }
    }
}
