package com.shuatmd.leetcodetraining.Easy;

public class MirrorTree26 {
    //Solution1: 中序遍历
    //先用tmp暂存root左边子节点，然后使root左节点 = root右节点
    //root右节点等于 暂存的左节点的值
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;

    }

    public Boolean isEqualTree(TreeNode root, TreeNode mirrorTree){
        if(root == null && mirrorTree == null){
            return true;
        }
        if((root == null && mirrorTree !=null) || (root != null && mirrorTree == null)){
            return false;
        }
        if(root.val != mirrorTree.val){
            return false;
        }
        return isEqualTree(root.left,mirrorTree.left) && isEqualTree(root.right,mirrorTree.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.left = new TreeNode(2);
        tree.left.right = new TreeNode(3);
        tree.right.right = new TreeNode(3);
        MirrorTree26 mirrorTree26 = new MirrorTree26();
        TreeNode mirrorTree = mirrorTree26.mirrorTree(tree);
        System.out.println((mirrorTree26.isEqualTree(tree,mirrorTree)));
    }
}
