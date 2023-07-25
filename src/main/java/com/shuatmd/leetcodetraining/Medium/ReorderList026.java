package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//剑指 Offer II 026. 重排链表
//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
// L0 → L1 → … → Ln-1 → Ln
//请将其重新排列后变为：
//L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
//不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
public class ReorderList026 {
    //高端解法: 首先找到list的中点
    //其次 将右半链表翻转
    //将左右两端合并
    public void reorderListOfficial(ListNode head) {
        //首先通过快慢指针寻找到链表的中点
        ListNode slow = head;
        ListNode fast = head;
        while(slow.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //循环完之后slow指向的是当前链表的中点
        //反转右半边列表
        ListNode rightPart = slow.next;
        ListNode leftPart = head;
        slow.next = null;
        ListNode curr = rightPart;
        ListNode prev = null;
        while(curr != null){
            ListNode next= curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        rightPart = prev;
        //翻转完右半边之后 合并2个链表
        ListNode leftTemp;
        ListNode rightTmp;
        while(leftPart!=null && rightPart!=null){
            leftTemp = leftPart.next;
            rightTmp = rightPart.next;
            leftPart.next = rightPart;
            leftPart = leftTemp;
            rightPart.next = leftPart;
            rightPart = rightTmp;
        }
    }

    //使用线性表: 通过角标记录来实现
    //将链表放到list中
    //list第0位的next指向最后一位
    //list最后一位的next指向第2位
    //以此循环直到i == j
    public void reorderListUsingVector(ListNode head) {
        ListNode tmp = head;
        List<ListNode> list = new LinkedList<>();
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    public ListNode reorderList(ListNode head) {
        ListNode tmp = head;
        Deque<ListNode> queue = new ArrayDeque<>();
        int length = 0;
        while (tmp != null) {
            queue.push(tmp);
            tmp = tmp.next;
            length++;
        }
        ListNode result = head;
        for (int i = 0; i < length / 2; i++) {
            ListNode next = result.next;
            ListNode curr = queue.pop();
            result.next = curr;
            result.next.next = next;
            result = result.next.next;
        }
        result.next = null;
        return head;
    }
}
