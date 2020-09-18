package com.licslan.week01.linkedlist;

import com.licslan.week01.queue.Queue;

public class LinkedListQueue<E> implements Queue<E> {

    /**
     * 实现一个带有尾部指针tail的链表队列
     * */
    //对外部用户屏蔽底层实现细节  内部类 私有  链表的成员变量（Node 类）  无虚拟头节点
    private class Node{
        //Node成员变量 设计为public 外部不需要getter/setter method
        public E e;
        //下一个节点
        public Node next;
        //构造函数
        public Node(E e, Node next){
            this.e=e;
            this.next=next;
        }
        //构造函数
        public Node(E e){
            this(e,null);
        }
        //构造函数
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;
    public LinkedListQueue(){
        head=null;
        tail=null;
        size=0;
    }



    
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ;
    }

    @Override //入队 从链表尾部进行 O(1)
    public void enqueue(E o) {
        if(tail == null){
            tail=new Node(o);
            head=tail;
        }else {
            tail.next=new Node(o);
            tail=tail.next;
        }
        size++;
    }

    @Override //O(1)
    public E dequeue() {
        if(isEmpty())throw new IllegalArgumentException("cannot dequeue from an empty queue.");
        Node reNode = head;
        head=head.next;
        reNode.next = null;
        if(head == null) tail=null;
        size--;
        return reNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty())throw new IllegalArgumentException("it is an empty queue.");
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue Front ");//队首  出队
        Node cur = head;
        while (cur != null) {
            res.append(cur+"-->");
            cur = cur.next;
        }
        res.append("NULL Tail");//队尾  入队
        return res.toString();
    }
}
