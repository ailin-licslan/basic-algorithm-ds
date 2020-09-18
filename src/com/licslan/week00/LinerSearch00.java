package com.licslan.week00;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class LinerSearch00 {

    /**
     * 不允许外界创建对象调用 可以这样设计
     * */
    private LinerSearch00() {
    }

    /**
     * 线性查找  给定一个目标值  和一组数据  找到目标数据在这组数据里面的下标
     * */

    public static int linerSearch(int[] data,int target){
        for (int i = 0; i < data.length; i++)
            if(data[i] == target)
                return i;

        return -1;
    }

    public static void main(String[] args) {
        int[] data={111,312,33,4,56,8};
        System.out.println(LinerSearch00.linerSearch(data,111));
    }
}
