package com.shuatmd.leetcodetraining.Hard;

import com.shuatmd.leetcodetraining.DTO.ListNode;

public class MergeKLists23 {
    //官方解法1：朴素解法
    //通过两两list循环合成 完成最后的list合成
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeTwoList(res, lists[i]);
        }
        return res;
    }

    private ListNode mergeTwoList(ListNode a, ListNode b) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        ListNode pointerA = a;
        ListNode pointerB = b;
        while(pointerA!=null && pointerB !=null){
            if(pointerA.val < pointerB.val){
                tmp.next = pointerA;
                tmp = tmp.next;
                pointerA = pointerA.next;
            }
            else{
                tmp.next = pointerB;
                tmp = tmp.next;
                pointerB = pointerB.next;
            }
        }
        tmp.next = pointerA!=null? pointerA:pointerB;
        return res.next;
    }
}
