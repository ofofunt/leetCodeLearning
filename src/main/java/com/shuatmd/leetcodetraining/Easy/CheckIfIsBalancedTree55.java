package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//剑指 Offer 55 - II. 平衡二叉树
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
public class CheckIfIsBalancedTree55 {
    //官方解法1： 通过dfs+剪枝来做
    //判断计算深度的中途是否会发生左右子树深度差距超过1的情况
    //如果已经超过1 则剪枝
    public boolean isBalancedOfficial(TreeNode root) {
        return recurOfficial(root) != -1;
    }
    private int recurOfficial(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recurOfficial(root.left);
        if(left == -1){
            return -1;
        }
        int right = recurOfficial(root.right);
        if(right == -1){
            return -1;
        }
        return Math.abs(left - right )> 2? Math.max(left,right) + 1: -1;
    }

    //完整注解版本
    public boolean isBalancedWithNotes(TreeNode root) {
        return dfs(root)==-1?false:true;
    }

    //用left，right记录root左右子节点的深度，避免遍历root时对左右节点的深度进行重复计算。
    //考虑到需要同时记录各个节点的深度和其是否符合平衡性要求，这里的返回值设为int,用一个特殊值-1来表示出现不平衡的节点的情况，而不是一般采用的boolean
    public int dfs(TreeNode root){
        //用后序遍历的方式遍历二叉树的每个节点（从底至顶）,先左子树，再右子树，最后根节点，
        if(root==null) return 0;//root等于0时，该节点符合要求，返回其深度0，而不返回-1；
        int left = dfs(root.left);//left最开始的取值为0，从底朝上遍历，先左子树，后右子树，最后根节点
        if(left==-1) return -1;//若出现节点的深度为-1，则进行剪枝，开始向上返回，之后的迭代不再进行
        int right = dfs(root.right);
        if(right==-1) return -1;
        return Math.abs(right-left)<2?Math.max(left,right)+1:-1;//+1不能少
        //最开始计算的是左子树最左侧的一个叶节点，其左右子节点不存在，left=0，right=0，满足条件，返回该叶节点的深度max(0,0)+1=1;
    }

    //自己写的,判断是否左子树与右子数深度差大于1,如果大于1则深度-1
    //效率不够,没有剪枝
    public boolean isBalanced(TreeNode root) {
        return recur(root) > 1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (Math.abs(recur(root.left) - recur(root.right)) > 1) {
            return -1;
        }
            return Math.max(recur(root.left), recur(root.right)) + 1;
    }
}
