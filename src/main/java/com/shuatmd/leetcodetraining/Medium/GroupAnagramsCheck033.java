package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-07 17:39
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 033. 变位词组
//给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
//
//注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
public class GroupAnagramsCheck033 {
    //官方推荐解法： 先排序,对比之后将结果放入map中
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Map<String, List<String>> resultMap = new HashMap<>();
        //将String中的每个元素 sort之后作为key去map中取
        //如果取不到则新建一个list 放入当前str
        //如果取得到,则将当前str加入到list中
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = resultMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            resultMap.put(key, list);
        }
        return new ArrayList<List<String>>(resultMap.values());
    }
}
