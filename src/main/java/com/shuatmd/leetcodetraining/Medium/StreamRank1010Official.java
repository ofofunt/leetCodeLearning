package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;

//面试题 10.10. 数字流的秩
//假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说：
//
//实现 track(int x) 方法，每读入一个数字都会调用该方法；
//
//实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
//https://leetcode.cn/problems/rank-from-stream-lcci/
//官方解法：维护一个排序好的list,其中int x对应的index的值
public class StreamRank1010Official {
    List<Integer> rankList;

    public StreamRank1010Official() {
        rankList = new ArrayList<>();
    }

    public void track(int x) {
        int mid = getIndex(x);
        rankList.add(mid,x);
    }

    private int getIndex(int x) {
        int left = 0;
        int right = rankList.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (rankList.get(mid) <= x) {
               left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return mid;
    }

    public int getRankOfNumber(int x) {
        return getIndex(x);
    }

    public static void main(String[] args) {
        StreamRank1010Official rank = new StreamRank1010Official();
        rank.track(35629);
        rank.track(39039);
        rank.track(37335);
        rank.track(47239);
        rank.track(33143);
        rank.getRankOfNumber(32092);
        rank.getRankOfNumber(30746);
    }
}
