package com.example.leetCodeLearning.src.main.java.com.shuatmd.leetcodetraining.Easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintlevelOrder32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tep = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                tep.add(poll.val);
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
            resultList.add(tep);
        }
        return resultList;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }




}
