package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.HashSet;
import java.util.Set;

//面试题 02.01. 移除重复节点
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//https://leetcode.cn/problems/remove-duplicate-node-lcci/
public class RemoveDuplicateNodes0201 {
    //官方解法1： 用set但是原地删除
    public ListNode removeDuplicateNodesAdvanced(ListNode head) {
        if(head == null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        set.add(head.val);
        //从第二位开始判断
        while(temp.next!=null){
            ListNode cur = temp.next;
            if(set.add(cur.val)){
                temp = temp.next;
            }
            else{
                temp.next = temp.next.next;
            }
        }
        return head;
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        //手搓解法1： 用set能否add来判断可否重复
        //缺点： 不是原地删除,需要new几个新的ListNode
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        ListNode resultList = new ListNode(0);
        ListNode res = resultList;
        while(temp != null){
            if(set.add(temp.val)){
                res.next = new ListNode(temp.val);
                res = res.next;
            }
            temp = temp.next;
        }
        return resultList.next;
    }
}
