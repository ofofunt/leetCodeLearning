package com.shuatmd.leetcodetraining.Easy;

//面试题 05.02. 二进制数转字符串
//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
//https://leetcode.cn/problems/binary-number-to-string-lcci/
public class DoubleToBinary0502 {
    //手搓尝试：循环 判断给定数是否大于等于当前的位数
    public String printBin(double num) {
        double curr = 0.5;
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        for (int i = 0; i < 32; i++) {
            if (num == 0.0) {
                return sb.toString();
            }
            if (num >= curr) {
                num -= curr;
                sb.append("1");
            } else {
                sb.append("0");
            }
            curr /= 2;
        }
        return "ERROR";
    }
}
