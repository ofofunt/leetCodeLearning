package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

//316. 去除重复字母
//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的
//字典序最小（要求不能打乱其他字符的相对位置）。
//https://leetcode.cn/problems/remove-duplicate-letters/
public class RemoveDuplicateLetters316 {
    //官方解法1： 栈 + 贪心做法
    /*
    难点主要集中在如何保持字典序最小上,通过贪心来做
    首先遍历整个字母串, 同时判断是否需要修改栈中的元素,
    判断的依据为：
    如果当前元素的字母顺序小于栈顶元素,且栈顶元素在之后还会出现,则清空栈顶元素,并且将当前元素放入栈内
     */
    public String removeDuplicateLetters(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> queue = new ArrayDeque<>();
        //new一个boolean数组来记录是否已经放入过栈中
        boolean[] visit =  new boolean[26];
        //new一个int数组来记录每个character的最后index
        int[] lastIndex = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }
        //遍历整个数组
        for (int i = 0; i < charArray.length; i++) {
            char cur = charArray[i];
            //如果已经放入过栈 则不需要重复放入
            if(visit[cur - 'a']){
                continue;
            }
            //因为判断会执行多次修改 所以要使用while
            //判断栈顶元素是否字母序大于当前元素 && 是否在序列之后任然会出现
            while(!queue.isEmpty() && queue.peekLast() > cur && lastIndex[queue.peekLast() - 'a'] > i){
                char top = queue.removeLast();
                visit[top - 'a'] = false;
            }
            queue.offer(cur);
            visit[cur - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : queue) {
            sb.append(character);
        }
        return sb.toString();
    }
}
