package com.licslan.week00;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class TimeComplexityAnalysis {

    //复杂度分析：表示算法的性能  算法运行的上界

    //常数不重要理解的时候，复杂度藐视是随着数据规模n的增大  算法性能的变化趋势

    //T1=1000n   T2=2n^2      当n>5000  O(n)<O(n^2)

    //常见的算法复杂度

    //遍历一个n*n二维数组  O(n的平方)
    // 这里需要明确分析出n是谁？
    //遍历一个a*a二维数组  a*a=n  ? O(n)
    //数字n的二进制位数？  O(logn)  不关注底是多少  换底公式
    //数字n的所有约数？  O(n) or O(根号n)
    //长度为n的二进制数字？ O(2的n次方)  指数级别<不在经典算法范畴>
    //长度为n的数组的所有排列 ？O(n!)    阶层级别<不在经典算法范畴>
    //判断数字n是否是偶数？ return n % 2 ==0  O(1)

    //O(1)<O(logn)<O(根号n)<O(n)<O(nlogn)<O(n的平方)<O(2的n次方)<O(n!)

    public static void main(String[] args) {
        System.out.println("Hello Algorithm ! licslan coming");
    }

}
