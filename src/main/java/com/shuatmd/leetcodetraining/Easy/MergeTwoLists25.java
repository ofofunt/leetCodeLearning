package com.shuatmd.leetcodetraining.Easy;

public class MergeTwoLists25 {
    //Solution：双指针做法
    //头指针设置为dum，对l1+l2进行循环
    //如果l1大则将cur.next设置为l2，同时l2前进一步
    //合并结束后需要将未添加完的一部分添加到节点尾部
    //返回dum初始节点后一位的所有节点
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 !=null ? l1 : l2;
        return dum.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}
