package com.licslan.LeetCode;
/**
 * LeetCode 专栏  ♥  NO203
 *
 * @author LICSLAN
 * */
public class DelAllValues {

    /**
     * 删除链表中等于给定值 val 的所有节点。
     *
     * 示例:
     *
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * */

    public ListNode removeAllElements(ListNode head,int value){
        //删除头节点
        while(head != null && head.val==value) {
            ListNode delNode = head;
            head=head.next;
            delNode.next=null;
        }

        //所有都删完了 链表为空了
        if(head==null) return null;

        //删除链表中间等于value的元素
        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == value) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            //不被删除就往后面移动
            else prev = prev.next;
        }

        return head;
    }


    /**
     * 删除链表中某一个值的元素  利用链表天然递归特性来删除
     * */

    public ListNode removeElements(ListNode head,int val){
        if (head == null) {
            return null;
        }
        ListNode listNode = removeElements(head.next, val);
        if(head.val==val)
            return listNode;
        else {
            head.next = listNode;
            return head;
        }
    }

    public ListNode removeElements2(ListNode head,int val){
        if (head == null) {
            return null;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val?head.next:head;
    }





    public ListNode removeAllElementsWithDummyHead(ListNode head,int value){
         ListNode dummyHead = new ListNode(0);
         dummyHead.next = head;
//        //删除头节点
//        while(head != null && head.val==value) {
//            ListNode delNode = head;
//            head=head.next;
//            delNode.next=null;
//        }
//
//        //所有都删完了 链表为空了
//        if(head==null) return null;

        //删除链表中间等于value的元素
        ListNode prev = dummyHead;
        //ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == value) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            //不被删除就往后面移动
            else prev = prev.next;
        }

        return dummyHead.next;
    }



}



 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

     /**
      * 链表节点构造函数  当前的listNode为链表的头节点
      * */
     public ListNode(int[] arr){
         if(arr == null||arr.length == 0) throw new IllegalArgumentException("arr can not be empty!");
         this.val = arr[0];
         ListNode cur = this;
         //将数组转成链表
         for (int i = 1; i < arr.length; i++) {
             cur.next= new ListNode(arr[i]);
             cur=cur.next;
         }
     }
     @Override
     public String toString() {
         //以当前节点为头节点的链表信息字符串
         StringBuilder res = new StringBuilder();
         ListNode cur = this;
         while (cur!=null){
             res.append(cur.val+"-->");
             cur = cur.next;
         }
         res.append(" NULL");
         return res.toString();
     }


     public static void main(String[] args) {
         int[] numb = {
                 1,2,3,4,6,78,3
         };
         ListNode arrToLinkedList = new ListNode(numb);
         System.out.println(arrToLinkedList);

         System.out.println(new DelAllValues().removeAllElements(arrToLinkedList,78));


     }

     /**
      * 递归调用是有代价的 函数调用+系统栈空间
      * 比如求和的数组有10万 100万 元素 那么系统的栈空间是不够用的
      * 删除链表的元素 如果有10万 100万个节点的话  那么系统的栈空间也是不够用的
      * */
 }
