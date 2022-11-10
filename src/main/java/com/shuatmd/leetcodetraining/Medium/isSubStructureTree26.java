package com.shuatmd.leetcodetraining.Medium;

public class isSubStructureTree26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //如果树A或者B为空 直接返回false
        if(A == null || B == null){
            return false;
        }
        //模拟前序遍历，先便利头结点然后左节点然后右节点
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode A, TreeNode B) {
        //终止条件 B为空
        //B为空证明B中的所有节点均已经找到在A中对应的子节点，返回true
        if (B == null) {
            return true;
        }
        //终止条件 A为空，则说明遍历完A的所有节点依然无法找到符合所有B树条件的点
        if (A == null) {
            return false;
        }
        //当前判断，如果当前节点不相等则直接返回false
        if (A.val != B.val) {
            return false;
        }
        //同时递归左右两个节点
        return recur(A, B.left) && recur(A, B.right);
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
