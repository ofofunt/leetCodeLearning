package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.*;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-12 15:39
 * @Description: TODO
 * @Version: I.0
 */
public class InorderSuccessor053 {
    List<TreeNode> tree = new ArrayList<>();

    //二叉搜索树实现：
    //因为是二叉搜索树,所以只需要找到大于p.value的最小的node节点就好
    //假如p存在右子树,则结果只会存在其右子树之中 需要找右子树中最左的节点
    //如果p不在右子树 则需要从根节点开始遍历 大于p则往左轮询 小于p往右
    public TreeNode inorderSuccessorBTree(TreeNode root, TreeNode p) {
        TreeNode result = null;
        //如果存在右子树,找寻右子树中最左的点
        if(p.right != null){
            result = p.right;
            while(result.left != null){
                result = result.left;
            }
            return result;
        }
        TreeNode node = root;
        while(node != null){
            if(node.val > p.val){
                result = node;
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
        return result;
    }


    //优化写法1：只记录上一个访问的节点和当前的节点
    //如果上一个为p 则当前为结果,如果没有则Return null
    //BFS实现
    public TreeNode inorderSuccessorAdvanced(TreeNode root, TreeNode p) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode prev = null;
        TreeNode curr = root;
        while(!queue.isEmpty() || curr != null){
            while(curr != null){
                queue.push(curr);
                curr = curr.left;
            }
            curr = queue.pop();
            if(prev == p){
                return curr;
            }
            //curr = curr.right是因为当前节点left没有东西,遍历到的是root节点
            //按照顺序下一个节点就是root.right
            //举例子：
            //     4
            //  1     6
            //    2 3   7
            //curr为1 left为空 按照中序的顺序应该走到curr.right 2
            prev = curr;
            curr = curr.right;
        }
        return null;
    }

    //手搓写法：先中序遍历,然后放入List中,找List后一位treeNode返回
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
        if (tree.size() <= tree.indexOf(p) + 1) {
            return null;
        }
        return tree.get(tree.indexOf(p) + 1);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        tree.add(root);
        dfs(root.right);
    }
}
