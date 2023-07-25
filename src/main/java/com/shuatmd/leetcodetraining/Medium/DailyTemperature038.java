package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-13 17:09
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 038. 每日温度
//请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
public class DailyTemperature038 {
    //官方解法：单调栈来做
    public int[] dailyTemperaturesBruteOfficial(int[] temperatures) {
        //new一个新的int[]来记录最后结果
        int[] ans = new int[temperatures.length];
        Stack<Integer> index = new Stack<>();
        //对temperature进行遍历, 将每个温度对应的角标放入栈中
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            //判断,当当前温度大于之前的温度时 需要将之前温度对应的下标出栈 并且记录下间隔的天数
            //举例 [73,74,75,71,69,72,76,73]
            // 当前温度  栈顶元素  ans
            // 73       0       0,0,0,0,0,0,0,0
            // 74       1       1,0,0,0,0,0,0,0  74 > 73 0出栈 ans[0] = 1 - 0
            // 75       2       1,1,0,0,0,0,0,0  75 > 74 1出栈 ans[1] = 2 - 1
            // 71       3       1,1,0,0,0,0,0,0  71 < 75 没有出栈
            // 69       4       1,1,0,0,0,0,0,0  69 < 71 没有出栈
            // 72       5       1,1,0,2,1,0,0,0  73 > 69 4出栈 ans[4] = 5 - 4 继续判断 72 > 71 3出栈 ans[3] = 5 - 3
            // 76       6       1,1,4,2,1,1,0,0  76 > 72 0出栈 ans[5] = 6 - 5 继续判断 76 > 74 2出栈 ans[2] = 6 - 2
            // 73       7       1,1,4,2,1,1,0,0
            while(!index.isEmpty() && temperature > temperatures[index.peek()]){
                Integer pop = index.pop();
                ans[pop] = i - pop;
            }
            index.push(i);
        }
        return ans;
    }
    //手搓解法2：暴力解法 用差来算其实多了一个步骤
    public int[] dailyTemperaturesBrute(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = length - 1; i >= 0; --i) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int t = temperatures[i] + 1; t <= 100; ++t) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            next[temperatures[i]] = i;
        }
        return ans;

    }
    //手搓解法： 先求出差, 根据差再来判断
    //缺点 太慢了 实际上是改善过得双循环 执行n^2次
    public int[] dailyTemperatures(int[] temperatures) {
        int[] diff = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            diff[i] = temperatures[i + 1] - temperatures[i];
        }
        diff[temperatures.length - 1] = 0;
        int[] result = new int[temperatures.length];
        for (int i = 0; i < diff.length - 1; i++) {
            if(diff[i] > 0){
                result[i] = 1;
            }
            else{
                int j = diff[i];
                int t = i + 1;
                while(j <= 0 && t < diff.length){
                    j += diff[t];
                    t ++;
                }
                if(t < diff.length) {
                    result[i] = t - i;
                }
                else{
                    result[i] = 0;
                }
            }
        }
        result[diff.length - 1] = 0;
        return result;
    }
}
