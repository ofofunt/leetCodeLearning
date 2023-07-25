package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-13 17:25
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 054. 所有大于等于节点的值之和
//给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
public class SumOfBinaryTree054 {
    int result = 0;
    //手搓解法： dfs后序遍历 + 统计result 从右 -> root -> 左的顺序叠加
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.right != null){
            dfs(root.right);
        }
        result += root.val;
        root.val = result;
        if(root.left != null){
            dfs(root.left);
        }
    }
}
