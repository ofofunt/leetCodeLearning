package com.shuatmd.leetcodetraining.DTO;

import com.shuatmd.leetcodetraining.Easy.MirrorTree26;

import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode buildTree(List<Integer> inorder) {
        return buildTreeHelper(inorder, 0, inorder.size() - 1);
    }

    private static TreeNode buildTreeHelper(List<Integer> inorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // 中序遍历中，根节点位于左右子树中间
        Integer rootVal = inorder.get(left);
        if (rootVal == null) {
            // 如果根节点是null，返回null表示空树
            return null;
        }
        TreeNode root = new TreeNode(rootVal);

        // 计算左子树的大小
        int leftSize = 0;
        for (int i = left + 1; i <= right; i++) {
            if (inorder.get(i).equals(rootVal)) {
                leftSize = i - left - 1;
                break;
            }
        }

        // 递归构建左子树和右子树
        root.left = buildTreeHelper(inorder, left + 1, left + leftSize);
        root.right = buildTreeHelper(inorder, left + leftSize + 1, right);

        return root;
    }
}
