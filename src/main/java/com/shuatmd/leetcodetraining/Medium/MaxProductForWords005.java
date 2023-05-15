package com.shuatmd.leetcodetraining.Medium;

public class MaxProductForWords005 {
    //暴力解法： 双循环+判断是否包含重复字母 会超时
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (!containsWord(words[i], words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    //优化查找重复
    //用掩码来记录字母在word1中是否出现,如果出现过字母则将其变为1
    //遍历word2中的每个character,当掩码为1时说明在word1和word2之中都有出现
    //优化之后的效率O(m + m)
    private boolean containsWordCoverCode(String word, String word1) {
        //因为字母都为小写字母,所以总共最多只有26个可能性
        int[] coverCode = new int[26];
        for (char c : word.toCharArray()) {
            coverCode[c - 'a'] = 1;
        }
        //判断word2中的字母是否在word1中也存在
        for (char c : word1.toCharArray()) {
            if (coverCode[c - 'a'] == 1) {
                return true;
            }
        }
        return false;
    }

    //优化上面的解法,使用bit[]来记录字母是否出现 比int节约空间
    //当字母在word1中出现的时候,将1左移字母 - ‘a’位,之后再与bit[]做或操作来更新当前的bit[]
    //用 & 来计算两个word对应的bit[]是否为0,如果为0说明没有出现过重复的字母
    //时间复杂度降低为O(m)
    private boolean containsWordCoverCode2(String word, String word1) {
        int bitMask1 = 0;
        int bitMask2 = 0;
        for (char c : word.toCharArray()) {
            bitMask1 |= (1 << (c - 'a'));
        }
        for (char c : word1.toCharArray()) {
            bitMask2 |= (1 << (c - 'a'));
        }
        return (bitMask1 & bitMask2) != 0;
    }

    //双遍历查找是否包含重复字母, 时间复杂度O(m^2)
    private boolean containsWord(String word, String word1) {
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if (word1.indexOf(aChar) > -1) {
                return true;
            }
        }
        return false;
    }


}
