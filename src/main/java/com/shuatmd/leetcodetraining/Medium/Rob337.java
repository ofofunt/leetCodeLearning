package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.*;

//337. 打家劫舍 III
//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
//
//除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
//
//给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
//
//https://leetcode.cn/problems/house-robber-iii/description/
public class Rob337 {
    //官方解法1：递归+dp：暴力解法
    //有两个偷的方法 偷当前层以及下下层 int method1 = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right)
    //偷下一层 int method2 = rob(root.left) + rob(root.right)
    public int robDp(TreeNode root) {
        if(root == null){
            return 0;
        }
        int money = root.val;
        if(root.left!=null){
            money+=rob(root.left.left) + rob(root.left.right);
        }
        if(root.right!=null){
            money+=rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money,rob(root.left) + rob(root.right));
    }
    //手撕解法1：遍历整个树,然后分别求偶数层以及奇数层的和
    //考虑并不全面：最大值并不一定只在奇和偶层中产生,也可能存在1,4层的和最高
    public int rob(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<TreeNode,Integer> levelMap = new HashMap<>();
        levelMap.put(root, 1);
        int oddSum = 0;
        int evenSum = 0;
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.left!=null){
                queue.offer(poll.left);
                levelMap.put(poll.left,levelMap.get(poll) + 1);
            }
            if(poll.right!=null){
                queue.offer(poll.right);
                levelMap.put(poll.right,levelMap.get(poll) + 1);
            }
        }
        for (TreeNode treeNode : levelMap.keySet()) {
            if(levelMap.get(treeNode)%2 == 0){
                evenSum += treeNode.val;
            }
            else {
                oddSum += treeNode.val;
            }
        }
        return Math.max(evenSum,oddSum);
    }

    public static void main(String[] args) {
        Rob337 rob = new Rob337();
        TreeNode treeNode = TreeNode.buildTree(Arrays.asList(4, 1, null, 2, null, 3));
        rob.robDp(treeNode);
    }
}
