package com.shuatmd.leetcodetraining.Medium;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer 48. 最长不含重复字符的子字符串
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
public class LengthOfLongestSubstring48 {
    //用dp+hanshMap实现
    //dp[j] 代表*结尾*为s[j]的最大不含重复字符的子字符串, 固定右边界为j, s[i]代表左边距离s[j]距离最近的相同字符
    //当 i < 0 则代表不存在重复的字符 dp[j] = dp[j - 1] + 1
    //dp[j - 1] >= j - i,说明s[i]在dp[j-1]这个字符串当中,左边界需要变为i,最大长度变为j-1
    //dp[j - 1] < j - i,说明s[i]在dp[j-1]这个字符串当外,既当前这个字符串中其实并没有包含s[j], dp[j] = dp[j - 1] + 1

    //举例：       a b c d b a a
    //index:      0 1 2 3 4 5 6
    //当j = 4时, i = 2, j - i = 2 < dp[3] = 4 得出结论s[4]的结尾b的最左重复字母s[2]在目前的最长substring中,需要重新修改长度
    //dp[4] = 4 - 1 = 3 最长字符为c b d
    //当j = 5时, i = 0, j - i = 5 > dp[4] = 3 得出结论s[5]的结尾a的最左重复字母s[0]不在目前的最长substring中,可以直接添加进来
    //dp[5] = dp[3] + 1 = 4 最长字符为c b d a 

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int j;
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < chars.length; i++) {
            j = map.getOrDefault(chars[i], -1);
            if (tmp < i - j) {
                tmp += 1;
            } else {
                tmp = i - j;
            }
            res = Math.max(res, tmp);
            map.put(chars[i], i);
        }
        return res;
    }
}
