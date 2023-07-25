package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;

//面试题 01.02. 判定是否互为字符重排
//给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
public class CheckPermutation0102 {
    public boolean CheckPermutation(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a'] += 1;
        }
        for (char c : s2.toCharArray()) {
            s2Count[c - 'a'] += 1;
        }
        return Arrays.equals(s1Count,s2Count);
    }
}
