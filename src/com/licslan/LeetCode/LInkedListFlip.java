package com.licslan.LeetCode;
/**
 * LeetCode 专栏  ♥  NO206
 *
 * @author LICSLAN
 * */
public class LInkedListFlip {

    /**
     * 非递归实现
     * */
    public ListNode reverseList(ListNode head){
        /**
         * 链表翻转
         * */
        //当前指针的前一个元素
        ListNode prev = null;
        //当前的元素
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            //当前节点的下一个节点本来是指向next的 结果现在就指向了当前节点的前一个节点 这里就实现了翻转
            // prev --> cur.next --> next   to  cur.next-->prev 此时cur节点的翻转就完成了
            cur.next = prev;
            //prev在下次循环中就已经指向了此时的cur  不断向👉移动
            prev = cur;
            //cur在下次循环中就已经指向了此时的next(cur.next)  不断向👉移动
            cur = next;
        }
        //此时链表的头节点就是之前的最后一个节点了  而此时的prev就会是最后一个节点 当cur为空时 so return prev
        return prev;
    }

    //(head)1-->2-->5-->6-->7-->NULL
    //prev--cur---next-------------------------
    //7-->6-->5-->2-->1-->NULL
    //NULL<--1<--2<--5<--6<--7(head)
    //pre cur next 不断向👉移动 直到cur为空就可以了

    /**
     * 递归方式
     * */
    public ListNode reverseList2(ListNode head){
        if (head == null||head.next == null)return head;
        ListNode rev = reverseList2(head.next);
        head.next.next=head;
        head.next=null;
        return rev;
    }


}


