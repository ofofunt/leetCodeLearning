package com.shuatmd.leetcodetraining.Easy;

//面试题 10.05. 稀疏数组搜索
//稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
//https://leetcode.cn/problems/sparse-array-search-lcci/
public class FindString1005 {
    //手搓解法2：二分查找
    //因为已经排好序,所以通过二分查找会更加快速
    public int findStringBinarySearch(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            while ("".equals(words[mid]) && mid > left) {
                mid--;
            }
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) < 0) {
                left = mid + 1;
            } else if(words[mid].compareTo(s) > 0){
                right = mid -1;
            }
        }
        return -1;
    }

    //手搓解法1：纯暴力遍历 然后加入条件判断
    //效率低 如果在队列末尾则需要额外的时间
    public int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if ("".equals(words[i]) || words[i].charAt(0) > s.charAt(0)) {
                continue;
            } else if (s.equals(words[i])) {
                return i;
            }
        }
        return -1;
    }
}
