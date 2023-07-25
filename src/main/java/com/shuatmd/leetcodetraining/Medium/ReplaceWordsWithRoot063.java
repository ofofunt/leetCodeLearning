package com.shuatmd.leetcodetraining.Medium;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//剑指 Offer II 063. 替换单词
//在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
//
//现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
//
//需要输出替换之后的句子。
public class ReplaceWordsWithRoot063 {
    //官方推荐解法1： 用HashSet来做
    public String replaceWordsOfficial1(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        for (String s : dictionary) {
            set.add(s);
        }
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            for (int j = 0; j < s1.length(); j++) {
                if (set.contains(s1.substring(0, 1 + j))) {
                    s[i] = s1.substring(0, 1 + j);
                    break;
                }
            }
        }
        return String.join(" ", s);
    }

    //手搓解法1：尝试用List + Stream来做
    public String replaceWordsByHand(List<String> dictionary, String sentence) {
        String[] s = sentence.split(" ");
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (int i = 0; i < s.length; i++) {
            for (String s2 : dictionary) {
                if (s[i].startsWith(s2)) {
                    s[i] = s2;
                    break;
                }
            }
        }
        String res = "";
        for (String s1 : s) {
            res = res + s1 + " ";
        }
        return res.trim();
    }

}
