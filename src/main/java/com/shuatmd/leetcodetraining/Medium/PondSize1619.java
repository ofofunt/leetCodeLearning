package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//面试题 16.19. 水域大小
//你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。
//由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
//https://leetcode.cn/problems/pond-sizes-lcci/description/
public class PondSize1619 {
    //题目思路转换： 其实可以考虑把这道题转换成一个bfs dfs实现的题
    //不同于树 矩阵的移动有8中可能性,同时还需要判断是否经历了重复的点
    //有了这个思路可以尝试解题


    //官方题解1： 复杂一点的DFS
    public int[] pondSizesDFS(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<Integer> resList = new ArrayList<>();
        //遍历整个矩阵,当找到0时,以当前坐标为起点开始进行bfs
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    resList.add(dfs(land, i, j));
                }
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        //记得题目要求排好序
        Arrays.sort(res);
        return res;
    }

    private Integer dfs(int[][] land, int x, int y) {
        int m = land.length;
        int n = land[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || land[x][y] != 0) {
            return 0;
        }
        land[x][y] = -1;
        int res = 1;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                //dx dy都等于0 说明没有进行移动
                if (dx == 0 && dy == 0) {
                    continue;
                }
                res += dfs(land, x + dx, y + dy);
            }
        }
        return res;
    }

    //官方题解2： 先从容易理解的bfs开始做起
    public int[] pondSizesBFS(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<Integer> resList = new ArrayList<>();
        //遍历整个矩阵,当找到0时,以当前坐标为起点开始进行bfs
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    resList.add(bfs(land, i, j));
                }
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        //记得题目要求排好序
        Arrays.sort(res);
        return res;
    }

    private Integer bfs(int[][] land, int x, int y) {
        int m = land.length;
        int n = land[0].length;
        int res = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        //进行初始化
        queue.offer(new int[]{x, y});
        land[x][y] = -1;
        //bfs标准框架
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int currX = arr[0];
            int currY = arr[1];
            res++;
            //模拟8向操作
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    //dx dy都等于0 说明没有进行移动
                    if (dx == 0 && dy == 0) {
                        continue;
                    }
                    //略过可能超过边界的结果,以及不为0的点
                    if (currX + dx < 0 || currX + dx >= m || currY + dy < 0 || currY + dy >= n || land[currX + dx][currY + dy] != 0) {
                        continue;
                    }
                    //剩下的结果都满足等于0 直接添加入后续的queue
                    land[currX + dx][currY + dy] = -1;
                    queue.offer(new int[]{currX + dx, currY + dy});
                }
            }
        }
        return res;
    }
}
