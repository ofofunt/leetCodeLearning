package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

public class OddEvenList328 {
    //手搓解法 分两个循环做
    //第一次循环首先将奇数位的数字加入ListNode res 同时将偶数位的数记录在copy中
    //之后对copy进行遍历 放入偶数位的数字
    //运行起来没问题但是写法有点复杂
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tmp = new ListNode(0);
        ListNode copy = new ListNode(0);
        //创建对应的dummy listNode
        ListNode res = tmp;
        ListNode secondHalf = copy;
        while (head != null) {
            tmp.next = head;
            tmp = tmp.next;
            head = head.next;
            copy.next = head;
            copy = copy.next;
            if (head != null) {
                head = head.next;
            }
        }
        tmp.next = secondHalf.next;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        OddEvenList328 list328 = new OddEvenList328();
        list328.oddEvenList(listNode);

    }
}
