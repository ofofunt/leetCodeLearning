package com.example.leetCodeLearning.src.main.java.com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
public class levelOrder32 {
    //解法1： 通过双端队列来实现，从res中元素的个数判断当前是奇数还是偶数轮次
    //如果是奇数次，则正常添加，如果是偶数次则从尾部添加
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        //如果根节点不为空，将根节点放入双端队列queue中
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            //不会随着size变小而减少次数
            //for (int i = 0; i < queue.size(); i++)  会因为size发生变化导致次数出错
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode poll = queue.poll();
                //根据res的size来判断当前是计数轮次还是偶数轮次
                if (res.size() % 2 == 0) {
                    tmp.addLast(poll.val);
                } else {
                    tmp.addFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
