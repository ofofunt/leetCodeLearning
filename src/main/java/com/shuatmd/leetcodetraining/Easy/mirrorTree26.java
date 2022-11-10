package com.shuatmd.leetcodetraining.Easy;

public class mirrorTree26 {
    //Solution1: 中序遍历
    //先用tmp暂存root左边子节点，然后使root左节点 = root右节点
    //root右节点等于 暂存的左节点的值
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;

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
