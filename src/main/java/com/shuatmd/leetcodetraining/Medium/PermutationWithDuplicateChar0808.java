package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;

//面试题 08.08. 有重复字符串的排列组合
//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
//https://leetcode.cn/problems/permutation-ii-lcci/solutions/327582/jing-dian-hui-su-mei-ti-qian-jiang-qi-pai-xu-by-sc/
public class PermutationWithDuplicateChar0808 {


    List<String> res = new ArrayList<>();
    //官方解法1：在回溯的过程中进行剪枝操作
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        int[] used = new int[chars.length];
        StringBuilder sb = new StringBuilder();
        dfs(used,chars,sb);
        return res.toArray(new String[0]);
    }
    //加上一个used数组 来判断当前的character是否是被用过的
    private void dfs(int[] used, char[] chars, StringBuilder sb) {
        if(sb.length() == chars.length){
            res.add(sb.toString());
        }
        for (int i = 0; i < chars.length; i++) {
            //当前的字母在上一个循环中以及用过 直接continue
            if(used[i] == 1){
                continue;
            }
            char cur = chars[i];
            boolean valid = true;
            for (int j = 0; j < i; j++) {
                //此处判断是否存在同层且相等的元素
                //举例 j a v a
                //第一层选j  第二层则有 a v a
                //需要删掉重复的a 剪枝 让选择只有a v
                //同样当第二层选择v 时 第三层的选择为 a a
                //通过剪枝排除另一个多的a
                if(used[j] == 0 && chars[j] == cur){
                    valid = false;
                }
            }
            if(!valid){
                //存在相同则剪枝
                continue;
            }
            sb.append(chars[i]);
            used[i] = 1;
            dfs(used,chars,sb);
            sb.deleteCharAt(sb.length() -1);
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        PermutationWithDuplicateChar0808 permutation = new PermutationWithDuplicateChar0808();
        permutation.permutation("java");
    }
}
