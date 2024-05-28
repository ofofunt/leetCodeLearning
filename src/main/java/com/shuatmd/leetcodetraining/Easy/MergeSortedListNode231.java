package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.ListNode;
//23合并k个排序列表的前置题
//如何合并2个已经排序好的列表
//https://leetcode.cn/problems/merge-k-sorted-lists/solutions/219756/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
public class MergeSortedListNode231 {
    //官方解法: 用两个指针分表表示listNodeA 和 listNodeB下一步要插入的部分
    //当一个指针指向空 说明a或者b已经添加完 在resListNode最后添加剩余的next部分就可以
    public ListNode mergeKLists(ListNode listA, ListNode listB) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        ListNode pointerA = listA;
        ListNode pointerB = listB;
        while(pointerA!=null && pointerB!=null){
            //合并时保持顺序
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
        //合并完将没有遍历到的部分贴在tmp的尾部
        tmp.next = pointerA==null? pointerB:pointerA;
        return head.next;
    }
}
