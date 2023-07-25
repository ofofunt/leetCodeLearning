package com.shuatmd.leetcodetraining.Easy;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-15 16:37
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 041. 滑动窗口的平均值
//给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
class MovingAverage041 {
    int[] arr = new int[10010];
    int n,sum,j,i;
    /** Initialize your data structure here. */
    public MovingAverage041(int size) {
        n = size;
    }

    public double next(int val) {
        sum +=arr[i++] = val;
        if(i - j >n){
            sum -= arr[j++];
        }
        return sum*1.0 / (i - j);
    }
}
