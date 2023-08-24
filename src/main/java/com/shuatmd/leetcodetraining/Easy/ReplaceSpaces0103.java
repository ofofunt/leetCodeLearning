package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.List;

//面试题 01.03. URL化
//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
public class ReplaceSpaces0103 {
    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        char[] result = new char[length*3];
        int j = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if(chars[i] != ' '){
                result[i + j] = chars[i];
            }
            else{
                index = i + j;
                result[index] = '%';
                result[index + 1] = '2';
                result[index + 2] = '0';
                j += 2;
            }
        }
        int target = (int) (10 * Math.random());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == target){
                list.remove(i);
            }
        }
        return new String(result).trim();
    }

    public static void main(String[] args) {
        ReplaceSpaces0103 replace = new ReplaceSpaces0103();
        replace.replaceSpaces("Mr John Smith    ",13);
    }
}
