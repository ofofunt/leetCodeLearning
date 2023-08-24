package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.LinkedList;
import java.util.List;

//面试题 02.06. 回文链表
//编写一个函数，检查输入的链表是否是回文的。
public class IsPalindromeLinkedList0206Star {
    //推荐解法1： O(n)时间 O(1)空间
    //将后半段链表翻转 之后与前半段相比
    public boolean isPalindromeReverse(ListNode head) {
        //首先判断空链表
        if(head == null) {
            return true;
        }
        //首先通过快慢指针找到链表重点
        //具体做法： 快指针走两步 慢指针走一步 快指针走到底的时候慢指针就指向中点
        ListNode fast = head;
        ListNode slow = head;
        //快指针走完全程的时候,慢指针刚好在链表的中间
        //慢指针所指的链表为后半段
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode LeftHalfEnd = slow;
        //翻转后半部分链表
        ListNode rightHalf = slow.next;
        ListNode prev = null;
        //翻转公式需要记住
        while(rightHalf != null){
            ListNode nextTmp = rightHalf.next;
            rightHalf.next = prev;
            prev = rightHalf;
            rightHalf = nextTmp;
        }
        Boolean isPalindrome = true;
        while(prev!=null && head != null){
            if(prev.val != head.val){
                isPalindrome = false;
            }
            prev = prev.next;
            head = head.next;
        }
        return isPalindrome;
    }

    //手搓解法1： 简单双O(n)解法
    //将链表转成list 之后双指针判断是否相等
    //记得用int.equals() 用==会存在地址不同的问题
    public boolean isPalindrome(ListNode head) {
        ListNode tmp = head;
        List<Integer> tmpList = new LinkedList<>();
        while (tmp != null) {
            tmpList.add(tmp.val);
            tmp = tmp.next;
        }
        int l = 0;
        int r = tmpList.size() - 1;
        while (l < r) {
            //int也注意要用equals 比对
            if (!tmpList.get(l).equals(tmpList.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindromeLinkedList0206Star isPalindromeLinkedList0206Star = new IsPalindromeLinkedList0206Star();
    }
}
