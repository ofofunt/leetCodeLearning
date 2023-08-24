package com.shuatmd.leetcodetraining.Medium;

//面试题 01.05. 一次编辑
//字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
public class OneEditAway0105 {
    //分类讨论法1
    //当两个string长度差超过1 返回false
    //当两个string长度相等,判断2个string是否character之间的差距只有一个
    //当2个string长度相差1,判断两个string的差距是否只有1个
    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        //当长度差距为1 单独判断
        if (m - n == 1) {
            return oneEditCheck(second, first);
        } else if (n - m == 1) {
            return oneEditCheck(first, second);
        }
        //当长度相等 直接判断是否只有一个character的差距
        else if (m == n) {
            int index = 0;
            int diffCount = 0;
            while (index < m) {
                if (first.charAt(index) != second.charAt(index)) {
                    diffCount++;
                }
                if (diffCount > 1) {
                    return false;
                }
                index++;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean oneEditCheck(String shortStr, String longStr) {
        int shortLength = shortStr.length();
        int longLength = longStr.length();
        int indexShort = 0;
        int indexLong = 0;
        //双指针判断,判断是否index间的区别只有1
        while (indexShort < shortLength && indexLong < longLength) {
            if (shortStr.charAt(indexShort) == longStr.charAt(indexLong)) {
                indexShort++;
            }
            indexLong++;
            if (indexLong - indexShort > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneEditAway0105 oneEditAway0105 = new OneEditAway0105();
        oneEditAway0105.oneEditAway("intention", "execution");
    }
}
