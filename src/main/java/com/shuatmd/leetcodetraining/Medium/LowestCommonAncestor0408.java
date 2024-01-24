package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//面试题 04.08. 首个共同祖先
//设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
//https://leetcode.cn/problems/first-common-ancestor-lcci/description/
public class LowestCommonAncestor0408 {
    //递归 + 分情况考虑
    //一共可能出现三种情况：
    //1. p q 分别在两个子树,共同祖先为root
    //2. p q 在同一子树 先找到谁 谁就是共同祖先
    //3. p q其中一个为root root就是祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //如果找到了p或者q直接返回
        //解决case3
        if (root == p || root == q) {
            return root;
        }
        //分别在左右子树寻找p以及q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //case1： 在左右子树分别找到pq,说明共同祖先为root
        if (left != null && right != null) {
            return root;
        }
        //遍历一定会找到p或者q,先找到谁谁就是root
        //解决case2
        return left != null ? left : right;
    }
}
