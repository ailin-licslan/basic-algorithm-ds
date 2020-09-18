package com.licslan.week02;

import java.util.Random;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class ArrayGenerator {
    private ArrayGenerator(){}
    //order array
    public static Integer[] arrayOrderGenerator(int data){
        Integer[] arr = new Integer[data];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
        return arr;
    }
    //random array 范围[0,bound]  随机长度为data
    public static Integer[] arrayRandomGenerator(int data,int bound){
        Integer[] arr = new Integer[data];
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            arr[i]=random.nextInt(bound);
        }
        return arr;
    }

}
