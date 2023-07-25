package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-07 16:35
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 032. 有效的变位词
//给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
//
//注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
public class IsAnagramCheck032 {
    //抄近路解法1： 先判断是否相等,不相等再排序之后对比
    public boolean isAnagramEasy(String s, String t) {
        if(s.equals(t)){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        //记得不能直接.equals()
        return Arrays.equals(chars,chars1);
    }
    //手搓解法1： 笨比法,把每个字母的出现次序存起来 之后对比
    //不太行 还要判断字符顺序是否相同
    public boolean isAnagram(String s, String t) {
        //因为需要判断字符顺序是否相同,所以先判断两个string是否相等
        if(s.equals(t)){
            return false;
        }
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            charCount[c - 'a'] -- ;
        }
        for (int i : charCount) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
}
