package com.licslan.week01.queue;

import com.licslan.week01.linkedlist.LinkedListQueue;

import java.util.Random;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class Main {

    /**
     * 线性数据结构 队列
     *
     * 相比数组，队列对应的操作是数组的子集
     *
     * 只能从一端（队尾）添加元素  队首 另一端取出元素
     *
     * 循环队列
     * front == tail 队列为空  tail+1=front 队列为满  --> (tail+1)%c==front 队列为满
     * */
    public static void main(String[] args) {

        //普通队列
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);


        //循环队列 解决了dequeue O(n) -->O(1)
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 20; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if(i%3==2){
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }


        System.out.println("===========================测试用例对比普通队列和循环队列在enqueue&&dequeue性能对比数据 START=====================================");

        int optCount=1000000;//100万
        ArrayQueue<Integer> arrayQueueTest = new ArrayQueue<>();
        double testArrayQueue = test(arrayQueueTest, optCount);
        System.out.println("ArrayQueue ,time :"+testArrayQueue+" s");

        LoopQueue<Integer> loopQueueTest = new LoopQueue<>();
        double testLoopQueue = test(loopQueueTest, optCount);
        System.out.println("LoopQueue  ,time :"+testLoopQueue+" s");

        LinkedListQueue<Integer> LinkedListQueueTest = new LinkedListQueue<>();
        double testLinkedListQueue = test(LinkedListQueueTest, optCount);
        System.out.println("LinkedListQueue  ,time :"+testLinkedListQueue+" s");

        System.out.println("===========================测试用例对比普通队列和循环队列在enqueue&&dequeue性能对比数据 END=====================================");

    }
    public static double test(Queue<Integer> queue,int optCount){
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < optCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount; i++) {
            queue.dequeue();//普通队列耗时O(n)
        }
        long end = System.nanoTime();
        return (end-start)/1000000000.0;
    }

    /**
     * 测试用例 100万  看到没有  所有学好算法数据结构是有多重要啦！！！  这2者的对比 发现性能对比差异巨大  数组队列 和 循环队列
     * ===========================测试用例对比普通队列和循环队列在enqueue&&dequeue性能对比数据 START=====================================
     * ArrayQueue ,time :365.6900371 s
     * LoopQueue  ,time :0.0556965 s
     * ===========================测试用例对比普通队列和循环队列在enqueue&&dequeue性能对比数据 END=======================================
     *
     *
     * **/
}
