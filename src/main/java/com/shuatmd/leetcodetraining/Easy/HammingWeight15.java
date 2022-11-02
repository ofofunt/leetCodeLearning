package com.shuatmd.leetcodetraining.Easy;

public class HammingWeight15 {
    //Solution1 : 逐位检查
    //通过使用 & 1 来判断当前int的二进制数字最后1位是否为1
    //通过>>>对当前数字进行无符号右移
    //当n = 0时表示循环结束
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res += n & 1;
            n = n>>>1;
        }
        return res;
    }

    //Solution2: 使用n & n -1来进行运算
    //n-1 会把n最右边的一位1变成0 1之后的0变成1
    //进行循环取反 直到n变为0
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;

    }

    public static void main(String[] args) {
        HammingWeight15 hammingWeight = new HammingWeight15();
        System.out.println(hammingWeight.hammingWeight(-3));
    }
}
