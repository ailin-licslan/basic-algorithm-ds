package com.licslan.week01.queue;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class LoopQueue<E> implements Queue<E> {
    /**
     * 循环队列  解决 普通队列（ArrayQueue） dequeue() O(n) --> 优化为O(1) 均摊
     * 有size但浪费一个空间的写法循环队列
     * */
    //泛型数组
    private E[] data;
    //队列首尾
    private int front,tail;
    //队列实际大小
    private int size;
    //有参构造函数
    public LoopQueue(int capacity){
        //有意在这里浪费一个空间来实现循环队列（界定队列是否满了 (tail+1)%c==front 队列为满）
        data=(E[]) new Object[capacity+1];
        front=0;tail=0;size=0;
    }
    //无参构造函数
    public LoopQueue(){
        this(10);
    }
    //数组的容量
    public int getCapacity(){
        //我们会有意识的浪费一个空间 让其空着
        return data.length-1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail==front;
    }

    @Override//入队
    public void enqueue(E o) {
        //首先判断一下队列是不是满的
        if((tail+1)%data.length == front){
            //如果入队的时候发现数组是满的 这个时候就需要进行扩容了 扩容为当前循环队列可容纳的大小的2倍
            resize(getCapacity()*2);
        }
        //不管有没有扩容
        data[tail]=o;//添加的元素放在队尾
        tail=(tail+1)%data.length; //循环队列
        size++;//维护一下size
    }

    /**
     * 扩缩容
     * */
    private void resize(int newCapacity) {
        //新数组
        E[] newData = (E[]) new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
            //循环队列中以前的元素放入到新的数组中  (i+front)%data.length  如果这样的话  放到新数组不会越界
            newData[i]=data[(i+front)%data.length];
        }
        data=newData;//此时data的大小变成了新数组newData的大小 也就是扩容了
        front=0; //此时没有入栈和出栈
        tail=size; //此时没有入栈和出栈
    }

    @Override//出队
    public E dequeue() {
        if(isEmpty()) throw new IllegalArgumentException("cannot dequeue from an empty queue");
        E ret = data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        //缩容  lazy 解决复杂度震荡
        if(size==getCapacity()/4&&getCapacity()/2!=0) resize(getCapacity()/2);
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())throw new IllegalArgumentException("Queue is Empty!");
        return data[front];
    }

    //覆盖父类的toString()
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("Front [");
        //toString && resize 中遍历方式可以互换  可以多理解理解！！！
        for (int i = front; i != tail; i=(i+1)%data.length) {
            res.append(data[i]);
            if((i+1)%data.length!=tail)
                res.append(",");
        }
        res.append("] Tail");
        return res.toString();
    }


}
