package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//面试题 04.01. 节点间通路
//节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径
//https://leetcode.cn/problems/route-between-nodes-lcci/description/
public class FindWhetherExistsPath0401 {
    //手搓解法： 转换领接表 之后用BFS来查找

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        //首先将graph转换成领接表
        //比如 int[][] = {{0,1},{1,2},{1,2}}
        //需要转换成 0 -> 1  1 -> 2 -> 2
        //代表 0可以到达1 1可以到达2以及2
        List<Integer>[] adjList = new ArrayList[n];
        for (int[] ints : graph) {
            //起点为ints中的第0位  可以到达的点为ints[]中的第一位
            int startPoint = ints[0];
            int endPoint = ints[1];
            if(adjList[startPoint] == null){
                adjList[startPoint] = new ArrayList<>();
            }
            adjList[startPoint].add(endPoint);
            //通过上述转换,我们可以得到一个List数组 数组中储存的是以当前index为起点 所能到达的终点的集合
            //进行第二步,bfs查询
        }
        return bfs(start,target,adjList);
    }

    private boolean bfs(int start, int target, List<Integer>[] adjList) {
        Boolean[] validPath = new Boolean[adjList.length];
        validPath[start] = true;
        Queue<Integer> pointQueue = new LinkedList<>();
        pointQueue.offer(start);
        while(!pointQueue.isEmpty()){
            int cur = pointQueue.poll();
            List<Integer> edges = adjList[cur];
            //如果当前节点不存在可以到达的点则轮空
            if(edges == null){
                continue;
            }
            for (Integer edge : edges) {
                //如果可以到达的点中包含终点,直接返回true
                if(edge == target){
                    return true;
                }
                if(validPath[edge]){
                    continue;
                }
                validPath[edge] = true;
                pointQueue.add(edge);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindWhetherExistsPath0401 findWhetherExistsPath0401 = new FindWhetherExistsPath0401();
        findWhetherExistsPath0401.findWhetherExistsPath(3,new int[][]{{0,1},{0,2},{1,2},{1,2}}, 0 , 2);
    }
}
