package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.HashSet;
import java.util.Set;

//面试题 02.08. 环路检测
//给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
//
//如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//https://leetcode.cn/problems/linked-list-cycle-lcci/description/
public class DetectCycleLinkedList0208 {
    //官方推荐解法1： 快慢指针 + 数学解法
    //优点： 不需要额外开辟空间 空间复杂度O(1)
    public ListNode detectCycleMath(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        //快指针一次走两步 慢指针一次走一步 如果存在环,则两者必定相交
        while (fast != null && slow !=null){
            //如果fast与slow相等,则说明相交
            //如果存在null则说明不存在环
            if(fast.next != null && fast.next.next!=null) {
                fast = fast.next.next;
            }
            else{
                return null;
            }
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        //复杂的数学推导：
        //假设链表起点为a 环入口为b 相遇的点为c 环的长度为n
        //设ab之间距离为m bc之间距离为y
        //快慢指针相遇时 慢指针走的路程为 x + y
        //快指针走过的路程为 x + mn + y
        //因为快指针是2倍速 所以存在 （x + y） * 2 = x + mn + y
        //推导可知 m = xn -y = n - y + (x - 1) * n
        //根据上述等式可知 快慢指针在c点相遇之后 慢指针再走m步会回到环入口
        //因为走m步 = 走 n - y + (x -1 )* n 步 其中 （x -1）*n 为转圈的部分， n - y部分刚好够慢指针走回原点
        //此时快指针从头指针开始走,走m步刚好从a到b 到达换入口
        //所以再相遇后将head重新指向head 以相同速率和slow同时走,两者再次相同时代表走到环的入口
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //手搓解法1： HashMap找重复
    //如果set中无法添加则代表已经遍历过
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode tmp = head;
        while (tmp != null) {
            if (!set.add(tmp)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
