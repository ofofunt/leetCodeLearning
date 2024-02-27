package com.shuatmd.leetcodetraining.Easy;

import java.util.HashMap;
import java.util.Map;

//面试题 17.10. 主要元素
//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
//
//https://leetcode.cn/problems/find-majority-element-lcci/description/
public class FindMajorityElement1710 {


    //官方题解1：摩尔投票法
    //Boyer-Moore 投票算法的基本思想是：在每一轮投票过程中，从数组中删除两个不同的元素，直到投票过程无法继续，此时数组为空或者数组中剩下的元素都相等。
    //简单来说就是数字22抵消 如果一定存在主要元素 则最后剩下的或者中间相等的为主要元素
    //举例 1 5 2 5 3 5 5  1 5 /2 5 /3 5 都不相等 最后剩下来的5可能为主要数字
    //举例 1 5 5 5 3 4 5 最后剩下5
    public int majorityElementOfficial(int[] nums) {
        int half = nums.length/2;
        //记录是否存在相等的数字
        int count = 0;
        int candidate = -1;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                count = 1;
                candidate = nums[i];
            }
            else{
                count += candidate == nums[i]? 1 : -1;
            }
        }
        count = 0;
        //因为不确定是否一定存在主要元素 最后还需要对满足要求的数进行一次遍历
        for (int num : nums) {
            if(candidate == num){
                count ++;
            }
        }
        return count > half? candidate:-1;
    }


    //手搓解法： 顺序遍历数组一次 然后用HashMap记录出现次数 当出现超过len/2
    //缺陷： 属于蛮力求解
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2;
        for (int num : nums) {
            int curCount = map.getOrDefault(num, 0) + 1;
            if (curCount > half) {
                return num;
            }
            map.put(num, curCount);
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMajorityElement1710 test = new FindMajorityElement1710();
        test.majorityElement(new int[]{3, 2, 3});
    }
}
