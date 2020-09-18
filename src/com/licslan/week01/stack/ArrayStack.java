package com.licslan.week01.stack;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class ArrayStack<E> implements Stack<E> {
    //私有的成员变量
    private Array<E> array;
    //构造函数 有容量的
    public ArrayStack(int capacity){
        this.array=new Array(capacity);
    }
    //无参构造函数 没有容量的
    public ArrayStack(){
        this.array=new Array();
    }

    //获取栈的容量
    public int getCapacity(){
        return this.array.getCapacity();
    }

    /**
     * 利用动态数组实现栈的功能   下面的实现不用判断栈是否为空  因为底层的动态数组已经帮我们做好了操作
     * */

    @Override//获取栈的大小  O(1)
    public int getSize() {
        return this.array.getSize();
    }

    @Override//判断是否为空  O(1)
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override//向栈中添加元素 O(1) 均摊
    public void push(E o) {
        this.array.addLast(o);
    }

    @Override//从栈里取出元素 O(1) 均摊
    public E pop() {
        return this.array.removeLast();
    }

    @Override//栈顶的元素 O(1)
    public E peek() {
        return this.array.getFirst();
    }

    //覆盖父类的toString()
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Stack:  "));
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            //判断是不是数组最后一个元素
            if(i != array.getSize()  -1)
                res.append(",");
        }
        res.append("] Top"); //栈顶  用户不需要关注栈中的其他元素 只需要关注栈顶的元素
        return res.toString();
    }
}
