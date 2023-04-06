package com.shuatmd.leetcodetraining.Easy;

import java.util.HashSet;
import java.util.Set;

//剑指 Offer 52. 两个链表的第一个公共节点
//输入两个链表，找出它们的第一个公共节点。
public class IntersectionNodeForTwoLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //解法1 双指针 A指针从a list开始遍历 遍历完之后遍历b list
    //B指针从b list开始遍历, 遍历完之后遍历list a
    //当AB指针指向同一节点或者null时 返回结果
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

    //解法2：通过HashSet来查重
    //不能只添加int,因为会忽略skip
    ListNode getIntersectionNodeWithHashSet(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        Set<ListNode> integerSet = new HashSet<>();
        while (A != null) {
            integerSet.add(A);
            A = A.next;
        }
        while (B != null) {
            if (integerSet.contains(B)) {
                return B;
            }
            B = B.next;
        }
        return null;
    }
}
