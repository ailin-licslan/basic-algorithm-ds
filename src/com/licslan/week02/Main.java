package com.licslan.week02;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class Main {

    /**
     * 归并排序法
     * O(nlogn) 比插入排序和选择排序法性能更好
     * 不断切分的内容不断实现目标  递归  再进行合并
     *
     * MergeSort(arr,l,r)  int min = (l+r)/2
     * 对arr[l,mid]排序
     * MergeSort(arr,l,mid)
     * 对arr[mid+1,r]
     * MergeSort(arr,mid+1,r)
     * 将arr[l,mid]  &  arr[mid+1,r]进行一个合并
     * merge(arr,l,mid,r)
     * */
}
