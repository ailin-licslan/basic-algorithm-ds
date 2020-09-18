package com.licslan.week01.queue;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public interface Queue<E> {

    //队列的大小
    int getSize();
    //队列是否为空
    boolean isEmpty();
    //向队列尾部添加元素
    void enqueue(E o);
    //从队首取出元素
    E dequeue();
    //获取队首的那个元素
    E getFront();

    /**
     * 1.从用户的角度看，支持这些操作就好
     * 2.具体底层实现 用户不关心
     * 3.实际底层有多种实现方式
     *
     * 利用动态数组来实现队列
     * */
}
