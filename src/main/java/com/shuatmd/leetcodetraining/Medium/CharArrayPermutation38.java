package com.shuatmd.leetcodetraining.Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//输入一个字符串，打印出该字符串中字符的所有排列。
//你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
public class CharArrayPermutation38 {
    char[] c;
    List<String> res = new LinkedList<>();
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        //如果x大于c的length-1 说明已经运行到倒数第一位,由于最后一位固定只有一种情况
        //将当前的c作为结果添加到list结果中
        if(x == c.length -1){
            //不能x >= c.length -1 会记录重复结果
            res.add(String.valueOf(c));
        }
        HashSet<Character> set = new HashSet<>();
        //
        for(int i= x; i < c.length; i++){
            //判断如果是在set中存在c[i],则表示已经有重复的排序,
            if(set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            swap(i,x);
            dfs(x+1);
            swap(x,i);
        }
    }

    private void swap(int i, int x) {
        char tmp = c[i];
        c[i] = c[x];
        c[x] = tmp;
    }

}
