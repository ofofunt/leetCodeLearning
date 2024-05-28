package com.shuatmd.leetcodetraining.Medium;
//310. 最小高度树
//树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
//
//给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
//
//可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
//
//请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
//
//树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindMinHeightTrees310 {
    //官方解法1：
    //对整个树进行反向的dfs,逐步排除掉degree = 1的节点
    //在排除的同时,将排出的节点的邻居的degree也减去1
    //最后一次degree为1的节点就是答案
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        //只有一个节点,则返回0
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        //遍历edge数组 添加对应的度数,以及记录邻居的信息
        for (int[] edge : edges) {
            degree[edge[0]] ++;
            degree[edge[1]] ++;
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        //初始化第一次bfs,将首次循环之后度为1的边加入queue中
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if(degree[i] == 1){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            res = new ArrayList<>();
            //queue size会不断变化,需要在外面设定好size作为循环次数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                res.add(poll);
                List<Integer> edgeList = neighbors.get(poll);
                for (int edge : edgeList) {
                    degree[edge] --;
                    if(degree[edge] == 1){
                        queue.offer(edge);
                    }
                }
            }
        }
        return res;
    }
}
