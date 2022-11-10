package com.shuatmd.leetcodetraining.Easy;

public class ReverseListNode24 {
    //Solution 1: 双指针, cur是+1位的指针，pre是当前指针
    //通过对cur进行next操作 然后让tmp指向cur.next来进行位移，同时获取到下一位的值
    //然后通过cur.next = pre将值反向指回
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;

    }

    //Solution2：通过递归来做
    public ListNode reverseList2(ListNode head) {
        return recur(head, null);

    }

    //Solution2: 用递归来运算，每次递归其实都是返回的当前List中最后一位
    //拿到最后一位之后反向指回 完成倒序排列

    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode res = recur(cur.next, cur);
        cur.next = pre;
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseListNode24 reverseListNode = new ReverseListNode24();
        reverseListNode.reverseList2(head);

    }
}
