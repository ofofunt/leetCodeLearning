package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.List;

//面试题 16.15. 珠玑妙算
//珠玑妙算游戏（the game of master mind）的玩法如下。
//
//计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
//
//给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
//https://leetcode.cn/problems/master-mind-lcci/description/
public class MasterMind1615 {
    //官方最优解1：
    //伪猜中次数 = 总猜中次数 - 真猜中次数
    public int[] masterMindOfficial(String solution, String guess) {
        char[] charGuess = guess.toCharArray();
        char[] solutionGuess = solution.toCharArray();
        int real = 0;
        int fake = 0;
        int[] count = new int[26];
        for (char c : solutionGuess) {
            count[c - 'A']++;
        }
        for (int i = 0; i < charGuess.length; i++) {
            if (charGuess[i] == solutionGuess[i]) {
                real++;
            }
            if (count[charGuess[i] - 'A'] > 0) {
                fake++;
                count[charGuess[i] - 'A']--;
            }
        }
        return new int[]{real, fake - real};
    }

    //手搓尝试2：还是先判断猜中的次数 然后再判断伪猜中
    //已经很快 但是思维还能优化
    public int[] masterMind2(String solution, String guess) {
        char[] charGuess = guess.toCharArray();
        char[] solutionGuess = solution.toCharArray();
        int[] ans = new int[2];
        int[] count = new int[26];
        for (char c : solutionGuess) {
            count[c - 'A']++;
        }
        for (int i = 0; i < charGuess.length; i++) {
            if (charGuess[i] == solutionGuess[i]) {
                ans[0]++;
                count[charGuess[i] - 'A']--;
                charGuess[i] = ' ';
            }
        }
        for (char c : charGuess) {
            if (c != ' ' && count[c - 'A'] > 0) {
                ans[1]++;
                count[c - 'A']--;
            }
        }
        return ans;
    }

    //手搓尝试1：先判断猜中的次数,然后剔除掉猜中的部分判断微猜中
    //效率太低了 很慢 换一个尝试
    public int[] masterMind(String solution, String guess) {
        char[] charGuess = guess.toCharArray();
        char[] solutionGuess = solution.toCharArray();
        int[] ans = new int[2];
        List<Character> correct = new ArrayList<>();
        for (int i = 0; i < charGuess.length; i++) {
            if (charGuess[i] == solutionGuess[i]) {
                ans[0]++;
                solution = solution.replaceFirst(String.valueOf(charGuess[i]), "");
                charGuess[i] = ' ';
            }
        }
        for (char c : charGuess) {
            if (c != ' ' && solution.indexOf(c) > -1) {
                ans[1]++;
                solution = solution.replaceFirst(String.valueOf(c), "");
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MasterMind1615 mind = new MasterMind1615();
        mind.masterMind2("GGBB", "RBYB");
    }
}
