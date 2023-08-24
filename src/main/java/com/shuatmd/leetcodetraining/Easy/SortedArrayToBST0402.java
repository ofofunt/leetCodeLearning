package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//面试题 04.02. 最小高度树
//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
//https://leetcode.cn/problems/minimum-height-tree-lcci/description/
public class SortedArrayToBST0402 {
    //手搓解法： 递归
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    private TreeNode recur(int[] nums, int low, int high) {
        if(low > high){
            return null;
        }
        //找到当前分支的中点
        //因为要确定之后部分的中点 所以需要加上low这个基准点
        int mid = (high - low)/2 + low;
        TreeNode cur = new TreeNode(nums[mid]);
        //对左右两部分子树进行递归
        cur.left = recur(nums,low,mid -1);
        cur.right = recur(nums, mid + 1, high);
        return cur;
    }
}
