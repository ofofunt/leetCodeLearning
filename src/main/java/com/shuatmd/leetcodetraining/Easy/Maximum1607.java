package com.shuatmd.leetcodetraining.Easy;

public class Maximum1607 {
    //手搓解法1： 用long来记录a-b的差 因为可能存在溢出问题
    //将差右移63位找到对应的符号 0对应正 -1对应负
    //最后结果为(k + 1) * a - k* b
    //当k为0时  说明a>b 结果为a
    //当k为-1时 说明a<b 结果为b
    public int maximum(int a, int b) {
        long dif = (long) a - (long) b;
        int k = (int) (dif >> 63);
        return (1 + k) * a - k * b;
    }
}
