package com.shuatmd.leetcodetraining.Medium;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//面试题 08.02. 迷路的机器人
//设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
//https://leetcode.cn/problems/robot-in-a-grid-lcci/description/
public class PathWithObstackes0802 {
    List<List<Integer>> res = new ArrayList<>();

    //官方解法1：DP
    //首先通过boolean[][]dp来判断最后一个点是否可达
    //如果不可达则返回空list
    //如果可达,则倒序返回list
    public List<List<Integer>> pathWithObstaclesDP(int[][] obstacleGrid) {
        List<List<Integer>> list = new ArrayList<>();
        //拿到整个坐标系的长以及高
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        //如果起点或者终点为阻碍,则代表无法形成通路
        //直接返回空list
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][column - 1] == 1) {
            return list;
        }
        boolean[][] dp = new boolean[row][column];
        //初始话dp的状态
        dp[0][0] = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //根据dp[i-1][j] 和dp[i][j-1]来判断dp[i][j]是否可达
                if (obstacleGrid[i][j] != 1) {
                    if (i > 0) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                    if (j > 0) {
                        dp[i][j] |= dp[i][j - 1];
                    }
                }
            }

        }
        //判断如果dp[row-1][col-1]不为true,则说明无法到达终点
        //返回空list
        if (!dp[row - 1][column - 1]) {
            return list;
        }
        //dp[row-1][col-1]为true则说明可达终点
        //从终点开始倒着寻找一条全部为true的路径
        int i = row - 1;
        int j = column - 1;
        while(i>=0 && j>=0){
            list.add(Arrays.asList(i,j));
            if(i > 0 && dp[i - 1][j]){
                i --;
            }
            else{
                j--;
            }
        }
        //将list中的节点反过来则是正序的路径
        Collections.reverse(list);
        return list;
    }

    //手搓尝试1：DFS + 剪枝叶
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        path.add(0);
        //添加起点
        res.add(path);
        //dfs递归判断路径
        if (dfs(path.get(0), path.get(1), obstacleGrid)) {
            return res;
        }
        return new ArrayList<>();

    }

    private boolean dfs(Integer x, Integer y, int[][] obstacleGrid) {
        //判断是否越界,是否碰到障碍
        //如果越界||碰到障碍则代表此路不同
        if (x == obstacleGrid.length || y == obstacleGrid[0].length || obstacleGrid[x][y] == 1) {
            return false;
        }
        //判断xy是否已经到达最终点
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            return true;
        }
        //先进行右移x
        List<Integer> cur = new ArrayList<>();
        cur.add(x + 1);
        cur.add(y);
        res.add(cur);
        if (dfs(x + 1, y, obstacleGrid)) {
            return true;
        }
        res.remove(res.size() - 1);

        cur = new ArrayList<>();
        cur.add(x);
        cur.add(y + 1);
        res.add(cur);
        if (dfs(x, y + 1, obstacleGrid)) {
            return true;
        }
        res.remove(res.size() - 1);
        //剪枝 避免重复运算
        obstacleGrid[x][y] = 1;
        return false;
    }

    public static void main(String[] args) {
        int[][] example = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int row = example.length;
        int col = example[0].length;
        System.out.println(example);
        System.out.println("row is " + row);
        System.out.println("column is " + col);
    }
}
