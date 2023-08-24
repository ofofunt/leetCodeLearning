package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//面试题 04.04. 检查平衡性
//实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
//https://leetcode.cn/problems/check-balance-lcci/
public class CheckBalancedTree0404Star {
    //dfs递归后续判断 自下往上 不会计算重复节点
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private Integer height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if ((leftHeight == -1) || (rightHeight == -1) || Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    //尝试下一个自上往下的dfs
    public boolean isBalancedTopToBottom(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return (Math.abs(heightFromTopToBottom(root.left) - heightFromTopToBottom(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right));
        }
    }

    private Integer heightFromTopToBottom(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(heightFromTopToBottom(root.left), heightFromTopToBottom(root.right)) + 1;
        }
    }
}
