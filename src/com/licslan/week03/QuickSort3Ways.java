package com.licslan.week03;

import com.licslan.week02.ArrayGenerator;

import java.util.Arrays;
import java.util.Random;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 *
 * 三路快速排序算法
 * */
public class QuickSort3Ways {

    private QuickSort3Ways(){}


    public static <E extends Comparable<E>> void sort(E[] arr){

        Random rnd = new Random();
        sort(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd){

        if(l >= r) return;

        int p = partition(arr, l, r, rnd);
        sort(arr, l, p - 1, rnd);
        sort(arr, p + 1, r, rnd);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random rnd){

        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1...j] < v ; arr[j+1...i] >= v
        int j = l;
        for(int i = l + 1; i <= r; i ++)
            if(arr[i].compareTo(arr[l]) < 0){
                j ++;
                swap(arr, i, j);
            }

        swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort2ways(E[] arr){

        Random rnd = new Random();
        sort2ways(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r, Random rnd){

        if(l >= r) return;

        int p = partition2ways(arr, l, r, rnd);
        sort2ways(arr, l, p - 1, rnd);
        sort2ways(arr, p + 1, r, rnd);
    }

    private static <E extends Comparable<E>> int partition2ways(E[] arr, int l, int r, Random rnd){

        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while(true){

            while(i <= j && arr[i].compareTo(arr[l]) < 0)
                i ++;

            while(j >= i && arr[j].compareTo(arr[l]) > 0)
                j --;

            if(i >= j) break;

            swap(arr, i, j);

            i ++;
            j --;
        }

        swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort3ways(E[] arr){

        Random rnd = new Random();
        sort3ways(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r, Random rnd){

        if(l >= r) return;


        /** 三路快速排序的 partition 过程 **/

        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v
        int lt = l, i = l + 1, gt = r + 1;
        while(i < gt){

            if(arr[i].compareTo(arr[l]) < 0){
                lt ++;
                swap(arr, i, lt);
                i ++;
            }
            else if(arr[i].compareTo(arr[l]) > 0){
                gt --;
                swap(arr, i, gt);
            }
            else{ // arr[i] == v
                i ++;
            }
        }

        swap(arr, l, lt);

        /** 三路快速排序的 partition 过程结束 **/

        // 递归调用
        sort3ways(arr, l, lt - 1, rnd);
        sort3ways(arr, gt, r, rnd);
    }

    private static <E> void swap(E[] arr, int i, int j){

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){

        int n = 20000;//<2-3万 （免得栈溢出）

        Integer[] arr = ArrayGenerator.arrayRandomGenerator(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array");
        SortingHelper.sortTest(MergeSort.class,arr);
        SortingHelper.sortTest(QuickSort3Ways.class, arr2);

        System.out.println();


        arr = ArrayGenerator.arrayOrderGenerator(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Ordered Array");
        SortingHelper.sortTest(QuickSortOptimized.class, arr);
        SortingHelper.sortTest(QuickSort3Ways.class, arr2);
        System.out.println();


        arr = ArrayGenerator.arrayRandomGenerator(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Same Value Array");
        SortingHelper.sortTest(QuickSortOptimized.class, arr);
        SortingHelper.sortTest(QuickSort3Ways.class, arr2);
        System.out.println();
    }
}
