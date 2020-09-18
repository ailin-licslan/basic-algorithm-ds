package com.licslan.week03;

import com.licslan.week02.ArrayGenerator;

import java.util.Arrays;
import java.util.Random;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class QuickSort {

    /**
     * 如何求解Partition
     * 1.使用了额外的空间  非原地排序   开辟2个额外空间  和指定元素对比  小的放左边空间 大的放右边空间
     *
     * 2.如何原地进行Partition  √
     *
     * */
    private QuickSort(){}
    public static <E extends Comparable<E>> void sort(E[]arr){
        sort(arr,0,arr.length-1);
    }

    private static <E extends Comparable<E> > void sort(E[]arr,int l,int r){
        if(l>=r)return;
        int p = partition(arr, l, r);
        sort(arr, l, p-1); //<arr[p]
        sort(arr, p+1, r); //>arr[p]

        //这里和归并排序算法的顺序是不一样的  这里是先求值 再递归  规定是先递归和合并

    }

    /**
     * 找到中间的那个值  这个值大于左边右边右边  比如  5  [1，2，3，5，6，7，9，10]
     * **/
    private static <E extends Comparable<E> > int partition(E[]arr,int l,int r){

        /**
         * 改造点 生成随机索引 修改第一版
         * 生成[l,r]之间的随机索引  不加这个改造点  有序的数组数据太大了 会栈溢出
         * 这里可以改造不必每次都new Random() 每次创建对象会有内存的消耗 不是必要的 只生产一个变量 作为参数传进来
         * */
        int p=l+(new Random()).nextInt(r-l+1);
        swap(arr,l,p);


        //循环不变量  arr[l+1...j]<v;  arr[j+1...i]>=v;
        int j=l;
        for (int i = l+1; i <= r; i++) {
            if(arr[i].compareTo(arr[l]) < 0){
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr,l,j);
        return j;
    }
    private static <E> void swap(E[] arr, int i, int j ) {
        E tmp= arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static void main(String[] args) {
        int n =100000;//100万
        //随机的
        Integer[] arr = ArrayGenerator.arrayRandomGenerator(n,n);
        System.out.println(arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest(com.licslan.week03.MergeSort.class,arr);                //O(nlogn)
        SortingHelper.sortTest(com.licslan.week03.QuickSort.class,arr2);               //O(nlogn)


        /**
         * 测试用例结果
         *
         * 1000000   100万
         * 是归并排序类
         * com.licslan.week03.MergeSort 长度:1000000,单位: 0.9183695s
         * 是快速排序类
         * com.licslan.week03.QuickSort 长度:1000000,单位: 0.4853571s
         *
         * 10000000 1000万
         * 是归并排序类
         * com.licslan.week03.MergeSort 长度:10000000,单位: 5.3469955s
         * 是快速排序类
         * com.licslan.week03.QuickSort 长度:10000000,单位: 6.9350026s
         * */

        //非随机的有序的  有问题  性能会退化 栈溢出
        arr = ArrayGenerator.arrayOrderGenerator(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest(com.licslan.week03.MergeSort.class,arr);                //O(nlogn)  100万  就是20  10亿就是30
        SortingHelper.sortTest(com.licslan.week03.QuickSort.class,arr2);               //O(n^2)  栈溢出了（每次取左边的  划分太不均衡了  so随机取）... 递归深度就是O(n) 100万 就是100000


        /**
         * 改造后性能就会恢复
         *
         * 1000000
         * 是归并排序类
         * com.licslan.week03.MergeSort 长度:1000000,单位: 0.5225214s
         * 是快速排序类
         * com.licslan.week03.QuickSort 长度:1000000,单位: 0.50452s
         * 是归并排序类
         * com.licslan.week03.MergeSort 长度:1000000,单位: 0.1520383s
         * 是快速排序类
         * com.licslan.week03.QuickSort 长度:1000000,单位: 0.198337s
         *
         * */

        /**
         * 快速排序当每个元素相同时，排序性能也会下降  未改造之前会发生栈溢出  new Random()...
         * */
        Integer[] arrSame = ArrayGenerator.arrayRandomGenerator(10000,1);
        SortingHelper.sortTest(com.licslan.week03.QuickSort.class,arrSame);

        /***
         * 升级之路  双路快速排序算法  解决性能慢的问题 O(n^2)
         *
         * */
    }
}
