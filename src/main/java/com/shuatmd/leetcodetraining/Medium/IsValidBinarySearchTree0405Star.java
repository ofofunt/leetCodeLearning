package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.Stack;

//面试题 04.05. 合法二叉搜索树
//实现一个函数，检查一棵二叉树是否为二叉搜索树。
//https://leetcode.cn/problems/legal-binary-search-tree-lcci/
public class IsValidBinarySearchTree0405Star {
    TreeNode prev;

    //官方推荐解法1：
    //递归 + 范围判断 在递归的同时赋值min max 来传递比较的信息
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        //每个节点如果超过这个范围，直接返回false
        if (root.val >= maxVal || root.val <= minVal)
            return false;
        //这里再分别以左右两个子节点分别判断，
        //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    //官方推荐解法2：用树的遍历来做
    //用递归实现中序遍历
    public boolean isValidBSTDFS(TreeNode root) {
        //终止条件root为null
        if (root == null) {
            return true;
        }
        //首先递归到最左的子树
        if (!isValidBSTDFS(root.left)) {
            return false;
        }
        //比较上一个访问的节点与现在的节点
        //因为二叉搜索树中序遍历一定是升序,如果出现降序或者为空 则说明不是二叉搜索树
        //prev需要 < root.val
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        //记录当前所到的节点 为prev
        prev = root;
        if (!isValidBSTDFS(root.right)) {
            return false;
        }
        return true;
    }

    //手搓解法1： 用树的中序遍历来判断
    //用BFS + stack实现中序遍历 很巧妙
    public boolean isValidBSTBFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            //把当前点以及当前点的左子树全部加入到stack之中
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev !=null && root.val <= prev.val){
                return false;
            }
            //实现遍历顺序 左子树 -> root -> 右子树
            prev = root;
            root = root.right;
        }
        return true;
    }
}

