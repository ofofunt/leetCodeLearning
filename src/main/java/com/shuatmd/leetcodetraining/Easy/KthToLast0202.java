package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;

//面试题 02.02. 返回倒数第 k 个节点
//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//
//注意：本题相对原题稍作改动
//https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/
public class KthToLast0202 {
    //推荐解法： 双指针
    //2个指针 first second, 让first先走k步 之后first与second一起往前走
    //first指向链表尾部的时候 second指向的是链表的倒数第k位
    public int kthToLastAdvanced(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second.val;
    }
    //手搓解法： 栈 遍历完链表之后弹出栈顶元素
    public int kthToLast(ListNode head, int k) {
        ListNode tmp = head;
        Queue<Integer> queue = new ArrayDeque<>();
        while (tmp != null) {
            if (queue.size() >= k) {
                queue.poll();
            }
            queue.offer(tmp.val);
            tmp = tmp.next;
        }
        return queue.poll();
    }
}
