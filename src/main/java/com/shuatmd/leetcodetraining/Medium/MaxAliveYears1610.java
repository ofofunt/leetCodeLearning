package com.shuatmd.leetcodetraining.Medium;

//面试题 16.10. 生存人数
//给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
//
//你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
//
//如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
//https://leetcode.cn/problems/living-people-lcci/
public class MaxAliveYears1610 {
    //官方解法1：先统计每年的差值差值
    //然后轮询年数 最终得到最终值
    public int maxAliveYearOfficial(int[] birth, int[] death) {
        int[] changeCount = new int[102];
        for (int i = 0; i < birth.length; i++) {
            //如果有人在1901年出生,就表示1901年多了一个存活的人
            changeCount[birth[i] - 1900] ++;
            //同理如果在1901年去世,则表示1902年少了一个活着的人
            changeCount[death[i] - 1899] --;
        }
        int maxAliveCount = 0;
        int maxYear = 1900;
        int currCount = 0;
        //注意需要循环1900-2000年 而不是循环birth的长度
        for (int i = 0; i < 101; i++) {
            currCount += changeCount[i];
            if(currCount > maxAliveCount){
                maxAliveCount = currCount;
                maxYear = 1900 + i;
            }
        }
        return maxYear;
    }
    //手搓解法1:尝试最蠢的方法,数组遍历然后选最大
    //稍微优化了下,在遍历的同时记录maxAlive的值
    //同时记录下存在最大aliveCount时候的index 如果存在相同值,则取小的index
    public int maxAliveYear(int[] birth, int[] death) {
        int[] aliveCount = new int[101];
        int maxYear = 1900;
        int maxAlive = 0;
        for (int i = 0; i < birth.length; i++) {
            for (int j = birth[i] - 1900; j <= death[i] - 1900; j++) {
                aliveCount[j]++;
                if (aliveCount[j] > maxAlive) {
                    maxAlive = aliveCount[j];
                    maxYear = j + 1900;
                }
                //通过else if判断存在相同maxAlive的时候,选取最小的年份
                else if (aliveCount[j] == maxAlive) {
                    maxYear = Math.min(j + 1900, maxYear);
                }
            }
        }
        return maxYear;
    }

    public static void main(String[] args) {
        MaxAliveYears1610 max = new MaxAliveYears1610();
        max.maxAliveYear(new int[]{1971, 1940, 1968, 1957, 1953, 1921, 1950, 1925, 1935, 1919, 1933, 1922, 1992, 1910, 1946, 1918, 1932, 1932},
                new int[]{1990, 1998, 1981, 1964, 1970, 1989, 1989, 1949, 1963, 1946, 1972, 1935, 1999, 1979, 1993, 1943, 1933, 1944});
    }
}
