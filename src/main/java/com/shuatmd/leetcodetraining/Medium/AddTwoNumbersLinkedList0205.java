package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

//面试题 02.05. 链表求和
//给定两个用链表表示的整数，每个节点包含一个数位。
//
//这些数位是反向存放的，也就是个位排在链表首部。
//
//编写函数对这两个整数求和，并用链表形式返回结果。
//
// https://leetcode.cn/problems/sum-lists-lcci/
public class AddTwoNumbersLinkedList0205 {
    //推荐解法： 差不多 但是while的时候对进位进行了判断
    //处理进位更加丝滑
    public ListNode addTwoNumbersAdvanced(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1), temp = ans;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(t % 10);
            temp = temp.next;
            t /= 10;
        }
        return ans.next;
    }


    //手搓解法： 轮询2个ListNode 记录2个node当前数值相加的和
    //同时记录进位信息
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode resNode = new ListNode(0);
        ListNode tempRes = resNode;
        int carry = 0;
        //对于temp1 temp2进行遍历,终止条件2个ListNode都为空 代表遍历结束
        while (temp1 != null || temp2 != null) {
            int num1 = 0;
            int num2 = 0;
            if (temp1 != null) {
                num1 = temp1.val;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                num2 = temp2.val;
                temp2 = temp2.next;
            }
            //计算当前节点相加的和
            int sum = num1 + num2;
            //返回的时候需要考虑 sum是否已经大于10 同时需要考虑sum + carry是否已经大于10
            tempRes.next = new ListNode((sum % 10 + carry) % 10);
            //计算进位的时候需要考虑当前sum + 进位的值
            carry = (sum + carry) / 10;
            tempRes = tempRes.next;
        }
        //如果最后的carry大于0 则还需要往前进一位
        if (carry > 0) {
            tempRes.next = new ListNode(1);
        }
        return resNode.next;
    }
}
