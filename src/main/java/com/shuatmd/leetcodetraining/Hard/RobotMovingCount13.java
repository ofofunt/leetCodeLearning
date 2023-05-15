package com.shuatmd.leetcodetraining.Hard;

import java.util.LinkedList;
import java.util.Queue;

//面试题13. 机器人的运动范围
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
// 它每次可以向左、右、上、下移动一格（不能移动到方格外），
// 也不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
// 请问该机器人能够到达多少个格子？
public class RobotMovingCount13 {
    int m,n,k;
    boolean[][] visited;
    //解法2：dfs来解
    //时间复杂度O(MN） 空间复杂度O(MN)
    public int movingCountDfs(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        boolean[][] visited = new boolean[m][n];
        this.visited = visited;
        int res = dfs(0,0,0,0);
        return res;
    }

    private Integer dfs(int x, int y, int sumX, int sumY) {
        if(x >= m || y >= n ||  sumX + sumY >= k || visited[x][y]){
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y , (x + 1) % 10 == 0? sumX - 8: sumX + 1, sumY) +
                dfs(x, y + 1 , sumX, (y + 1) % 10 == 0? sumY - 8: sumY + 1);
    }

    //解法1：bfs来解
    //时间复杂度O(MN） 空间复杂度O(MN)
    public int movingCountBfs(int m, int n, int k) {
        //新建一个数组来记录当前点是否被访问过,防止重复计算
        boolean[][] visited = new boolean[m][n];
        //初始化原点[0,0]
        int[] startPoint = new int[]{0,0,0,0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(startPoint);
        int res = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int sumX = poll[2];
            int sumY = poll[3];
            //不符合条件的话直接跳过
            if(x >= m || y >= n || k<sumX + sumY || visited[x][y] ){
                continue;
            }
            visited[x][y] = true;
            res++;
            //数位和并不是纯累加关系,遇到进位需要发生改变
            //例子 18 -> 19 = 9 + 1 =1 0
            //    19 -> 20 = 1 + 9 - 8 = 2;
            //用这个规律重新加入新的需要运算的坐标
            queue.add(new int[]{x + 1, y , (x + 1) % 10 == 0? sumX - 8: sumX + 1, sumY});
            queue.add(new int[]{x, y + 1 , sumX, (y + 1) % 10 == 0? sumY - 8: sumY + 1});
        }
        return res;
    }
    //求和方法,循环除以10,将余数相加得到数位和
    public int digitSum(int i){
        int sum = 0;
        while(i != 0){
            sum += i%10;
            i = i/10;
        }
        return sum;
    }
}
