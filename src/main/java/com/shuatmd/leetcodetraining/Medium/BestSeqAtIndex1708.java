package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//面试题 17.08. 马戏团人塔
//有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
//
//示例：
//
//输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
//输出：6
//解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
//https://leetcode.cn/problems/circus-tower-lcci/description/


public class BestSeqAtIndex1708 {
    //官方解法1：
    //首先将问题转换
    //题目要求为身高与体重同时递增且不能存在相同的情况
    //可以将题目转换为其中一个序列排序之后 求另外一个序列的最长递增子序列
    //但是因为会存在相等的情况 比如说 身高(172,172) 体重(80,90) 单看体重为递增 但是忽略了身高相等并不满足题目条件
    public int bestSeqAtIndexOfficial(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; i++) {
            person[i] = new int[]{height[i],weight[i]};
        }
        //对array进行排序 先根据身高升序排列
        //如果身高一样 则根据体重降序排列
        Arrays.sort(person,(a,b) -> a[0] == b[0]? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < len; ++i) {
            int max_val = 0, base_weight = person[i][1];
            for (int j = 0; j < i; ++j)
                if (base_weight > person[j][1])
                    max_val = Math.max(max_val, dp[j]);
            dp[i] = max_val + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    //手搓解法尝试1： 将height weight通过map来建立一对一关联
    //之后将height sort之后 生成对应的weight的array
    //循环sort之后的height并且保持height与weight同样处于递增状态
    //理解出现问题 并不是直接求连续保持递增的子数列 而是求可以保持递增的子数列
    public int bestSeqAtIndex(int[] height, int[] weight) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < height.length; i++) {
            map.put(height[i],weight[i]);
        }
        int[] sortedHeight = Arrays.copyOf(height,height.length);
        Arrays.sort(sortedHeight);
        int[] sortedWeight = new int[weight.length];
        for (int i = 0; i < sortedWeight.length; i++) {
            sortedWeight[i] = map.get(sortedHeight[i]);
        }
        int maxLength = 0;
        int curLength = 1;
        for (int i = 0; i < sortedHeight.length; i++) {
            if(i < sortedWeight.length - 1 && sortedWeight[i] < sortedWeight[i + 1]){
                curLength++;
            }
            else {
                if(curLength > maxLength){
                    maxLength = curLength;
                }
                curLength = 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        BestSeqAtIndex1708 test = new BestSeqAtIndex1708();
        test.bestSeqAtIndex(new int[]{2868,5485,1356,1306,6017,8941,7535,4941,6331,6181}, new int[]{5042,3995,7985,1651,5991,7036,9391,428,7561,8594});
    }
}
