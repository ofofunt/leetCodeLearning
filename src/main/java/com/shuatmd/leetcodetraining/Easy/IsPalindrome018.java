package com.shuatmd.leetcodetraining.Easy;

//剑指 Offer II 018. 有效的回文
//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
//
//本题中，将空字符串定义为有效的 回文串 。
public class IsPalindrome018 {
    //手搓解法3：双指针尝试
    //在原string上进行对比,如果当前指针不为数字or字母则跳过
    public boolean isPalindrome3(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if(l < r){
                if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                    return false;
                }
            }
            l ++;
            r --;
        }
        return true;
    }

    //手搓解法2：不用正则,直接通过StringBuffer拼接
    //判断str与str的reverse版本是否相等
    public boolean isPalindrome2(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String strReversed = new StringBuffer(sb).reverse().toString();
        return sb.toString().equals(strReversed);
    }

    //手搓解法1：暴力解法 会超时
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-z^A-Z^0-9]", "").toLowerCase();
        if (str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.toCharArray().length; i++) {
            if (!(str.charAt(i) == (str.charAt(str.length() - 1 - i)))) {
                return false;
            }
        }
        return true;
    }
}
