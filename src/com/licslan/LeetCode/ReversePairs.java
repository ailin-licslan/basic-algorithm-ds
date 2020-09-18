package com.licslan.LeetCode;
/**
 * LeetCode 专栏  ♥  NO51
 *
 * @author LICSLAN
 * */
public class ReversePairs {

    /**
     * 递归算法也算分治算法
     * */
    private int res =0;
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [7,5,6,4]
     * 输出: 5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public int reversePairs(int[] nums) {

        int[] temp = new int[nums.length];
        res=0;
        sort4(nums,0,nums.length-1,temp);
        return res;
    }
    private  <E extends Comparable<E>> void sort4(int[] arr,int l,int r,int[] temp){
        if(l >= r)return;
        //int mid = (l+r)/2;
        int mid = l+(r-l)/2;
        sort4(arr, l, mid,temp);
        sort4(arr, mid+1, r,temp);
        merge4(arr,l,mid,r,temp);
    }


    /**
     * 合并有序区间arr[l,mid] & arr[mid+1,r]  优化内存
     * */
    private  <E extends Comparable<E>>void merge4(int[] arr,int l,int mid,int r,int[] temp){
        System.arraycopy(arr, l,temp,l,r-l+1);

        int i=l,j = mid+1;

        //每轮循环为arr[k]赋值  找最小值
        for (int k=i;k<=r;k++){
            //i越界 左边没有元素了
            if(i>mid){
                arr[k] = temp[j];j++;
            }
            //j越界  右边没有元素了
            else if(j>r){
                arr[k] = temp[i];i++;
            }
            //如果左边的数组比右边的小
            else if(temp[i]<=temp[j]){
                arr[k] = temp[i];i++;
            }
            //如果左边的数组比右边的大
            else {
                res+=mid-i+1;
                arr[k] = temp[j-l];j++;
            }
        }
    }
}
