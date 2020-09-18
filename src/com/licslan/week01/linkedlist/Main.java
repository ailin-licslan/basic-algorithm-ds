package com.licslan.week01.linkedlist;

import com.licslan.week01.stack.ArrayStack;
import com.licslan.week01.stack.Stack;

import java.util.Random;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class Main {
    /**
     * 数据存储在节点"Node"中
     * class Node{
     *     E e;
     *     Node next;
     * }
     *
     * 优点: 真正的动态 不需要处理固定容量的问题
     * 缺点: 丧失了随机访问数据的能力  数组可以 开辟内存地址连续 连续节点
     *
     * 思考？？？
     * 什么时候适合使用像数组这种的静态数据结构 (索引有语意的情况)  动态数组/栈/队列 三者底层都是依托静态数组  考resize解决固定容量问题
     * 什么时候适合使用像链表这种的动态数据结构 （链表不适合用于索引有语意的情况）
     * 1.真正的动态数据结构（最简单的动态数据结构）
     * 2.更加深入的理解指针（理解引用）
     * 3.更深入的理解递归
     * 4.辅助组成其他数据结构
     * */
    public static void main(String[] args) {

        /**
         * 向链表其他地方添加元素  我们关键点要找到添加位置的前一个节点
         * 而为链表头添加位置有点特殊  链表头前面没有元素  这个时候我们可以人为添加一个虚拟节点作为链表头
         * dummyHead（虚拟头节点） dummyHead  的next node   用户不用知道这个思路
         * **/

        LinkedListDummyHead<Integer> linkedListDummyHead = new LinkedListDummyHead<>();
        for (int i = 0; i < 5;i++)
            linkedListDummyHead.addFirst(i);
        System.out.println(linkedListDummyHead);
        linkedListDummyHead.add(2,88888);
        System.out.println(linkedListDummyHead);
        linkedListDummyHead.remove(2);
        System.out.println(linkedListDummyHead);
        linkedListDummyHead.removeFirst();
        System.out.println(linkedListDummyHead);
        linkedListDummyHead.removeLast();
        System.out.println(linkedListDummyHead);
        /**
         * 测试用例结果
         * 4-->3-->2-->1-->0-->NULL
         * 4-->3-->88888-->2-->1-->0-->NULL
         * 4-->3-->2-->1-->0-->NULL
         * 3-->2-->1-->0-->NULL
         * 3-->2-->1-->NULL
         * */

        System.out.println("====================使用链表实现栈=====================");
        /**
         * 使用链表实现栈
         * */
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for (int i = 0; i < 5;i++)
            linkedListStack.push(i);
        System.out.println(linkedListStack);
        linkedListStack.push(88888);
        System.out.println(linkedListStack);
        linkedListStack.peek();
        System.out.println(linkedListStack);
        linkedListStack.pop();
        System.out.println(linkedListStack);
        /**
         * 测试用例结果
         * Stack: top 4-->3-->2-->1-->0-->NULL
         * Stack: top 88888-->4-->3-->2-->1-->0-->NULL
         * Stack: top 88888-->4-->3-->2-->1-->0-->NULL
         * Stack: top 4-->3-->2-->1-->0-->NULL
         * */

        System.out.println("===========================测试用例 数组栈 链表栈性能对比============================");

        int optCount = 100000;
        ArrayStack<Integer> array_Stack = new ArrayStack<>();
        double time1 = test(array_Stack,optCount);
        LinkedListStack<Integer> linkedList_Stack = new LinkedListStack<>();
        double time2 = test(linkedList_Stack, optCount);

        System.out.println("数组栈耗时ArrayStack time："+time1+" s");
        System.out.println("链表栈耗时LinkedListStack time："+time2+" s");

        /**
         *
         * 测试用例结果
         * when  int optCount = 10000000;
         * 数组栈耗时ArrayStack time：1.2214969 s
         * 链表栈耗时LinkedListStack time：8.2668079 s
         *
         * when  int optCount = 100000;
         * 数组栈耗时ArrayStack time：0.0172562 s
         * 链表栈耗时LinkedListStack time：0.0091189 s
         *
         * 从两者性能比较  二者算法复杂度是没有差异的
         * */

        System.out.println("===============================LinkedListQueue测试==================================");
        //普通队列
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);




    }
    public static double test(Stack<Integer> stack, int optCount){
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < optCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount; i++) {
            stack.pop();//栈耗时O(n)
        }
        long end = System.nanoTime();
        return (end-start)/1000000000.0;
    }

    /**
     *
     * 链表性能问题总结
     *
     * 虽然猛地看上去，如果我们只在链表头添加元素，时间复杂度是 O(1) 的。同时，因为使用链表不需要 ressize，所以，凭直觉，链表的性能应该更好。
     * 但实际上，当数据量达到一定程度，链表的性能是更差的。
     * 这是因为，对于链表来说，每添加一个元素，都需要重新创建一个 Node 类的对象，也就是都需要进行一次 new 的内存操作。而对内存的操作，是非常慢的。
     * 同学们可以尝试一下，对于我们这个课程中所实现 Array 类和 LinkedList 类，进行如下的测试：
     * 计时，看将 1000 万个元素放入链表中，时间是多少
     * 可以看出来，使用链表明显慢于使用动态数组。
     * 为什么即使有 resize，对于大规模数据，动态数组还是会快于链表？
     * 因为对于动态数组来说，一方面，每次 resize 容量增倍，这将使得，对于大规模数据，实际上触发 resize 的次数是非常少的。
     * 更重要的是，resize 的过程，试一次申请一大片内存空间。但是对于链表来说，每次只是申请一个空间。
     * 申请一次 10 万的空间，是远远快于申请 10 万次 1 的空间的。而相较于堆内存空间的操作，动态数组的 resize 过程虽然还需要赋值，
     * 把旧数组的元素拷贝给新数组。但是这个拷贝过程，是远远快于对内存的操作的。
     * */
}
