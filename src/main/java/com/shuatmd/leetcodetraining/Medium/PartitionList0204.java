package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

public class PartitionList0204 {
    //手搓解法1： new两个新的链表
    //一个shorts记录小于k的节点,一个larges记录大于等于k的节点
    //轮询到head末尾的时候 将larges的所有node拼接到shorts后面
    public ListNode partition(ListNode head, int x) {
        ListNode shorts = new ListNode(0);
        ListNode larges = new ListNode(0);
        ListNode shorterList = shorts;
        ListNode largerList = larges;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                shorterList.next = new ListNode(temp.val);
                shorterList = shorterList.next;
            } else {
                largerList.next = new ListNode(temp.val);
                largerList = largerList.next;
            }
            if (temp.next == null) {
                shorts.next = larges.next;
            }
            temp = temp.next;
        }
        return shorts.next;
    }
}
