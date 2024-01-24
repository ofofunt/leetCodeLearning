package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;

//面试题 08.04. 幂集
//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
//
//说明：解集不能包含重复的子集。
//https://leetcode.cn/problems/power-set-lcci/
public class Subsets0804 {

    //官方解法1： 回溯算法
    //枚举取不同值大部分时间都需要用回溯结局
    //假设现在的int[]是{1,2,3}
    //我们通过dfs一个n叉数来进行解决
    //            []
    //    1       2       3
    //  2   3     3
    //  3
    public List<List<Integer>> subsetsBackTracking(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //通过回溯来组装最后的reslist
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        //终止条件可以忽略
//        if(start > nums.length){
//            return;
//        }
        //每次循环先将dfs当前的路径添加到res中
        res.add(new ArrayList<>(tmp));
        //i从start开始而不是从0开始,防止出现重复的情况
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, i + 1);
            //remove list中的最后一位 防止分支污染
            tmp.remove(tmp.size() - 1);
        }

    }

    //取巧解法1：循环解法
    //举例 假设现在的List为[1,2,3]
    //第一步: 首先在result中添加一个空集[] result: []
    //第二步: 循环到第一位 1 往result中添加一个1 result: [],[1]
    //第二步: 循环到第二位 2 往result中依次添加2 result: [],[1],[2],[1,2]
    //第三步: 循环到第三位 3 往result中依次添加3 result: [],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            //为了防止size不断变大 无限循环 需要提前取出res的size
            int j = res.size();
            for (int i = 0; i < j; i++) {
                //注意一定要new一个新的ArrayList来复制值 不然修改tmp会同样影响到res
                //需要保持tmp对象独立于res
                List<Integer> tmp = new ArrayList<>(res.get(i));
                tmp.add(num);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Subsets0804 subset = new Subsets0804();
        subset.subsets(new int[]{1, 2, 3});
    }
}
