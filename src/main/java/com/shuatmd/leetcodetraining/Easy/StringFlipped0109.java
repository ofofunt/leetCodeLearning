package com.shuatmd.leetcodetraining.Easy;

//面试题 01.09. 字符串轮转
//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
public class StringFlipped0109 {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {
        StringFlipped0109 stringFlipped0109 = new StringFlipped0109();
        stringFlipped0109.isFlipedString("waterbottle", "erbottlewat");
    }
}
