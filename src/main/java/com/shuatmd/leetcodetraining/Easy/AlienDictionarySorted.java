package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-08 16:21
 * @Description: TODO
 * @Version: I.0
 */


//剑指 Offer II 034. 外星语言是否排序
//某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
//
//给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
//
//
public class AlienDictionarySorted {
    //官方解法1：不用map,使用Array来记录排序,之后遍历
    public boolean isAlienSortedOfficial(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.toCharArray().length; i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        Boolean valid = false;
        for (int i = 1; i < words.length; i++) {
            char[] prev = words[i -1].toCharArray();
            char[] curr = words[i].toCharArray();
                for (int r = 0; r < prev.length && r < curr.length; r++) {
                    if(index[prev[r] - 'a'] < index[curr[r] - 'a']){
                        valid = true;
                        break;
                    }
                    else if(index[prev[r] - 'a'] > index[curr[r] - 'a']){
                        return false;
                    }
                }
                if(!valid){
                    if (words[i - 1].length() > words[i].length()) {
                        return false;
                    }
                }
            }
        return true;
    }
    //手搓解法1： 思路 将字典丢到map中 然后双指针判断从左到右是否是字母升序（字典顺序）
    //缺点：太过于磨叽 遍历其实并不需要双指针 直接i-1 和i比就好了
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length < 2){
            return true;
        }
        //用一个map来储存
        Map<Character,Integer> dictionaryMap = new HashMap<>();
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            dictionaryMap.put(chars[i], i);
        }
        int i = 0;
        int j = 1;
        while(j < words.length) {
            if(!checkIfOrdered(dictionaryMap, words[i],words[j])){
                return false;
            }
            i ++;
            j ++;
        }
        return true;
    }

    private static boolean checkIfOrdered(Map<Character, Integer> dictionaryMap, String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        for (int j = 0; j < chars1.length; j++) {
            if(chars2.length - 1 < j ){
                return false;
            }
            if(dictionaryMap.get(chars1[j]) - dictionaryMap.get(chars2[j]) < 0){
               break;
            }
            else{
                if(dictionaryMap.get(chars1[j]) - dictionaryMap.get(chars2[j]) > 0){
                    return false;
                }
            }
        }
        return true;
    }

}
