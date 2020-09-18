package com.licslan.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 专栏  ♥  NO1
 *
 * @author LICSLAN
 * */
public class TwoSum {
    public static void main(String[] args) {
        int[] x = new int[]{2,2,3,1,2,2,3,1};
        System.out.println(twoSum(x,4));
    }
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * TODO  FINISHED !!!
     *
     * @return*/
    public static int[] twoSumALL (int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        int[] res = new int[]{};
        for(int i=0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        for (List re : result) {
            System.out.println("所有的排列组合[index1:" + re.get(0) + "   index2:" + re.get(1) + "]");
        }
        //集合转换成int[]
        //result.toArray()
        return res;
    }

    public static int[] twoSum (int[] numb, int target) {
         int[] x;
        for(int i=0;i<numb.length;i++){
            for(int j = i+1;j<numb.length;j++){
                if((numb[i]+numb[j])==target){
                    for (int i1 : new int[]{i, j}) {
                        System.out.println(i1);
                    }
                    return new int[]{i,j};
                }
            }
        }


        throw new IllegalArgumentException("No two sum solution");
    }
}
