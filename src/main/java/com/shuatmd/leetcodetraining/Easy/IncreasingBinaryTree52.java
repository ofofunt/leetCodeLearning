package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-10 16:37
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 052. 展平二叉搜索树
// 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
public class IncreasingBinaryTree52 {
    TreeNode resNode;
    List<Integer> result = new ArrayList<>();
    TreeNode root = new TreeNode(-1);
    //手搓解法1： 先中序遍历 用List记录结果 然后重铸一个新的树
    public TreeNode increasingBSTPro(TreeNode root) {
        TreeNode resNode = root;
        dfsPro(root);
        return root.right;
    }

    private void dfsPro(TreeNode root) {
        if (root.left != null) {
            dfsPro(root.left);
        }
        resNode.right = root;
        root.left = null;
        resNode = root;

        if (root.right != null) {
            dfsPro(root.right);
        }
    }

    //手搓解法1： 先中序遍历 用List记录结果 然后重铸一个新的树
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        TreeNode node = new TreeNode(-1);
        TreeNode cur = node;
        for (Integer integer : result) {
            cur = new TreeNode(integer);
            cur = cur.right;
        }
        //返回的部分需要去掉辅助用的-1
        return node.right;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
