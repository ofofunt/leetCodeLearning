package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.Stack;

//面试题 04.06. 后继者
//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
//
//如果指定节点没有对应的“下一个”节点，则返回null。
//https://leetcode.cn/problems/successor-lcci/
public class InorderSuccessor0406 {
    //手搓尝试1
    //非递归 用循环来实现中序遍历+判断
    TreeNode prev;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre == p) {
                return root;
            }
            pre = root;
            root = root.right;
        }
        return null;
    }

    //官方解法
    //递归查询
    public TreeNode inorderSuccessorRecursive(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        //当root的值小于p的值 说明p一定在root的右子树
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        //当root的值第一次大于p时,还需要判断当前的点是否有左子树,
        TreeNode ans = inorderSuccessor(root.left, p);
        return ans == null ? root : ans;

    }

}
