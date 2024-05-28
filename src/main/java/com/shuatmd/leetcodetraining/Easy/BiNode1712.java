package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//面试题 17.12. BiNode
//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
//
//返回转换后的单向链表的头节点。
public class BiNode1712 {
    TreeNode head = new TreeNode(-1);
    TreeNode prev = head;
    public TreeNode convertBiNode(TreeNode root) {
        inOrder(root);
        return head.right;
    }

    private void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        prev.right = root;
        prev = root;
        root.left = null;
        inOrder(root.right);
    }
}
