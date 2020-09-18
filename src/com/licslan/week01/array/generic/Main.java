package com.licslan.week01.array.generic;


/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class Main {
    public static void main(String[] args) {


        //泛型数组测试用例测试Array
        Array<Integer> array = new Array<>(23);
        for (int i = 0; i < 20; i++) {
            array.addLast1(i);
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
