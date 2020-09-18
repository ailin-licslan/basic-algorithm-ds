package com.licslan.week01.linkedlist;

import com.licslan.week01.stack.Stack;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class LinkedListStack<E> implements Stack<E> {

    /**实现一个链表栈*/

    //有一个linkedList私有成员变量 (类对象)
    private LinkedListDummyHead<E> linkedListDummyHead;
    //构造函数
    public LinkedListStack(){
        this.linkedListDummyHead= new LinkedListDummyHead<>();
    }

    @Override
    public int getSize() {
        return linkedListDummyHead.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedListDummyHead.isEmpty();
    }

    @Override //栈顶入栈
    public void push(E o) {
        linkedListDummyHead.addFirst(o);
    }

    @Override
    public E pop() {
        return linkedListDummyHead.removeFirst();
    }

    @Override
    public E peek() {
        return linkedListDummyHead.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(linkedListDummyHead);
        return res.toString();
    }
}
