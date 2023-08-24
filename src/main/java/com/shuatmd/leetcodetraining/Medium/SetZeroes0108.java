package com.shuatmd.leetcodetraining.Medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//面试题 01.08. 零矩阵
//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
public class SetZeroes0108 {
    //简易解法1： 标记
    //手搓解法尝试1：暴力+遍历
    //用pair记录为0的数的index
    //直接根据index进行变为0的处理
    public void setZeroes(int[][] matrix) {
        List<Pair<Integer, Integer>> indexPairList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    Pair<Integer, Integer> indexPair = new Pair<>(i, j);
                    indexPairList.add(indexPair);
                }
            }
        }
        Set<Integer> keySet = new HashSet<>();
        Set<Integer> valueSet = new HashSet<>();
        for (Pair<Integer, Integer> indexPair : indexPairList) {
            Integer key = indexPair.getKey();
            Integer value = indexPair.getValue();
            //使用set来判断如果当前行/列已经归0过则不需要再次操作
            if (keySet.add(key)) {
                for (int i = 0; i < matrix[key].length; i++) {
                    matrix[key][i] = 0;
                }
            }
            if (valueSet.add(value)) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][value] = 0;
                }
            }
        }
    }
}
