package com.shuatmd.leetcodetraining.Easy;

//剑指 Offer II 019. 最多删除一个字符得到回文
//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
public class ValidPlaindromeDeleteOneChar019 {
    //手搓解法尝试1： 如果已经是回文,则返回true
    //如果不是回文,则需要判断删除1位字符能否得到回文字符串
    //判断方法： 模拟删除l或者删除r 只要两个子substring中存在一个为回文字符串则可以
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            //当第一次出现不相等时,判断两个子substring是否有一个为回文字符串
            if (s.charAt(l) != s.charAt(r)) {
                return validPalindrome(s, l + 1, r) || validPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean validPalindrome(String s, int low, int high) {
        //同样的比较逻辑
        //判断是否为回文串
        int l = low;
        int r = high;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
