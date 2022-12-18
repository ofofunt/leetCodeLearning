package com.example.leetCodeLearning.src.main.java.com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.LinkedList;

public class ReversePrint {
    static ArrayList<Integer> temp = new ArrayList<Integer>();

    //    Soltuin 1: 通过递归 逆序将整个链表中的内容放入一个容器中（比如arrayList） 然后将容器转为array
    public static int[] reversePrint(ListNode head) {
        recur(head);
        System.out.println(temp);
        int[] resultArray = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            resultArray[i] = temp.get(i);
        }
        return resultArray;
    }

    static void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        temp.add(head.val);
    }

    //    Solution2 栈辅助
    //    模拟栈 利用LInkedList的addLast以及removeLast来做一个reverse的操作，将先放入的元素优先取出
    public static int[] reversePrint2(ListNode head) {
        LinkedList<Integer> resultList = new LinkedList<Integer>();
        while (head != null) {
            resultList.addLast(head.val);
            head = head.next;
        }
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = resultList.removeLast();
        }
        return resultArray;
    }

    //Solution3 先通过while拿到整个链表的长度，然后自右向左反向进行一个遍历
    public static int[] reversePrint3(ListNode head) {
        int headCount = 0;
        ListNode temp = head;
        while (temp != null) {
            headCount ++;
            temp = temp.next;
        }
        int[] resultArray = new int[headCount];
        while (head != null) {
            resultArray[headCount-1] = head.val;
            head = head.next;
            headCount--;
        }
        return resultArray;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode resultList = new ListNode(1);
        resultList.next = new ListNode(2);
        resultList.next.next = new ListNode(3);
        reversePrint3(resultList);
        System.out.println(resultList);
    }
}
