package com.shuatmd.leetcodetraining.Medium;

//剑指 Offer 46. 把数字翻译成字符串
//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
// 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
public class TranslateNumIntoChar46 {
    //通过dp实现
    //当前第n位数字的翻译方法总数取决于n-2,n-1两位数字
    //如果xn-2 xn-1可以整体翻译成一个字母,则翻译方法总数 = f(n-2) + f(n-1)
    //如果无法合在一起翻译,则翻译总数与f(n-1)相等
    public int translateNum(int num) {
        //初始化a b 为f(1) f(0)的值
        int a = 1;
        int b = 1;
        char[] c = String.valueOf(num).toCharArray();
        for (int i = 2; i <= c.length; i++) {
            //判断前两位数凑起来是否大于26 如果是代表无法有多种翻译结果 当前的结果还是等于f(n-1)
            //如果小于26代表存在多种翻译结果 f(n) = f(n-2) + f(n-1)
            //*注意* ： 需要判断n-2位是否为0
            int d = 10 * Character.getNumericValue(c[i - 2]) + Character.getNumericValue(c[i - 1]) < 26 &&
                    Character.getNumericValue(c[i - 2]) > 0 ?
                    a + b : a;
            b = a;
            a = d;
        }
        return a;

    }

}
