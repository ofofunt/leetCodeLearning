package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.Stack;

// 剑指 Offer II 024. 反转链表
// 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
public class ReverseListNode024 {
    //双指针 + 迭代做法
    public ListNode reverseListOfficial(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //记录下下一个节点
            ListNode next = curr.next;
            //将当前节点与之前的节点连在一起,并且赋值给prev
            curr.next = prev;
            prev = curr;
            //curr前进到下一个节点
            curr = next;
        }
        return prev;
    }

    //双指针手搓解法：速度不行 而且一直在new太麻烦了
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<ListNode> nodeStack = new Stack<>();
        while (head != null) {
            nodeStack.push(head);
            head = head.next;
        }
        ListNode pre = new ListNode();
        ListNode cur = pre;
        while (!nodeStack.isEmpty()) {
            cur.next = nodeStack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return pre.next;
    }
}
