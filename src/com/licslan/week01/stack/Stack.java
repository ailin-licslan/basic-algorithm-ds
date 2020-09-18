package com.licslan.week01.stack;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public interface Stack<E> {
    //栈的大小
    int getSize();
    //栈是否为空
    boolean isEmpty();
    //向栈顶添加元素
    void push(E o);
    //从栈顶取出元素
    E pop();
    //获取栈顶的那个元素
    E peek();

    /**
     * 1.从用户的角度看，支持这些操作就好
     * 2.具体底层实现 用户不关心
     * 3.实际底层有多种实现方式
     *
     * 利用动态数组来实现栈
     * */
}
