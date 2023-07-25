package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.ListNode;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-05-31 16:06
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 027. 回文链表
//给定一个链表的 头节点 head ，请判断其是否为回文链表。
//如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
public class IsPalindromeList027 {
    //官方解法1： 通过快慢指针找到中间值
    //从中间值处断开链表 分为左右两部分,将右链表翻转 之后与左边相比
    //手搓解法1： 把链表的值按照顺序放入list中
    //用双指针判断list前后是否相等
    public boolean isPalindromeOfficial(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        ListNode left = head;
        slow.next = null;
        ListNode curr = right;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        right = prev;
        while(right!=null && head != null){
            if(right.val != head.val){
                return false;
            }
            right = right.next;
            head = head.next;
        }
        return true;
    }
    //缺点：空间消耗大,需要new一个新的list
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = list.size()-1;
        while(i < j){
            if(!list.get(i).equals(list.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
