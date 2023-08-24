package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;
import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.*;

//面试题 04.03. 特定深度节点链表
//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
//https://leetcode.cn/problems/list-of-depth-lcci/
public class ListOfDepth0403 {
    //官方解法： 不需要记录level, 遍历完一层之后再去下一层
    //需要记住bfs的时候怎么分层去记录
    public ListNode[] listOfDepthAttemp2(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        List<ListNode> resList = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        while (!queue.isEmpty()) {
            ListNode curr = dummy;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode root = queue.poll();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
                curr.next = new ListNode(root.val);
                curr = curr.next;
            }
            resList.add(dummy.next);
            dummy = new ListNode(0);
        }

        return resList.toArray(new ListNode[resList.size()]);
    }

    //手搓解法：BFS的时候记录当前level的子节点
    //用queue或者map都可以记录当前的level 但是用map无法避免相同值不同level的问题
    //可以修改的地方,应该在遍历的同时构建链表 而不是最后再构建
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        Queue<Integer> levelQueue = new LinkedList<>();
        List<ListNode> resList = new ArrayList<>();
        levelQueue.offer(1);
        Map<Integer, List<Integer>> storeMap = new LinkedHashMap<>();
        while (!queue.isEmpty()) {
            TreeNode root = queue.poll();
            Integer level = levelQueue.poll();
            if (storeMap.get(level) == null) {
                storeMap.put(level, new ArrayList<>());
            }
            storeMap.get(level).add(root.val);
            if (root.left != null) {
                queue.add(root.left);
                levelQueue.offer(level + 1);

            }
            if (root.right != null) {
                queue.add(root.right);
                levelQueue.offer(level + 1);
            }
        }
        for (List<Integer> value : storeMap.values()) {
            ListNode cur = new ListNode(0);
            ListNode tmp = cur;
            for (Integer val : value) {
                tmp.next = new ListNode(val);
                tmp = tmp.next;
            }
            resList.add(cur.next);
        }
        return resList.toArray(new ListNode[resList.size()]);
    }

    public static void main(String[] args) {
        ListOfDepth0403 list = new ListOfDepth0403();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.left.left.left = new TreeNode(8);
        tree.right.left = new TreeNode(7);
        list.listOfDepth(tree);
    }
}
