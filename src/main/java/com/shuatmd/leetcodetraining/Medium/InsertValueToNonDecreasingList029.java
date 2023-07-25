package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.Node;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-01 16:27
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 029. 排序的循环链表
//给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。

//给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。

//如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。

//如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点
public class InsertValueToNonDecreasingList029 {
    //官方解法1：
    public Node insert(Node head, int insertVal) {
        //首先创建一个value为insertVal的node
        //同时将尾部指向自己形成循环
        Node x = new Node(insertVal);
        x.next = x;
        if (head == null) {
            return x;
        }
        //因为是循环Node，无法和ListNode一样用 while(tmp != null)进行遍历
        Node tmp = head;
        int min = tmp.val;
        int max = tmp.val;
        //如果head.next = tmp说明回到了原点
        while (head.next != tmp) {
            head = head.next;
            min = Math.min(head.val, min);
            max = Math.max(head.val, max);
        }
        //如果min与max相等 说明整个Node中的所有数都是一样的 insertVal随便插在哪里都可以
        if(min == max){
            x.next = tmp.next;
            tmp.next = x;
        }
        //如果min与max不等 则需要再次遍历,当x大于max 或者x小于min时插入当前位置
        else{
            //通过循环找到跳跃点,此时
            while(!(head.val == max && head.next.val ==min)){
                head = head.next;
            }
            //判断此时如果insertVal符合条件 可以直接插入
            if(insertVal>= max || insertVal<= min){
                x.next = head.next;
                head.next = x;
            }
            //如果不符合，则需要从最小值开始一直寻找,直到找到合适的位置,插入insertVal
            else{
                while(!(head.val <= insertVal && head.next.val >= insertVal)){
                    head = head.next;
                }
                x.next = head.next;
                head.next = x;
            }
        }
        return tmp;
    }
}
