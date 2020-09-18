package com.licslan.datastructure.queue;

import com.licslan.datastructure.heap.MaxHeap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * 使用heap实现优先队列这种数据结构
 * */
public class PriorityQueue<E extends Comparable<E>> implements QueueQ<E> {

    //最大堆   但是jdk中PriorityQueue其实是最小堆结构
    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize(){
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront(){
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e){
        maxHeap.add(e);
    }

    @Override
    public E dequeue(){
        return maxHeap.extractMax();
    }

    //优先队列的经典问题


    //在100000000个元素中选出前100名？
    // 1.在N个元素中选出前M个元素  排序  Nlogn
    // 2.优先队列  维护当前看到的前M个元素需要使用最小堆 NlogM

    //Leetcode No347 前K个高频元素   给定数组[1,1,1,2,2,3,4,5,6] k=2 返回[1,2]



    //可比较的内部类
    private class Freq implements Comparable<Freq>{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            if(this.freq < another.freq)
                return 1;
            else if(this.freq > another.freq)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.getSize() < k)
                pq.enqueue(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.dequeue().e);
        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new PriorityQueue()).topKFrequent(nums, k));
    }













}
