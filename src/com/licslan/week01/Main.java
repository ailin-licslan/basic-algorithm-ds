package com.licslan.week01;

import java.util.ArrayList;

import static com.licslan.week01.SelectionSort.sortAfter;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class Main {
    /**
     * 线性数据结构
     * 动态数组
     * 栈
     * 队列
     * 链表
     *
     * 动态数组/栈/队列 三者底层都是依托静态数组  考resize解决固定容量问题
     * 链表
     * 1.真正的动态数据结构（最简单的动态数据结构）
     * 2.更加深入的理解指针 （理解引用）
     * 3.更深入的理解递归
     * 4.辅助组成其他数据结构
     * */





    /***
     * 选择排序法
     * 0.非原地实现：先把最小拿出来  剩下的，再把其中最小的拿出来 ...... 每次选择还没处理的元素里最小的元素
     * 1.选择排序过程占用了额外的空间  可否原地完成？ （原地排序）
     * */
    public static void main(String[] args) {
        //非原地实现选择插入元素
        ArrayList arrayList = new ArrayList();
        int[] array = new int[]{1,2,3,2,87,21};
        ArrayList arrayList1 = sortAfter(array, arrayList);
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i));
        }
    }
}
