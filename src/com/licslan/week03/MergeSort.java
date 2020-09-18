package com.licslan.week03;

import com.licslan.week02.ArrayGenerator;
import com.licslan.week02.InsertionSort;
import com.licslan.week02.SortingHelper;

import java.util.Arrays;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class MergeSort {
    /**
     * 归并排序算法  自顶向下  O(nlogn)
     * */
    private MergeSort(){}
    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr,0,arr.length-1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr,int l,int r){
        if(l >= r) return;
        //int mid = (l+r)/2;
        int mid = l+(r-l)/2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        merge(arr,l,mid,r);
    }

    public static <E extends Comparable<E>> void sort2(E[] arr){
        sort2(arr,0,arr.length-1);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr,int l,int r){
        if(l >= r)return;
        //int mid = (l+r)/2;
        int mid = l+(r-l)/2;
        sort2(arr, l, mid);
        sort2(arr, mid+1, r);
        //优化一下
        if(arr[mid].compareTo(arr[mid+1])>0)
            merge(arr,l,mid,r);
    }


    public static <E extends Comparable<E>> void sort3(E[] arr){
        sort3(arr,0,arr.length-1);
    }

    /**
     * 插入排序优化归并排序法  （小规模数据适用插入排序法+归并排序法）
     * */
    private static <E extends Comparable<E>> void sort3(E[] arr,int l,int r){
        //if(l >= r)return;
        //int mid = (l+r)/2;
        if(l-r<=15){
            InsertionSort.insertSort3(arr,l,r);
            return;
        }
        int mid = l+(r-l)/2;
        sort3(arr, l, mid);
        sort3(arr, mid+1, r);
        //优化一下
        if(arr[mid].compareTo(arr[mid+1])>0)
            merge(arr,l,mid,r);
    }

    /**
     * 合并有序区间arr[l,mid] & arr[mid+1,r]
     * */
    private static <E extends Comparable<E>>void merge(E[] arr,int l,int mid,int r){
        E[] temp = Arrays.copyOfRange(arr,l,r+1); //to 不包含
        //l mid r
        int i=l,j = mid+1;

        //每轮循环为arr[k]赋值  找最小值
        for (int k=i;k<=r;k++){
            //i越界 左边没有元素了
            if(i>mid){
                arr[k] = temp[j-l];j++;
            }
            //j越界  右边没有元素了
            else if(j>r){
                //有一个l的偏移量的位置
                arr[k] = temp[i-l];i++;
            }
            //如果左边的数组比右边的小
            else if(temp[i-l].compareTo(temp[j-l])<=0){
                arr[k] = temp[i-l];i++;
            }
            //如果左边的数组比右边的大
            else {
                arr[k] = temp[j-l];j++;
            }
        }
    }




    public static <E extends Comparable<E>> void sort4(E[] arr){
        E[] temp = Arrays.copyOf(arr,arr.length);
        sort4(arr,0,arr.length-1,temp);
    }

    private static <E extends Comparable<E>> void sort4(E[] arr,int l,int r,E[] temp){
        if(l >= r)return;
        //int mid = (l+r)/2;
        int mid = l+(r-l)/2;
        sort4(arr, l, mid,temp);
        sort4(arr, mid+1, r,temp);
        merge4(arr,l,mid,r,temp);
    }


    /**
     * 合并有序区间arr[l,mid] & arr[mid+1,r]  优化内存
     * */
    private static <E extends Comparable<E>>void merge4(E[] arr,int l,int mid,int r,E[] temp){
        //E[] temp = Arrays.copyOfRange(arr,l,r+1); //to 不包含
        //l mid r

        System.arraycopy(arr, l,temp,l,r-l+1);
        int i=l,j = mid+1;

        //每轮循环为arr[k]赋值  找最小值
        for (int k=i;k<=r;k++){
            //i越界 左边没有元素了
            if(i>mid){
                arr[k] = temp[j];j++;
            }
            //j越界  右边没有元素了
            else if(j>r){
                //有一个l的偏移量的位置
                arr[k] = temp[i];i++;
            }
            //如果左边的数组比右边的小
            else if(temp[i-l].compareTo(temp[j])<=0){
                arr[k] = temp[i];i++;
            }
            //如果左边的数组比右边的大
            else {
                arr[k] = temp[j-l];j++;
            }
        }
    }



    /**
     * 自底向上 归并写法
     * */
    public static <E extends Comparable<E> > void sortBU(E[] arr){
        E[] temp = Arrays.copyOf(arr,arr.length);
        int n = arr.length;
        for (int sz = 1; sz < n; sz+=sz) {
            //遍历合并的两个区间的起始位置i
            //合并[i,i+sz-1] 和 [i+sz,Math.min(i+sz+sz-1,n-1)]
            for (int i = 0; i+sz < n; i+= sz+ sz) {
                if(arr[i+sz-1].compareTo(arr[i+sz])>0)
                    merge4(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1),temp);
            }

        }

    }







    public static void main(String[] args) {
        int n =100000; //10万级别数据
        Integer[] arr = ArrayGenerator.arrayRandomGenerator(n,n);
        System.out.println(arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(arr2.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        System.out.println(arr3.length);

        //SortingHelper.testSort("MergeSort",arr);
        SortingHelper.sortTest(com.licslan.week01.InsertionSort.class,arr);                //O(n^2)
        SortingHelper.sortTest(com.licslan.week01.SelectionSortGeneric.class,arr2);        //O(n^2)
        SortingHelper.sortTest(MergeSort.class,arr3);                   //O(nlogn)

        /**
         * 测试用例结果
         * MergeSort, n = 100000 : 0.103284 s
         * 如此看来 归并排序法比插入排序法 选择排序法效率要高太多了 ？？？ so why
         *
         * 100000
         * 100000
         * 100000
         * 是插入排序类
         * com.licslan.week01.InsertionSort 长度:100000,单位: 13.8395967s
         * 是选择排序类
         * com.licslan.week01.SelectionSortGeneric 长度:100000,单位: 17.2215401s
         * 是归并排序类
         * com.licslan.week02.MergeSort 长度:100000,单位: 0.105698s
         *
         *
         * 对merge进行判断后  对完全有序的数组 归并排序是O(n)
         * 插入排序法对完全有序的数组是O(n)的
         * */
    }
}
