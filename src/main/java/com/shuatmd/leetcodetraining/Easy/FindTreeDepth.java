package com.shuatmd.leetcodetraining.Easy;

import java.util.LinkedList;
import java.util.List;

//剑指 Offer 55 - I. 二叉树的深度
//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
public class FindTreeDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //解法1：通过dfs递归实现
    //深度 = max(maxLength(left), maxLength(right)) + 1
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //解法2：通过bfs+queue实现
    public int maxDepthBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        List<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<TreeNode> tmp = new LinkedList<>();
            for (TreeNode treeNode : treeNodeQueue) {
                if (treeNode.left != null) {
                    tmp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    tmp.add(treeNode.right);
                }
            }
            treeNodeQueue = tmp;
            res++;
        }
        return res;
    }
}
