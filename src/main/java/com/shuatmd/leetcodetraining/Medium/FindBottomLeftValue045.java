package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-20 17:34
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 045. 二叉树最底层最左边的值
//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//假设二叉树中至少有一个节点。

public class FindBottomLeftValue045 {
    int curVal = 0;
    int curHeight = 0;
    //手搓方法 DFS
    //先找到最深的层,然后找到最深层的val
    public int findBottomLeftValueDFS(TreeNode root) {
        int curHeight = 0;
        dfs(root,0);
        return curVal;
    }

    private void dfs(TreeNode root, int height) {
        if(root == null){
            return;
        }
        height++;
        dfs(root.left,height);
        dfs(root.right,height);
        if(height > curHeight){
            curHeight = height;
            curVal = root.val;
        }
    }

    //手搓方法 BFS
    //每一层都都找一次 优先把右边的子树放进去
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.right != null){
                queue.offer(poll.right);
            }
            if(poll.left != null){
                queue.offer(poll.left);
            }
            result = poll.val;
        }
        return result;
    }
}
