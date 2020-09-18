package com.licslan.week01.array;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class Main {
    /**
     * 线性数据结构 数组
     * */
    public static void main(String[] args) {

        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
        int[] arr1= new int[]{100,100,50};
        for (int i = arr1.length - 1; i >= 0; i--) {
            System.out.println(arr1[i]);
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        //测试用例测试Array
        Array array = new Array(23);
        for (int i = 0; i < 20; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.addLast(200);//最后添加
        System.out.println(array);
        array.addFirst(200);//最前添加
        System.out.println(array);
        array.add(2,200);//指定索引位置添加 索引位置为2的地方添加200这个元素
        System.out.println(array);
        System.out.println(array.contains(2000));
        System.out.println(array.find(200));
        System.out.println(array.remove(1));
        array.removeElementALL(200);
        System.out.println(array);


        //测试用例结果
        /**
         * 50
         * 100
         * 100
         * 100
         * 100
         * 50
         * Array: size = 20 , capacity = 23
         * [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]
         * Array: size = 21 , capacity = 23
         * [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,200]
         * Array: size = 22 , capacity = 23
         * [200,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,200]
         * Array: size = 23 , capacity = 23
         * [200,0,200,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,200]
         * */
    }
}
