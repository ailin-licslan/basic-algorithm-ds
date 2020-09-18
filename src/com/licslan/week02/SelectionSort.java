package com.licslan.week02;

import java.util.ArrayList;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class SelectionSort {
    private SelectionSort(){}
    /**
     * 选择排序非原地排序实现  (递归)
     * */
    public static ArrayList sortAfter(int[] sortBefore,ArrayList list){
        //3,4,1,5  先把最小拿出来  剩下的，再把其中最小的拿出来 ...... 每次选择还没处理的元素里最小的元素
        int minIndex = sortBefore[0];//定义最小值为该数组的第一个数
        int indexDel=0;//要删除元素的下标
        //遍历循环数组
        for (int i = 0; i < sortBefore.length; i++) {
            if(minIndex > sortBefore[i]){minIndex = sortBefore[i]; indexDel=i;}//The index need to be deleted
        }
        list.add(minIndex);
        //删除指定元素的生成新的数组
        int[] intNew = delAnyPos(sortBefore, indexDel);
        if(intNew.length>0) {
            sortAfter(intNew, list);
        }
        return list;
    }


    /**
     * 删除指定数组的指定下标元素
     * */
    public static int[] delAnyPos(int[] arr,int position){
        //判断是否合法
        if(position >= arr.length || position < 0){
            return null;
        }
        int[] res = new int[arr.length - 1];
        for(int i = 0;i<res.length;i++){
            if(i < position){
                res[i] = arr[i];
            }else{
                res[i] = arr[i + 1];
            }
        }
        return res;
    }
    //above have problems i did not finished  ~ Oops


    //arr[i...n) not sorted arr[0,i) have sorted 循环不变量
    //arr[i...n)中最小的值放在arr[i]位置

    /**
     * 选择排序原地排序实现
     * */
    public static void sort(int[] arr){
        //arr[0...i)有序  arr[i...n)无序
        for (int i = 0; i < arr.length; i++) {
            //arr[i...n)中最小的值索引
            int minIndex = i;//arr[i...n) 目前认为这个位置最小 arr[i] （其实不一定是最小）
            for (int j = i; j < arr.length; j++) {
                //如果从i开始往后面找里面的值比minIndex索引位置的值还小 就将minIndex改j
                if(arr[j]<arr[minIndex])
                    minIndex=j;
            }
            //找到之后就将之前的2个数据交换一个位置就好
            swap(arr,i,minIndex);
        }
    }

    /**
     * 交换2个元素的位置
     * */
    private static void swap(int[] arr, int i, int j ) {
        int tmp= arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static void main(String[] args) {
        int[] ints = {1, 34, 4, 5};
        SelectionSort.sort(ints);
        for (int i = 0; i < ints.length; i++)
            System.out.print(ints[i]+" ");
            System.out.println();
        System.out.println("========================================");

        for (int anInt : delAnyPos(ints,1)) {
            System.out.println(anInt);
        }
        int[] array = {12,1,2,45,30,50};
        int maxIndex = array[0];//定义最大值为该数组的第一个数
        int minIndex = array[0];//定义最小值为该数组的第一个数
        //遍历循环数组
        System.out.print("这个数组为：");
        for (int i = 0; i < array.length; i++) {
            //Max value
            if(maxIndex < array[i]){
                maxIndex = array[i];
            }
            //Min value
            if(minIndex > array[i]){
                minIndex = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println("这个数组的最大值为："+maxIndex+"\t最小值为："+minIndex);

        System.out.println("======================================================================");
        //非原地实现选择插入元素
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList1 = sortAfter(array, arrayList);
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i));
        }
    }


}
