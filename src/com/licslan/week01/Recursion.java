package com.licslan.week01;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class Recursion {
    /**
     * 递归
     * 本质上，将原来的问题 转化为一个相同的更小的问题
     * sum(arr[0...n-1])=arr[0]+sum(arr[1...n-1])  更小的同一问题
     * sum(arr[1...n-1])=arr[1]+sum(arr[2...n-1])  更小的同一问题
     *             ......
     * sum(arr[n-1...n-1])=arr[n-1]+sum([])        更小的同一问题
     * */
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    /**
     * 计算arr[i...n]区间所有数字的和
     * */
    private static int sum(int[] arr, int i) {
        if(i==arr.length)
            return 0;
        return arr[i]+sum(arr,i+1);
    }
}
