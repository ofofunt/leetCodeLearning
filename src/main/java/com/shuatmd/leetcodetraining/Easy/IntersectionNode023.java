package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.HashSet;
import java.util.Set;

//剑指 Offer II 023. 两个链表的第一个重合节点
//给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
public class IntersectionNode023 {
    //双指针解法改进版：简化写法
    public ListNode getIntersectionNodeAdvanced(ListNode headA, ListNode headB) {
        if(headA == null || headB ==null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA!=pB){
            pA = pA == null? headB: pA.next;
            pB = pB == null? headA: pB.next;
        }
        return pA;
    }

    //双指针解法： 两个指针指向headA以及headB的头结点
    //当指针当前node不为空时,前进一位,当指针指向空时 移向对方node的头结点
    //当两个指针指向同一个node时候,说明当前节点是交互点
    //如果两个指针都指向空,说明不存在交互点 返回null
    public ListNode getIntersectionNodeDoublePointer(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        if(headA == null || headB == null){
            return null;
        }
        while(pointerA != pointerB){
            if(pointerA != null){
                pointerA = pointerA.next;
            }
            else{
                pointerA = headB;
            }
            if(pointerB != null){
                pointerB = pointerB.next;
            }
            else{
                pointerB = headA;
            }
            if(pointerA == null && pointerB == null){
                return null;
            }
        }
        return pointerA;
    }
    //手搓解法： 遍历headA的时候将每个节点放入Hashset
    //全部放入之后遍历headB,判断HashSet中是否存在与当前node相同的节点
    //如果有则直接返回当前节点,如果遍历完不存在则返回null
    //不足：需要额外空间 时间为m + n
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listNodeSet = new HashSet<>();
        ListNode tmp = headA;
        while(tmp != null){
            listNodeSet.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while(tmp != null){
            if(listNodeSet.contains(tmp)){
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
