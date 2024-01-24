package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.List;

//面试题 16.11. 跳水板
//你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
//
//返回的长度需要从小到大排列。
//https://leetcode.cn/problems/diving-board-lcci/
public class DivingBoardSum1611 {
    List<Integer> resList = new ArrayList<>();

    //官方解法1： 数学法做 因为提到k< 100000 常规的递归法来实现肯定会超时
    //数学解法 假设选择了k-i个短木板 此时的长度为f(i) = shorter * (k - i) + longer * i = shorter * k + (longer - shorter) * i
    //上述四个数均为已知,所以一次递归就好了 也不用进行排序 因为f(i)为单调递增 i越大 结果就越大
    public int[] divingBoardOfficial(int shorter, int longer, int k) {
        //首先排除两个特殊情况 k = 0以及longer shorter长短相等
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{k * longer};
        }
        //非特例直接对i循环 代入上述公式 注意i可以等于k
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = shorter * k + (longer - shorter) * i;
        }
        return res;
    }

    //手搓尝试1： 回溯(?) + 去重
    //超内存了 想想咋改
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] boards = new int[]{shorter, longer};
        bfs(shorter, longer, 0, 0, k);
        return resList.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
    }

    private void bfs(int shorter, int longer, int sum, int start, int k) {
        if (start == k) {
            resList.add(sum);
            return;
        }
        //只有2个枝 不需要while
        bfs(shorter, longer, sum + shorter, start + 1, k);
        //如果shorter == longer 不需要进行分支操作
        if (shorter != longer) {
            bfs(shorter, longer, sum + longer, start + 1, k);
        }
    }

    public static void main(String[] args) {
        DivingBoardSum1611 dive = new DivingBoardSum1611();
        dive.divingBoard(1, 2, 3);
    }
}
