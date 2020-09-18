package com.licslan.week00;

import com.licslan.week01.SelectionSortGeneric;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class LinerSearch01 {

    /**
     * 不允许外界创建对象调用 可以这样设计 private
     * */
    private LinerSearch01() {
    }

    /**
     * 线性查找  给定一个目标值  和一组数据  找到目标数据在这组数据里面的下标  泛型方法 传入的是任意类型
     * Java 8 中基本数据类型  在泛型不支持  支持其对应的包装类
     * */

    public static <E> int linerSearch(E[] data,E target){
        for (int i = 0; i < data.length; i++)
            if(data[i].equals(target)) //注意== equals   维护循环不变量
                return i;

        return -1;
    }

    public static void main(String[] args) {
        Integer[] data={111,312,33,4,56,8};
        System.out.println(LinerSearch01.linerSearch(data,111));

        Student[] students = {new Student(18),new Student(19),new Student(20)};

        System.out.println(LinerSearch01.linerSearch(students,new Student(20)));  //-1  ？ Java 比较2对象比较的是类的地址

        System.out.println("=====================================================");

        //测试用例
        int[] dataSize={1000000,10000000};
        for (int n:dataSize) {
            Integer[] testData = ArrayGenerator.arrayOrderGenerator(n);
            long start = System.nanoTime();
            for(int k=0;k<100;k++)
                LinerSearch01.linerSearch(testData,n);
            long end = System.nanoTime();
            System.out.println((end-start)/1000000000.0+"秒");
        }


        System.out.println("============================00000=========================");

        //测试用例
        int[] dataSize2={10000,10000};
        for (int n:dataSize2) {
            Integer[] testData = ArrayGenerator.arrayRandomGenerator(n,n);
            long start = System.nanoTime();
            for(int k=0;k<100;k++)
                LinerSearch01.linerSearch(testData,n);
            long end = System.nanoTime();
            System.out.println((end-start)/1000000000.0+"秒");

            System.out.println("==============================222=======================");

            long start1 = System.nanoTime();
            for(int k=0;k<100;k++)
                SelectionSortGeneric.sort(testData);
            long end1 = System.nanoTime();
            System.out.println((end1-start1)/1000000000.0+"秒");

            System.out.println("==============================333=======================");

        }
    }
}
