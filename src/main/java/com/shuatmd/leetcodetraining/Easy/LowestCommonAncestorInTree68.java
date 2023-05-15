package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//
public class LowestCommonAncestorInTree68 {
    //用dfs递归来做
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }

    //dfs递归 首先遍历左子树 然后右子树
    //停止条件： root为空,则直接返回空 如果当前root为p或者q则直接返回p q
    //如果left,right都为空,代表root的做右子树都不包含p,q 返回null
    //如果left,right其中一个为空,说明存在p,q异侧的情况 返回root
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p){
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if(left == null && right == null){
            return null;
        }
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
