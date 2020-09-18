package com.licslan.week02;

import com.licslan.week00.ArrayGenerator;
import com.licslan.week01.SortingHelper;

import java.util.Arrays;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class InsertionSort {
    //插入排序法 适合近乎有序的数据 算法复杂度
    private InsertionSort(){}
    //未优化前
    public static <E extends Comparable<E>> void insertSort(E[] arr){
        //外层循环从第一个元素开始遍历
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到到合适位置  内层循环从第二元素开始和前面的元素对比  后面和外层循环的元素对比大小  后面的小些就和前面的元素交换位置
/*            for(int j=i;j-1>=0;j--){
                //前面的元素如果比后面的元素大  就把后面的元素移到前面交换位置就好了
                if(arr[j].compareTo(arr[j-1])<0){  //j索引位置元素 小于 j-1索引位置元素 也就是后面的元素小于前面位置的
                    swap(arr,j-1,j);
                }else break;
            }*/
            for (int j = i; j-1>=0 && arr[j].compareTo(arr[j-1])<0 ; j--) {
                swap(arr, j-1, j);
            }
        }

    }



    /**
     * 一点小的优化  哪怕多次赋值 -->（1次操作）而不是交换操作 -->（多3次操作） O(n^2)
     * 插入排序法：
     * arr[0,i)已排序 arr[i...n)未排序  循环不变量 本次方案实现
     * arr[0,i)未排序 arr[i...n)已排序
     * */
    public static <E extends Comparable<E>> void insertSort2(E[] arr){
        //外层循环从第一个元素开始遍历
        for (int i = 0; i < arr.length; i++) {
          //将arr[i]插入到合适的位置
            E t= arr[i]; //暂存
            int j;       //arr[i]实际要插入的位置
            //如果遍历过程发现当前的之前比前面的值小 当前暂存的值就要往后移动  并非交换位置
            for (j = i; j-1 >=0 && t.compareTo(arr[j-1])<0; j--) {
                arr[j]=arr[j-1];
            }
            // 将要插入的值赋值给要插入的位置
            arr[j]=t;
        }

        //外层循环 0~i
        //内存循环 j从i开始  直到遍历到最后为1
        //--->O(n^2) 插入排序法重要特性： 如果数组是有序的   那么内层循环就是常数级别的操作  那么就是O(n)
        //然而整体而言还是O(n^2) 最坏的打算下
    }


    //从后望前找
    public static <E extends Comparable<E>> void insertSort3(E[] arr){
        for(int i = arr.length - 1; i >= 0; i --){

            // 将 arr[i] 插入到合适的位置
            E t = arr[i];
            int j;
            for(j = i; j + 1 < arr.length && t.compareTo(arr[j + 1]) > 0; j ++){
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }

    }


    /**
     * 利用插入排序法优化归并排序
     * */
    public static <E extends Comparable<E>> void insertSort3(E[] arr,int l,int r){
        for (int i = l; i <= r; i++) {
            //将arr[i]插入到合适的位置
            E t= arr[i]; //暂存
            int j;       //arr[i]实际要插入的位置
            //如果遍历过程发现当前的之前比前面的值小 当前暂存的值就要往后移动  并非交换位置
            for (j = i; j-1 >=l && t.compareTo(arr[j-1])<0; j--) {
                arr[j]=arr[j-1];
            }
            // 将要插入的值赋值给要插入的位置
            arr[j]=t;
        }

    }


    /**
     * 交换2个元素的位置
     * */
    private static <E> void swap(E[] arr, int i, int j ) {
        E tmp= arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    //测试用例
//    public static void main(String[] args) {
//        Integer[] data = new Integer[]{1,23,45,5,2};
//        insertSort(data);
//        for (Integer datum : data)
//            System.out.print(datum + " ");
//        System.out.println();
//
//        int[] dataSize={10000};
//        for (int n : dataSize){
//            Integer[] arr1 = ArrayGenerator.arrayRandomGenerator(n, n);
//            Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
//            //Integer[] arr2 = ArrayGenerator.arrayRandomGenerator(n, n);
//            SortingHelper.testSort("InsertionSort",arr1);
//            SortingHelper.testSort("InsertionSort2",arr2);
//        }
//    }


    //测试用例
    public static void main(String[] args) {
        int[] dataSize={10000,100000};
        for (int n : dataSize){
            System.out.println("Random Array:");
            Integer[] arr1 = ArrayGenerator.arrayRandomGenerator(n, n);
            Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
            SortingHelper.testSort("SelectionSort",arr1);
            SortingHelper.testSort("InsertionSort2",arr2);

            System.out.println();

            System.out.println("Order Array:");
            Integer[] arr3 = ArrayGenerator.arrayOrderGenerator(n);
            Integer[] arr4 = Arrays.copyOf(arr1,arr1.length);
            SortingHelper.testSort("SelectionSort",arr3);
            SortingHelper.testSort("InsertionSort2",arr4);

            System.out.println();

            //测试用例结果
//            Random Array:
//            SelectionSort, n = 10000 : 0.137250 s
//            InsertionSort2, n = 10000 : 0.158634 s
//
//            Order Array:
//            SelectionSort, n = 10000 : 0.068863 s   O(n^2)
//            InsertionSort2, n = 10000 : 0.000413 s  O(n)
//
//            Random Array:
//            SelectionSort, n = 100000 : 18.551887 s
//            InsertionSort2, n = 100000 : 28.815100 s
//
//            Order Array:
//            SelectionSort, n = 100000 : 6.427380 s
//            InsertionSort2, n = 100000 : 0.003327 s


        }
    }
}
