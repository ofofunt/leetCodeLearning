package com.shuatmd.leetcodetraining.Medium;

import java.util.HashMap;
import java.util.Map;

//面试题 17.05. 字母与数字
//给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
//
//返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
//https://leetcode.cn/problems/find-longest-subarray-lcci/description/
public class FindLongestSubarray1705 {
    //官方解法1： 转换 + 前缀和
    //将字母的值转换为1 将数字的值转换为-1 如果当前subarray的sum为0 则说明字母与数字相等
    //通过前缀和来进行片段的求和, 查找当前遍历的点是否存在sum为0的subarray
    //查找到subarray后还需要判断当前subarray大小
    public String[] findLongestSubarray(String[] array) {
        int startIndex = -1;
        //map key为和 value为index
        Map<Integer,Integer> map = new HashMap<>();
        //放入初始值
        map.put(0,-1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < array.length; i++) {
            //判断当前为字母则sum+1
            if(Character.isLetter(array[i].charAt(0))){
                sum ++;
            }
            //判断当前为数字则sum+1
            else{
                sum --;
            }
            //最后追求的目标是sum = 0 所以需要在map中寻找和sum值一样的index 这样能够保证index + 1 到当前点的subarray的sum为 sum -sum = 0
            if(map.containsKey(sum)){
                int firstIndex = map.get(sum);
                if(i - firstIndex > maxLength){
                    maxLength = i - firstIndex;
                    //记得要加1 因为是从index的后一位开始的subArray
                    startIndex = firstIndex + 1;
                }
            }
            else{
                map.put(sum,i);
            }
        }
        if(maxLength == 0){
            return new String[0];
        }
        String[] ans = new String[maxLength];
        System.arraycopy(array,startIndex,ans,0,maxLength);
        return ans;
    }
}
