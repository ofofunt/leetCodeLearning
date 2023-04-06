package com.shuatmd.leetcodetraining.Medium;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer 56 - II. 数组中数字出现的次数 II
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
public class GetSingleNumberII56 {
    //解法1：用HashMap去重
    //使用map.getOrDefault可以不用进行判断是否当前数字已经存在
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }

    //解法2： 数字解法
    //三个一样的数字二进制相加之后一定可以被3整除 -> 把所有数字的二进制的数字相加的和每一位都除以3 余数就是只出现1次的数字
    //例子  1 2 2 2 3 3 3
    //二进制的和为
    //1 + 10 + 10 + 10 + 11 + 11 + 11 = 64
    // 6%3 = 0; 4%3 = 1 结果为 01 -》 1
    public int singleNumberOfficial(int[] nums) {
        int res = 0;
        //新建一个数组来记录所有数的位数的总和
        int[] counts = new int[32];
        for (int i = 0; i < nums.length; i++) {
            //循环获取并且叠加当前nums[i]的所有位数
            for (int j = 0; j < 32; j++) {
                //通过&1获得二进制最右一位的数字
                counts[j] += nums[i] & 1;
                //无符号右移操作,进位
                nums[i] >>>=1;
            }
        }
        //循环还原res
        int m = 3;
        for (int i = 0; i < counts.length; i++) {
            res <<= 1;
            res |= counts[31-i] % m;
        }
        return res;
    }

}
