package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-07 15:54
 * @Description: TODO
 * @Version: I.0
 */

//剑指 Offer II 049. 从根节点到叶节点的路径数字之和
//给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
//每条从根节点到叶节点的路径都代表一个数字：
//例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
//计算从根节点到叶节点生成的 所有数字之和 。
//叶节点 是指没有子节点的节点。
public class SumNumbersBinaryTree049 {
    List<String> numbers = new ArrayList<>();

    //BFS版本
    public int sumNumbersBFS(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        Queue<Integer> numbers = new ArrayDeque<>();
        treeNodes.offer(root);
        numbers.offer(root.val);
        int sum = 0;
        while(!treeNodes.isEmpty()){
            TreeNode temp = treeNodes.poll();
            int num = numbers.poll();
            TreeNode left = temp.left;
            TreeNode right = temp.right;
            if(left == null && right == null){
                sum += num;
            }
            else{
                if(left!=null){
                    treeNodes.offer(left);
                    numbers.offer(left.val + num*10);
                }
                if(right!=null){
                    treeNodes.offer(right);
                    numbers.offer(right.val + num*10);
                }
            }
        }
        return sum;
    }
    //优化版：直接记录int并且使用int来计算
    public int sumNumbersAdvanced(TreeNode root) {
        return dfsInt(root,0);
    }

    private Integer dfsInt(TreeNode root, int preSum) {
        if(root == null){
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        else{
            return dfsInt(root.left, sum) + dfsInt(root.right, sum);
        }
    }

    //手搓解法1： DFS 当左右子树都为空的时候说明已经到底
    //可以优化的点： 不需要用string来记录 最后计算也不需要用对于string遍历
    //可以直接使用10*prevVal + currVal来生成int
    public int sumNumbers(TreeNode root) {
        String curr = "";
        dfs(root, curr);
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    private void dfs(TreeNode root, String curr) {
        if (root == null) {
            curr = curr.substring(0, curr.length() - 1);
        } else {
            curr = curr + String.valueOf(root.val);
            dfs(root.left, curr);
            if (root.left == null && root.right == null) {
                numbers.add(curr);
            }
            dfs(root.right, curr);
        }
    }
}
