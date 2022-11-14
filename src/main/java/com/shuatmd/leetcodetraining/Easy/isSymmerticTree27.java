package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

public class isSymmerticTree27 {
    //Solution1: 使用递归判断
    public boolean isSymmetric(TreeNode root) {
        //判断是否root已经为空，为空则返回true
        //同时对root的左右节点进行比对，查看对称结点是否相等
        return root == null ? true : recur(root.left, root.right);
    }

    private boolean recur(TreeNode L, TreeNode R) {
        //如果2个节点都为空则说明没有后续子节点，返回true
        if (L == null && R == null) {
            return true;
        }
        //如果只有一个节点为空，则说明为非对称树，返回false
        //如果对称节点的值不相等则也说明当签树不是左右镜像
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        //递归时入参为对称节点，左子叶的左节点对应右子叶的右节点
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
