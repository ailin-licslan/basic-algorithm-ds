package com.licslan.week01.linkedlist;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class LinkedList<E> {
    //对外部用户屏蔽底层实现细节  内部类 私有  链表的成员变量（Node 类）  无虚拟头节点
    private class Node{
        //Node成员变量 设计为public 外部不需要getter/setter method
        public E e;
        //下一个节点
        public Node next;
        //构造函数
        public Node(E e,Node next){
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

    //链表的成员变量 head
    private Node head;
    //链表的成员变量 size
    private int size;
    //链表的构造函数
    public LinkedList(){
        //初始为空 size=0 一个元素也没有
        head=null;
        size=0;
    }
    //获取链表的元素个数
    public int getSize(){
        return size;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //在链表头添加元素
    public void addFirst(E e){
        //创建一个新的节点
        Node node =new Node(e);
        //让这个新建的节点指向这个链表的头部
        node.next=head;
        //并将这个节点作为整个链表的头部
        head=node;
        //维护一下size
        //上面三部 简写为 head = new Node(e,head);
        size++;
    }
    //在链表index位置添加元素 不常使用 练习使用 实际中会摒弃索引这个概念在链表操作中
    public void add(int index ,E e){
        if(index<0||index>0)throw new IllegalArgumentException("Add failed! Illegal index");
        if(index==0) addFirst(e);
        else {
            /**
             * 关键点：找到要添加的节点的前一个节点 此例是元素2
             * */
            //假设该（prev）节点是从head开始遍历
            Node prev = head;
            //index = 2
            //遍历 index的前一位数据index-1  假设 1-->2-->3-->4-->null   8插入到2,3之间  1-->2-->8-->3-->4-->null
            //index(value) :  [head]0(1) [1(2)] 2(3) 3(4)   ------>  [head]0(1) [1(2)] 2(8) 3(3) 4(4)  key point[index(value)]
            //why index -1 ?
            for (int i = 0; i < index - 1; i++)
                //将prev下一个节点放到当前的这个prev中 prev会一直像前移动 直到移动到index-1位置 也就是带插入节点的前一个节点
                //找到这个关键点 关键点：找到要添加的节点的前一个节点 此例是元素2
                prev = prev.next;
            //1的下一个节点2 i=0 此时循环遍历1次即可 找到关键点
            //2的下一个节点3 而此时2就是key point so we find key point bingo!!!

            //顺序非常重要 不可以颠倒  否则自己指向自己了
            Node node = new Node(e);
            node.next=prev.next;//8-->3(2的下一个节点3)
            prev.next=node;//2的下一个节点原本是3 现在指向8  2-->8
            // 上面三部 简写  prev.next=new Node(e,prev.next);
            size++;
        }
    }
    //在链表结尾添加元素
    public void addLast(E e){
        add(size,e);
    }
}
