package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTreeDepthOrder {
    //Solution: 用BFS来打印result
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        //将当前root放入queue中
        queue.add(root);
        //BFS： 如果当前root有左或者右，则添加到queue中
        // 如果queue为空则证明整个tree已经被轮询完
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resultList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
            int[] res = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                res[i] = resultList.get(i);
            }
            return res;
        }

}
