package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//面试题 08.09. 括号
//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
//
//说明：解集不能包含重复的子集。
//https://leetcode.cn/problems/bracket-lcci/
public class GenerateParenthesis0809 {
    List<String> res = new ArrayList<>();

    //官方解法：dfs + 有限树
    //通过左右括号的个数来进行判断,限制和剪枝的操作
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        StringBuilder sb = new StringBuilder();
        dfsWithCount(sb, left, right);
        return res;
    }

    private void dfsWithCount(StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        //如果可用的左括号的个数大于可用的右括号 说明已经不符合要求 不能构成一个合法的开闭括号
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfsWithCount(sb.append("("), left - 1, right);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right>0){
            dfsWithCount(sb.append(")"), left, right -1);
            sb.deleteCharAt(sb.length()-1);
        }

    }


    //手搓解法：简单回溯 + 统计开括号的个数
    //结果是对的但是超时 想一下有没有什么策略
    //可能需要剪枝
    //dfs做的太复杂 其实只要dfs(right)  dfs(left)就可以了

    public List<String> generateParenthesisHand(int n) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[]{'{', '}'};
        dfs(sb, count, n * 2, chars);
        return res.stream().distinct().collect(Collectors.toList());
    }

    private void dfs(StringBuilder sb, int count, int end, char[] chars) {
        if (sb.length() == end) {
            if (count == 0) {
                res.add(sb.toString());
            }
            return;
        }
        boolean addedLeft = false;
        for (int i = 0; i < end; i++) {
            if (count == 0) {
                sb.append(chars[0]);
                count++;
                addedLeft = true;
            } else {
                sb.append(chars[i % 2]);
                if (chars[i % 2] == '{') {
                    count++;
                } else {
                    count--;
                }
            }
            dfs(sb, count, end, chars);
            sb.deleteCharAt(sb.length() - 1);
            if (count == 1 && addedLeft) {
                count--;
            } else {
                if (chars[i % 2] == '{') {
                    count--;
                } else {
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis0809 generateParenthesis0809 = new GenerateParenthesis0809();
        generateParenthesis0809.generateParenthesis(3);
    }
}
