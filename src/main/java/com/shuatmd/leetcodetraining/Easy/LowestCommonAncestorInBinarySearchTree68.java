package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
public class LowestCommonAncestorInBinarySearchTree68 {
    //自己写的解法：递归+判断
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //确保p一定是小于q的状态
        if(p.val > q.val){
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        return dfs(root,p,q);
    }
    //改良版本递归
    private TreeNode dfsAdvanced(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val){
            return dfsAdvanced(root.right,p,q);
        }
        if(root.val > p.val && root.val > q.val){
            return dfsAdvanced(root.left,p,q);
        }
        return root;
    }
    //递归判断,因为是二叉搜索树,所以终止条件只有三种情况
    //1. p q在root的左右 这样root一定是p q的祖先
    //2. p为当前root,且q在p的右子树中
    //3. q为当前root且p在其左子树中
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val > root.val){
            return root;
        }
        else if(root == p){
            return p;
        }
        else if (root == q){
            return q;
        }
        else if(p.val < root.val && q.val < root.val){
            return dfs(root.left,p,q);
        }
        else{
            return dfs(root.right,p,q);
        }
    }
}
