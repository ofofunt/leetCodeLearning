package com.shuatmd.leetcodetraining.Medium;
//面试题 16.09. 运算
//请实现整数数字的乘法、减法和除法运算，运算结果均为整数数字，程序中只允许使用加法运算符和逻辑运算符，允许程序中出现正负常数，不允许使用位运算。
//
//你的实现应该支持如下操作：
//
//Operations() 构造函数
//minus(a, b) 减法，返回a - b
//multiply(a, b) 乘法，返回a * b
//divide(a, b) 除法，返回a / b

public class Operations1909 {
    //太难了 直接搬官方解法
    //首先获取-1
    int ne = Integer.MAX_VALUE + Integer.MAX_VALUE + 1;
    int pe = 1;
    //负数序列,记录-1 -2 -4 -8 -16
    long[] neCache = new long[32];
    //正数序列,记录1 2 4 8 16
    long[] peCache = new long[32];
    //存储乘数的正倍数 1*a 2*a 4*a ...
    long[] cache = new long[32];
    //存储乘数的负倍数 -1*a -2*a -4*a ...
    long[] cache1 = new long[32];

    public Operations1909() {
        neCache[0] = ne;
        peCache[0] = 1;
        //初始化好两个序列
        for (int i = 1; i < 32; i++) {
            neCache[i] = neCache[i + ne] + neCache[i + ne];
            peCache[i] = peCache[i + ne] + peCache[i + ne];
        }

    }

    //相减的逻辑：a与b一起从序列最高位的数中开始减
    //如果b小于0 则a与b一起加直到b等于0时 返回a的值
    public int minus(int a, int b) {
        if (a == b) {
            return 0;
        }
        //从最高位开始减
        int index = 31;
        while (b != 0) {
            if (b > 0) {
                if (b >= peCache[index]) {
                    b += neCache[index];
                    a += neCache[index];
                } else {
                    index += ne;
                }
            } else {
                if (b <= neCache[index]) {
                    b += peCache[index];
                    a += peCache[index];
                } else {
                    index += ne;
                }
            }
        }
        return a;
    }

    //先分类讨论,然后循环递增
    public int multiply(int a, int b) {
        //分类讨论a b 为0 1 或者-1
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == 1) {
            return b;
        }
        if (b == 1) {
            return a;
        }
        if (a == ne) {
            return minus(0, b);
        }
        if (b == ne) {
            return minus(0, a);
        }
        int index = 30;
        int ret = 0;
        //记录计算符号
        int sign = (a > 0 && b > 0) || (a < 0 && b < 0) ? 1 : ne;
        //将b变为正数
        if (b < 0) {
            b = minus(0, b);
        }
        cache[0] = a;
        //初始化a的乘数序列
        for (int i = 1; i < 32; i++) {
            cache[i] = cache[i + ne] + cache[i + ne];
        }
        int retSign = a > 0 ? 1 : ne;
        while (b > 0) {
            if (b >= peCache[index]) {
                b += neCache[index];
                ret += cache[index];
                retSign = ret > 0 ? 1 : ne;
            }
        }
        //当最后的retSign与sign相反,说明需要修改符号
        if ((sign < 0 && retSign > 0) || (sign > 0 && retSign < 0)) {
            ret = minus(0, ret);
        }
        //检查是否存在乘积溢出的情况
        if (retSign != (a > 0 ? 1 : ne)) {
            ret = minus(0, ret);
        }
        return ret;
    }

    public int divide(int a, int b) {
        if (a == 0) return 0;
        if (b == 1) return a;
        if (b == ne) return minus(0, a);
        int ret = 0;
        int sign = (a > 0 && b > 0) || (a < 0 && b < 0) ? 1 : ne;
        long nb = b;
        long pb = b;
        if (b < 0) {
            b = minus(0, b);
        } else {
            nb = minus(0, b);
        }
        if (a < 0) {
            a = minus(0, a);
        }
        cache[0] = b;
        cache1[0] = nb;
        int index = 1;
        for (; index < 32; ++index) {
            cache[index] = cache[index + ne] + cache[index + ne];
            cache1[index] = cache1[index + ne] + cache1[index + ne];
            if (cache1[index] >= a) {
                break; // 找到最大值就可以返回了，不用计算完
            }
        }
        if (index >= 32) index = 31;
        while (a >= b) {
            if (a >= cache[index]) {
                ret += peCache[index];// 注意这里是2的index次方的值
                a += cache1[index];
            } else {
                index += ne;
            }
        }
        if (sign < 0) {
            ret = minus(0, ret);
        }
        return ret;
    }
}
