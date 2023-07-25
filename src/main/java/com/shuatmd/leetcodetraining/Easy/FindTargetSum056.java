package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.*;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-14 15:31
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 056. 二叉搜索树中两个节点之和
//给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
public class FindTargetSum056 {
    Set<Integer> set = new HashSet<>();
    List<Integer> list = new ArrayList<Integer>();
    //官方推荐解法：双指针 —— 
    //手搓代码2：BFS + HashSet
    public boolean findTargetBfs(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return false;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (set.contains(k - poll.val)) {
                return true;
            }
            set.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return false;
    }

    //手搓代码：DFS + HashMap
    public boolean findTargetDfs(TreeNode root, int k) {
        return dfs(root, k);
    }

    private boolean dfs(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k) || dfs(root.right, k);
    }
}
