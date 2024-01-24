package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.HashMap;
import java.util.Map;

//面试题 04.12. 求和路径
//给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
//注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
public class PathSum0412Star {
    //官方解法1： 前缀和 + 递归 解决
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        //添加初始状态 合0的路径有0条
        prefixSumMap.put(0, 1);
        return recursionPathSum(root, prefixSumMap, sum, 0);
    }

    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumMap, int target, int currSum) {
        //终止递归条件
        if (node == null) {
            return 0;
        }
        int res = 0;
        //当前路径上的和
        currSum += node.val;
        //更新可用的路径
        res += prefixSumMap.getOrDefault(currSum - target, 0);
        //更新前缀和的map
        prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);

        res += recursionPathSum(node.left, prefixSumMap, target, currSum);
        res += recursionPathSum(node.right, prefixSumMap, target, currSum);

        //恢复状态
        prefixSumMap.put(currSum, prefixSumMap.get(currSum) - 1);
        return res;
    }

    int count = 0;

    //官方解法2： 递归 + 从下至上算
    public int pathSumOfficial(TreeNode root, int sum) {
        //首先获取
        int depth = findDepth(root);
        int[] pathArray = new int[depth];
        //从level = 0 开始递归
        pathSum(root, sum, 0, pathArray);
        return count;
    }

    private void pathSum(TreeNode root, int sum, int level, int[] pathArray) {
        //终止条件： 当root = 空时 停止
        if (root == null) {
            return;
        }
        //将当前节点的值放入array
        //array中存储的是当前路径下的所有节点对应的值
        pathArray[level] = root.val;
        int currSum = 0;
        //从下至上开始进行循环判断
        //从下至上可以防止重复 并且可以计算子树的和
        for (int i = level; i >= 0; i--) {
            currSum += pathArray[i];
            if (currSum == sum) {
                count++;
            }
        }
        //对整个树进行递归
        pathSum(root.left, sum, level + 1, pathArray);
        pathSum(root.right, sum, level + 1, pathArray);
    }

    private int findDepth(TreeNode root) {
        //递归找到树的深度
        if (root == null) {
            return 0;
        }
        return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
    }
}
