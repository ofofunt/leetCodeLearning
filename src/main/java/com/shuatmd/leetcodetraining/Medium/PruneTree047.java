package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-04 10:01
 * @Description: TODO
 * @Version: I.0
 */

//剑指 Offer II 047. 二叉树剪枝
//给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
//节点 node 的子树为 node 本身，以及所有 node 的后代。
public class PruneTree047 {
    //递归实现
    //判断条件 左右节点都为空并且自己为0 则剪除
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        //剪枝条件,从下往上剪
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }
}
