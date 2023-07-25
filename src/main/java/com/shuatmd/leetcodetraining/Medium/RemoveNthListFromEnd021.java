package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

public class RemoveNthListFromEnd021 {
    //朴素解法1： 添加一个dummy节点 因为第一位的节点没有前序节点,如果需要remove第一位需要进行额外的判断
    //首先通过遍历获取到整个链表的长度
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    private static int getLength(ListNode head) {
        int length = 0;
        ListNode tmp = head;
        while (tmp!= null){
            length++;
            tmp = tmp.next;
        }
        return length;
    }
}
