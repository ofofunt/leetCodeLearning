package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//面试题 10.02. 变位词组
//编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
//https://leetcode.cn/problems/group-anagrams-lcci/
public class GroupAnagrams1002 {
    //官方解答2: 同样适用HashMap来记录同位词的List 但是用array来记录同位词
    public List<List<String>> groupAnagramsOfficial2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append(i);
            }
            //改为使用使用array来记录单词个数
            List<String> anagramList = map.getOrDefault(sb.toString(), new ArrayList<>());
            anagramList.add(str);
            map.put(sb.toString(), anagramList);
        }
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }

    //官方解答1： 通过Hash来判断是否为换位词
    public List<List<String>> groupAnagramsOfficial(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            //使用sort之后的string作为key,同位次sort之后的string一定是相同的
            //也可以考虑使用array来记录单词个数
            Arrays.sort(chars);
            List<String> anagramList = map.getOrDefault(new String(chars), new ArrayList<>());
            anagramList.add(str);
            map.put(new String(chars), anagramList);
        }
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;

    }


    //手搓解法1：通过charArray sort之后判断两个是否相等
    //缺点：时间需求太高 外层本来就是n^2的循环 内部还需要2个sort来判断
    //换位词可以用char的个数来判断
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == "checked") {
                continue;
            }
            List<String> anagramList = new ArrayList<>();
            anagramList.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (checkIfAnagrams(strs[i], strs[j])) {
                    anagramList.add(strs[j]);
                    strs[j] = "checked";
                }
            }
            res.add(anagramList);
        }
        return res;
    }

    public Boolean checkIfAnagrams(String a, String b) {
        char[] charsA = a.toCharArray();
        Arrays.sort(charsA);
        char[] charsB = b.toCharArray();
        Arrays.sort(charsB);
        return Arrays.equals(charsA, charsB);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams1002 group = new GroupAnagrams1002();
        group.groupAnagramsOfficial(strs);
    }
}
