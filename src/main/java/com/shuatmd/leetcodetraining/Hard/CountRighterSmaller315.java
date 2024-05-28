package com.shuatmd.leetcodetraining.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//315. 计算右侧小于当前元素的个数
//给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
//https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
public class CountRighterSmaller315 {
    //手搓解法2： 归并排序
    //参考ReversePairsInArray51 使用归并排序来处理
    //不同点是LCR170或者51题中求得是最后的sum 而本体需要返回一个精确地数组

    int[] tmp;
    int[] record;
    int[] res;
    int[] index;
    public List<Integer> countSmallerMerge(int[] nums) {
        this.tmp = new int[nums.length];
        this.record = nums;
        this.res = new int[nums.length];
        this.index = new int[nums.length];
        mergeSort(0,record.length-1);
        List<Integer> result = new ArrayList<>();
        for (int re : res) {
            result.add(re);
        }
        return result;
    }

    private void mergeSort(int l, int r) {
        if(l >= r){
            return ;
        }
        //根据当前l以及r算出重点m
        int m = (l + r)/2;
        //i 代表左半边数组的指针
        int i = l;
        //j 代表右半边数组的指针
        int j = m + 1;
        mergeSort(i, m);
        mergeSort(m + 1, r);
        //将当前的两段数组加入到tmp数组之中
        for (int k = l; k <= r ; k++) {
            tmp[k] = record[k];
        }
        //对当前分段的数据进行遍历
        for (int k = l; k <= r ; k++) {
            //如果i大于m 表示左边指针已经走完,需要将右边没走完的部分
            if(i == m + 1 ){
                record[k] = tmp[j];
                j++;
            } else if (j ==r + 1 || tmp[j] >= tmp[i] ) {
                record[k] = tmp[i];
                i++;
            }
            else{
                record[k] = tmp[j];
                j++;
                res[record[k]] += m - i + 1;
            }
        }

    }

    //手搓解法:暴力双循环 会超时
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int curr = nums[i];
            for (int j = i; j < nums.length; j++) {
                if(nums[j] < curr){
                    count++;
                }
            }
            resList.add(count);
        }
        return resList;
    }


    public static void main(String[] args) {
        CountRighterSmaller315 count = new CountRighterSmaller315();
        count.countSmallerMerge(new int[]{5,2,6,1});
    }

}
