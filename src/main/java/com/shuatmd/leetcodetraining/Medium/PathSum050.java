package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-07 18:11
 * @Description: TODO
 * @Version: I.0
 */

//剑指 Offer II 050. 向下的路径节点之和
// 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
//路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
public class PathSum050 {
    int ans;
    int target;
    //Long代表当前的和, Integer代表满足sum的点数
    //因为
    Map<Long, Integer> prefixMap = new HashMap<>();
    //官方解法： dfs + 前缀和
    //好处 可以省略第二次dfs的过程
    //通过记录每次的和 可以算出是否当前节点存在满足targetSum的子路径
    public int pathSumPrefixSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        target = targetSum;
        //初始化当前map
        prefixMap.put(0L,1);
        dfs(root,root.val);
        return ans;

    }

    private void dfs(TreeNode root, long val) {
        //查看是否存在符合要求的路径
        ans += prefixMap.getOrDefault(val - target, 0);
        //记录当前的和
        prefixMap.put(val, prefixMap.getOrDefault(val,0) + 1);
        if(root.left != null){
            dfs(root.left,val + root.left.val);
        }
        if(root.right != null){
            dfs(root.right,val + root.right.val);
        }
        //去除当前节点的前缀和数量
        prefixMap.put(val, prefixMap.getOrDefault(val, 0) - 1);
    }

    //笨拙解法1：
    //两套dfs dfs1负责遍历树中所有的节点
    //dfs2负责算设当前节点为根节点,往下计算所有可达路径的和
    //O(n^2)
    public int pathSumDfsTwice(TreeNode root, int targetSum) {
        target = targetSum;
        dfs1(root);
        return ans;
    }

    private void dfs1(TreeNode root) {
        if(root == null){
            return;
        }
        dfs2(root,root.val);
        dfs1(root.left);
        dfs1(root.right);
    }
    //注意使用long来判断 因为节点的null value如果使用int会自动变成0
    private void dfs2(TreeNode root, long val) {
        if(val == target){
            ans ++;
        }
        if(root.left != null){
            dfs2(root.left, val + root.left.val);
        }
        if(root.right != null){
            dfs2(root.right, val + root.right.val);
        }
    }
}
