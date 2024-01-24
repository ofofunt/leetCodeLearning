package com.shuatmd.leetcodetraining.Medium;
//面试题 08.07. 无重复字符串的排列组合
//无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
//https://leetcode.cn/problems/permutation-i-lcci/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation0807 {
    StringBuffer sb = new StringBuffer();
    List<String> res = new ArrayList<>();

    //官方解法1： 回溯 + 交换法
    //优点：不需要List<Characters>或者StringBuffer 同时也不需要判断重复添加的问题 不用contains判断
    //https://leetcode.cn/problems/permutation-i-lcci/solutions/406850/quan-pai-lie-jiao-huan-fa-qing-xi-tu-shi-by-chen-k/
    //详细解析
    public String[] permutationOfficial(String S) {
        char[] chars = S.toCharArray();
        dfs(chars, 0);
        return res.toArray(new String[]{});
    }

    private void dfs(char[] chars, int k) {
        if (k == chars.length) {
            res.add(new String(chars));
        }
        for (int i = k; i < chars.length; i++) {
            swap(chars, i, k);
            dfs(chars, k + 1);
            swap(chars, k, i);
        }
    }

    private void swap(char[] chars, int i, int k) {
        char tmp = chars[i];
        chars[i] = chars[k];
        chars[k] = tmp;
    }

    //突然想起来的解法：回溯 使用StringBuilder来进行结果拼接, 用boolean[]来判断是否重复
    public String[] permutation3(String S) {
        char[] chars = S.toCharArray();
        boolean[] used = new boolean[chars.length];
        StringBuilder sb = new StringBuilder();
        dfsWithArray(used, chars, sb);
        return res.toArray(new String[0]);
    }

    private void dfsWithArray(boolean[] used, char[] chars, StringBuilder sb) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            sb.append(chars[i]);
            used[i] = true;
            dfsWithArray(used, chars, sb);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    //手搓尝试2：用StringBuffer替换掉繁琐的List<Characters>
    //优化下转换的时间
    //手搓尝试1：使用回溯来解决
    //可以考虑优化的点：用list是不是性能太低,是否可以直接用array不进行转换
    public String[] permutation2(String S) {
        backtrack2(res, sb, S);
        return res.toArray(new String[]{});
    }

    private void backtrack2(List<String> res, StringBuffer sb, String s) {
        String tmp = new String(sb);
        if (sb.length() == s.length()) {
            res.add(tmp);
        }
        for (int i = 0; i < s.length(); i++) {
            if (tmp.contains(s.charAt(i) + "")) {
                continue;
            }
            sb.append(s.charAt(i));
            backtrack2(res, sb, s);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        List<Character> tmp = new ArrayList<>();
        List<String> res = new ArrayList<>();
        //tmp可以考虑用stringBuffer来做 效率会高一点
        backtrack(chars, tmp, res);
        return res.toArray(new String[]{});
    }

    private void backtrack(char[] chars, List<Character> tmp, List<String> res) {
        if (tmp.size() == chars.length) {
            res.add(tmp.stream().map(Object::toString).collect(Collectors.joining()));
        }
        for (int i = 0; i < chars.length; i++) {
            if (tmp.contains(chars[i])) {
                continue;
            }
            tmp.add(chars[i]);
            backtrack(chars, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutation0807 permutation = new Permutation0807();
        permutation.permutation("qwe");
    }
}
