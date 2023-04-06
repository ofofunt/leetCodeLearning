package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer 54. 二叉搜索树的第k大节点
//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
public class KthLargestIntInBinarySearchTree54 {
    int res,k;
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;TreeNode(int x) {val = x; }
  }
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    //反向中序遍历,简化步骤
    //当执行到第k个数字的时候直接记录res的值
    //后续递归全部跳过
    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.right);
        //判断如果k = 0则证明已经找到结果
        if(k == 0){
            return;
        }
        if(--k == 0){
            res = root.val;
        }
        dfs(root.left);
    }
}
