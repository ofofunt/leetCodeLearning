package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

public class MultiplierMatrix66 {
    //解法1： 分表相乘
    //将乘积分为左右两边,迭代计算左边和右边就能求出成绩结果
    public int[] constructArr(int[] a) {
        if(a.length == 0){
            return new int[0];
        }
        int[] result = new int[a.length];
        int tmp = 1;
        result[0] = 1;
        //先得到左边部分的乘积
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * a[i - 1];
        }
        //再从右边开始乘
        for (int i = result.length; i > 0; i--) {
            result[i - 1] *= tmp;
            tmp *= a[i - 1];
        }
        return result;
    }
}
