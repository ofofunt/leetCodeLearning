package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.*;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-20 18:05
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 046. 二叉树的右侧视图
//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

public class BinaryTreeRightSideView046 {
    //手搓解法BFS
    //注意要点 需要记录depth 同时需要注意的是如何记录每层的最后一个记录的
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //通过depthQueue可以详细记录当前的root处于哪一个冲击
        Queue<Integer> depthQueue = new ArrayDeque<>();
        //用map来记录每个depth最后遍历到的点
        Map<Integer, Integer> treeValueMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        depthQueue.add(0);
        int maxDepth = -1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            int depth = depthQueue.poll();
            if (poll != null) {
                maxDepth = Math.max(depth, maxDepth);
                if (poll.left != null) {
                    queue.offer(poll.left);
                    depthQueue.offer(depth + 1);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    depthQueue.offer(depth + 1);
                }
                treeValueMap.put(maxDepth, poll.val);
            }
        }
        for (int i = 0; i <= maxDepth; i++) {
            resultList.add(treeValueMap.get(i));
        }
        return resultList;
    }
}
