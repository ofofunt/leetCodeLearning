package com.shuatmd.leetcodetraining.Medium;
//剑指 Offer II 025. 链表中的两数相加
//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

//可以假设除了数字 0 之外，这两个数字都不会以零开头。
public class ListAdd025 {
    //官方建议解法1： 用栈来实现翻转链表
    public ListNode addTwoNumbersOfficial(ListNode l1, ListNode l2) {
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        //先把l1,l2放入栈之中,后续pop的时候就是倒序的
        while(l1 != null){
            queue1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            queue2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode tmp = null;
        while(!queue1.isEmpty() || !queue2.isEmpty() || carry > 0){
            int i1 = queue1.isEmpty()? 0: queue1.pop();
            int i2 = queue2.isEmpty()? 0: queue2.pop();
            int sum = i1 + i2 + carry;
            ListNode curnode = new ListNode(sum % 10);
            carry = sum / 10;
            curnode.next = tmp;
            tmp = curnode;
        }
        return tmp;

    }
    //手搓解法1： 先reverse两个list 然后相加 将结果再反转
    //缺点： 需要的空间略多,需要额外的ListNode来接受转换的结果 + 相加的结果
    //官方解法建议用栈来实现
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode s1 = reverseListNode(l1);
        ListNode s2 = reverseListNode(l2);
        ListNode resultList = new ListNode();
        ListNode tmp = resultList;
        int carry = 0;
        while (s1 != null || s2 != null || carry != 0) {
            ListNode next = new ListNode();
            int left = s1 == null ? 0 : s1.val;
            int right = s2 == null ? 0 : s2.val;
            next.val = (left + right + carry) % 10;
            if (left + right + carry>= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            tmp.next = next;
            tmp = tmp.next;
            if (s1 != null) {
                s1 = s1.next;
            }
            if (s2 != null) {
                s2 = s2.next;
            }
        }
        ListNode reversedResult = reverseListNode(resultList.next);
        return reversedResult;
    }

    private ListNode reverseListNode(ListNode l1) {
        ListNode curr = l1;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
