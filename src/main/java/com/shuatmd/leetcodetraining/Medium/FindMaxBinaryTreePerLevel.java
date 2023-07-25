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
 * @CreateTime: 2023-06-15 18:41
 * @Description: TODO
 * @Version: I.0
 */
public class FindMaxBinaryTreePerLevel {
    //官方解法:通过queue来记录每一层的所有值,找出最大值放回result list中
    public List<Integer> largestValues(TreeNode root) {
        //初始化result 和 queue
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue =  new ArrayDeque<>();
        if(root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
                max = Math.max(poll.val,max);
            }
            result.add(max);
        }
        return result;
    }
}
