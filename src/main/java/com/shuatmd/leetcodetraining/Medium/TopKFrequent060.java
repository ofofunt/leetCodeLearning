package com.shuatmd.leetcodetraining.Medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-19 14:32
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 060. 出现频率最高的 k 个数字
//给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
public class TopKFrequent060 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[k];
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
                .sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed()).limit(k).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            result[i] = collect.get(i).getKey();
        }
        return result;
    }
}
