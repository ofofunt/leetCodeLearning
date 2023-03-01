package com.example.leetCodeLearning.src.main.java.com.shuatmd.leetcodetraining.Medium;
// 剑指 Offer 33. 二叉搜索树的后序遍历序列
// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
public class verifyPostorder33 {
    //解法1：递归分治
    //二叉搜索树需要满足：左子树中的节点全部小于根节点，右子树中的节点全部大于根节点且左右子树也需要为二叉搜索树
    public boolean verifyPostOrder(int[] postorder){
        return recur(postorder,0,postorder.length-1);
    }

    boolean recur(int[] postorder, int i, int j){
        //如果i>j,说明节点数量<=1,直接返回true
        if(i >= j){
            return true;
        }
        //找到大于根节点的index,标记p之后的区间为右节点
        //i到p-1为左节点
        int p = i;
        while(postorder[p] < postorder[j]){
            p++;
        }
        int m = p;
        //判断是否右子树的的所有节点都大于根节点
        while(postorder[p] > postorder[j]){
            p ++;
        }
        // p == j 表示右子树中的所有节点都大于都大于根节点，当前树是二分搜索树
        // recur(postorder,i,m-1)判断左子树是否正确
        // recur([postorder,m,j-1])判断右子树是否正确
        return p == j && recur(postorder,i,m-1) && recur(postorder,m,j-1);
    }
}
