package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

//面试题 10.10. 数字流的秩
//假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说：
//
//实现 track(int x) 方法，每读入一个数字都会调用该方法；
//
//实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
//https://leetcode.cn/problems/rank-from-stream-lcci/
//手搓解法： 过于慢,每次插入都要遍历1到50000次 效率低
public class StreamRank1010Hand {
    int[] rankArray;
    public StreamRank1010Hand() {
        rankArray = new int[50001];
        Arrays.fill(rankArray,0);
    }

    public void track(int x) {
        for (int i = x; i <= 50000; i++) {
            rankArray[i]++;
        }
    }

    public int getRankOfNumber(int x) {
        return  rankArray[x];
    }

    public static void main(String[] args) {
        StreamRank1010Hand rank = new StreamRank1010Hand();
        rank.track(35629);
        rank.track(39039);
        rank.track(37335);
        rank.track(47239);
        rank.track(33143);
        rank.getRankOfNumber(32092);
        rank.getRankOfNumber(30746);
    }
}
