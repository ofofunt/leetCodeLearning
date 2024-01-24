package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestSeqAtIndex1708 {
    //手搓解法尝试1： 将height weight通过map来建立一对一关联
    //之后将height sort之后 生成对应的weight的array
    //循环sort之后的height并且保持height与weight同样处于递增状态
    //理解出现问题 并不是直接求连续保持递增的子数列 而是求可以保持递增的子数列
    public int bestSeqAtIndex(int[] height, int[] weight) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < height.length; i++) {
            map.put(height[i],weight[i]);
        }
        int[] sortedHeight = Arrays.copyOf(height,height.length);
        Arrays.sort(sortedHeight);
        int[] sortedWeight = new int[weight.length];
        for (int i = 0; i < sortedWeight.length; i++) {
            sortedWeight[i] = map.get(sortedHeight[i]);
        }
        int maxLength = 0;
        int curLength = 1;
        for (int i = 0; i < sortedHeight.length; i++) {
            if(i < sortedWeight.length - 1 && sortedWeight[i] < sortedWeight[i + 1]){
                curLength++;
            }
            else {
                if(curLength > maxLength){
                    maxLength = curLength;
                }
                curLength = 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        BestSeqAtIndex1708 test = new BestSeqAtIndex1708();
        test.bestSeqAtIndex(new int[]{2868,5485,1356,1306,6017,8941,7535,4941,6331,6181}, new int[]{5042,3995,7985,1651,5991,7036,9391,428,7561,8594});
    }
}
