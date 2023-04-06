package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer 57 - II. 和为s的连续正数序列
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
public class FindContinuousSequenceWithSumTarget57 {
    //解法1：用数学求和公式方法来求解
    //设int i,j为连续数组的左右边框
    //target = (i + j) * (j - i + 1) / 2
    //已知i的情况下可以根据一元二次求根定律（ax^2 + bx + c = 0 那个）推倒出j
    //遍历所有i的可能性 判断j是否为整数且是否小于i即可
    public int[][] findContinuousSequenceMath(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if(i < j && j == (int)j) {
                int[] ans = new int[(int)j - i + 1];
                for(int k = i; k <= (int)j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }
    //解法2：用滑动窗口来做
    //设int i,j为数组左右边框
    public int[][] findContinuousSequenceScrollWindow(int target) {
        //初始化
        int i = 1;
        int j = 2;
        int sum = 3;
        List<int[]> res = new ArrayList<>();
        //当i >= j时,说明找不到,跳出循环
        while(i < j){
            //判断如果target与当前sum相等,则将当前的数组整体添加进结果
            if(sum == target){
                int[] tmp = new int[j - i + 1];
                //循环获取当前的数组
                for (int k = i; k <= j ; k++) {
                    tmp[k - i] = k;
                }
                //更简单的stream写法
                //res.add(IntStream.rangeClosed(i, j).toArray());
                res.add(tmp);
                //右移左边框,一定记得要处理sum
                sum -= i;
                i += 1;
            }
            //判断如果当前和比target小,右移右边框
            else if(sum < target){
                j ++;
                sum+=j;
            }
            //判断如果当前和比target大,右移左边框
            else if(sum>target){
                sum -=i;
                i ++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
