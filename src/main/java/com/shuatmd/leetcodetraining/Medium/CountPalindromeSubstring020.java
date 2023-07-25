package com.shuatmd.leetcodetraining.Medium;

public class CountPalindromeSubstring020 {
    //手搓解法2： 中心扩展法
    //假设当前串为aabaa 我们取中心位为第三位b b为回文 左右扩展 aba位回文 继续扩展 aabaa为回文
    //同时需要考虑子串为偶数的情况 所以中心位也需要取两位数
    //所有中心位的个数 = s.length() + s.length() -1
    public int countSubstringsCenter(String s) {
        int res = 0;
        int countSize = 2 * s.length() - 1;
        for (int i = 0; i <= countSize; i++) {
            //考虑奇偶情况
            int l = i > s.length() ? i - s.length() - 1: i;
            int r = i > s.length() ? l + 1 : l;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                res++;
                l--;
                r++;
            }
        }
        return res;
    }


    //手搓解法1 ： 遍历 + 动态规划
    //dp[i][j]代表s.substring(i,j)是否为一个回文串
    //dp[i][j] = s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1])
    //当s只有一位时, s[i] == s[j] 且 j - i< 2 一定为回文
    //当s有2位时, 判断s[i] 是否等于 s[j] 如果相等则说明是回文串
    //当s大于两位时, 判断左右两端是否相等, 如果相等则递归判断
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
