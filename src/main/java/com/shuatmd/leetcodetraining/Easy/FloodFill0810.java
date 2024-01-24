package com.shuatmd.leetcodetraining.Easy;
//面试题 08.10. 颜色填充
//编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
//
//待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
//
//「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
//
//请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.cn/problems/color-fill-lcci/description/
public class FloodFill0810 {
    //手搓解法1：dfs
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //新旧颜色一眼 不需要填充
        if (newColor == image[sr][sc]) {
            return image;
        }
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        //判断条件 如果当前的点不符合要求则不继续dfs
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, newColor, oldColor);
        dfs(image, sr + 1, sc, newColor, oldColor);
        dfs(image, sr, sc - 1, newColor, oldColor);
        dfs(image, sr, sc + 1, newColor, oldColor);
    }

    //手搓尝试2： BFS尝试
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        //新旧颜色一眼 不需要填充
        if (newColor == image[sr][sc]) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int[][] moveMatrix = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int oldColor = image[x][y];
            image[x][y] = newColor;
            //通过移动矩阵依次将上下左右中符合要求的点加入queue中
            for (int i = 0; i < moveMatrix.length; i++) {
                int x1 = moveMatrix[i][0] + x;
                int y1 = moveMatrix[i][1] + y;
                //需要防止等于newColor 加上image[x1][y1] != newColor
                //再添加点时,没有去重 会导致有些点重复被添加到queue之中,如果之前已经被修改过color 会导致oldColor的值出错
                if (x1 >= 0 && y1 >= 0 && x1 < image.length && y1 < image[0].length && image[x1][y1] == oldColor && image[x1][y1] != newColor) {
                    queue.offer(new int[]{x1, y1});
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        FloodFill0810 floodFill = new FloodFill0810();
        floodFill.floodFillBFS(image, 1, 1, 2);
    }
}
