package com.shuatmd.leetcodetraining.Easy;

public class DeleteNode18 {
    //Solution1: 通过双指针的方法来删除链表中的元素
    //head.next = head.next.next 可以删除head.next这个元素
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        if(head.val == val){
            return head.next;
        }
        ListNode cur = head;
        while(cur.next!=null && cur.next.val != val){
            cur = cur.next;
        }
        if(cur.next != null){
            cur.next = cur.next.next;
        }
        return head;
    }


    public class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }
}
