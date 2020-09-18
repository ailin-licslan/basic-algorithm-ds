package com.licslan.week01.queue;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class ArrayQueue<E> implements Queue<E> {
    //私有的成员变量
    private Array<E> array;
    //构造函数 有容量的
    public ArrayQueue(int capacity){
        this.array=new Array(capacity);
    }
    //无参构造函数 没有容量的
    public ArrayQueue(){
        this.array=new Array();
    }
    //获取队列的容量
    public int getCapacity(){
        return this.array.getCapacity();
    }
    @Override//O(1)
    public int getSize() {
        return this.array.getSize();
    }

    @Override//O(1)
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override//O(1)
    public void enqueue(E o) {
        this.array.addLast(o);
    }

    @Override//O(N)  如果100万条数据  是不是要挪动100万次呢？ 循环队列解决 均摊 O(1)
    public E dequeue() {
        return this.array.removeFirst();
    }

    @Override//O(1)
    public E getFront() {
        return this.array.getFirst();
    }

    //覆盖父类的toString()
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue:  "));
        res.append("Front [");//队首
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            //判断是不是数组最后一个元素
            if(i != array.getSize()  -1)
                res.append(",");
        }
        res.append("] Tail"); //队列尾部  用户不需要关注栈中的其他元素 只需要关注栈顶的元素
        return res.toString();
    }
}
