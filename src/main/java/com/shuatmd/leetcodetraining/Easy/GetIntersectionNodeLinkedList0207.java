package com.shuatmd.leetcodetraining.Easy;
//面试题 02.07. 链表相交
//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

import com.shuatmd.leetcodetraining.DTO.ListNode;

public class GetIntersectionNodeLinkedList0207 {
    //官方解法： 简略轮询的过程
    public ListNode getIntersectionNodeOfficial(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while(pointerA != pointerB){
            //看上去会死循环其实不会
            // 因为headA headB假设不相交的情况下,pointerA和pointerB会同时轮询完headA以及headB
            //最后终止 pointerA = pointerB = null
            pointerA = pointerA != null? pointerA.next : headB;
            pointerB = pointerB != null? pointerB.next : headA;
        }
        return pointerA;
    }
    //手搓解法: 假设存在相交的的点 相交的节点为 b
    //则存在 headA = a -> i headB = b -> i
    //用双指针轮询headA headB 当A指针轮询完headA的时候再去循环headB
    //headA + headB = a->i->b->i = headB + headA = b->i->a->i
    //aib和bia的长度相同 所以如果存在一个相等的点 则说明存在相交的点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int i = 0,j = 0;
        while(pointerA != null || pointerB != null){
            if(pointerA == pointerB){
                return pointerA;
            }
            pointerA = pointerA.next;
            pointerB = pointerB.next;
            //当pointerA pointerB第一次遍历完时,指向对方链表的头部
            if(pointerA == null && i == 0){
                pointerA = headB;
                i++;
            }
            if(pointerB == null && j == 0){
                pointerB = headA;
                j++;
            }


        }
        return null;
    }
}
