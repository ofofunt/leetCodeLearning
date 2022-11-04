package com.shuatmd.leetcodetraining.Easy;

public class GetKthNodeFromLast {
    //Solution1:循环2次 效率稍微低一点
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int depth = 0;
        ListNode cur = head;
        while(cur.next != null){
            depth ++;
            cur = cur.next;
        }
        for (int i = 0; i < depth - k; i++) {
            head = head.next;
        }
        return head;
    }
    //Solution1:双指针 cur链表先走k步 resultNode链表再从0开始走, 当cur链表被遍历完时，result链表指向的就是倒数第k位
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode resultNode = head;
        ListNode cur = head;
        int i = 0;
        while(i < k){
            cur = cur.next;
            i ++;
        }
        while(cur != null){
            cur = cur.next;
            resultNode = resultNode.next;
        }
        return resultNode;

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
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
        GetKthNodeFromLast getKthNodeFromLast = new GetKthNodeFromLast();
        getKthNodeFromLast.getKthFromEnd2(head, 1);

    }
}
