package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//剑指 Offer 61. 扑克牌中的顺子
//从若干副扑克牌中随机抽 5 张牌，
// 判断是不是一个顺子，
// 即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
public class PokerStraight61 {
    //官方解法1:使用set+遍历来做
    //判断是否是顺子的依据: 不存在重复数 && 最大数减去最小数小于5
    public boolean isStraightOfficial(int[] nums) {
        Set<Integer> repeatSet = new HashSet<>();
        int min = 14;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前数字是0则跳过
            if(nums[i] == 0){
                continue;
            }
            if(repeatSet.contains(nums[i])){
                return false;
            }
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
            repeatSet.add(nums[i]);
        }
        return max - min < 5;
    }
    //自己手写的解法:存在很多问题
    //1. 需要排序+遍历 实际上并不需要排序 只需要记录最高值最低值
    //2. 判断过于麻烦
    public boolean isStraight(int[] nums) {
        int zeroes = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == 0){
                zeroes ++;
            }
            else if(nums[i] < nums[i+1] -1){
                zeroes -= nums[i + 1] - nums[i] - 1;
            }
            else if(nums[i] == nums[i + 1]){
                zeroes = -99;
            }
        }
        return zeroes>=0;
    }
}
