package com.shuatmd.leetcodetraining.Medium;
//剑指 Offer 67. 把字符串转换成整数
//写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
//
//
//
//首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
//
//当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
//
//该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
//
//注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
//
//在任何情况下，若函数不能进行有效的转换时，请返回 0。
//
//说明：
//
//假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
public class StrToInt67 {
    //本体难点1：需要记录加减符号
    //本体难点2：需要当结果是integer.MaxValue时及时返回
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        int sign = 1;
        int i = 1;
        int bound = Integer.MAX_VALUE / 10;
        int res = 0;
        if(chars.length == 0){
            return 0;
        }
        //记录正负符号
        //如果有加减号 记录下加减号
        //如果没有加减号, 则将index重置为0
        if(chars[0] == '-'){
            sign = -1;
        }
        else if (chars[0] != '+'){
            i = 0;
        }
        for (int j = i; j < chars.length; j++) {
            //判断如果有非数字字符,则停止
            if(chars[j] < '0' || chars[j] > '9'){
                break;
            }
            //判断 如果当前res已经大于bound且还存在下一位, 则他一定会大于integer.MaxValue 直接根据sign来返回最大值最小值
            //    如果当前res等于bound 且当前char大于7 则说明也会超过最大上限 直接根据sign返回最大值或最小值
            if(res > bound|| (res == bound && chars[j] > '7')){
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //没有超过最大,则res为之前的和*10加上当前位数的值
                res = res*10 + (chars[j] - '0');
        }
        return sign * res;
    }
}
