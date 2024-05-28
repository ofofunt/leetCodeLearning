package com.shuatmd.leetcodetraining.Medium;
//面试题 17.11. 单词距离
//有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
//https://leetcode.cn/problems/find-closest-lcci/description/

public class FindClosest1711 {
    //官方解法：双指针, 分别记录word1以及word2最后的index 然后取最小值
    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            if(cur.equals(word1)){
                index1 = i;
            }
            if(cur.equals(word2)){
                index2 = i;
            }
            if(index1 > 0 && index2 > 0){
                res = Math.min(res,Math.abs(index2 - index1));
            }
        }
        return res;
    }
}
