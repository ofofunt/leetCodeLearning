package com.shuatmd.leetcodetraining.Medium;
//306. 累加数
//累加数 是一个字符串，组成它的数字可以形成累加序列。
//
//一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
//
//给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
//
//说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

public class IsAdditiveNumber306 {
    //官方解法：通过DFS + 剪枝来做
    //DFS过程判断当前轮询到的数字是否等于前面两个数字的和
    public boolean isAdditiveNumber(String num) {
        if(num.length() < 3){
            return false;
        }
        return dfs(num, 0, 0, 0, 0);
    }

    private boolean dfs(String num, int index, int count, long prevprev, long prev) {
        //dfs终止条件 同时在终止的时候需要判断是否至少存在3个数
        if (index >= num.length()) {
            return count > 2;
        }
        long cur = 0;
        for (int i = index; i < num.length(); i++) {
            char c = num.charAt(i);
            //题干中说到不存在先导0 那么如果有01 02等等状况出现 说明需要剪枝
            if(num.charAt(index) == '0' && i > index){
                return false;
            }
            //i每移动一位,算出当前cur的值
            cur = cur * 10 + c - '0';

            //只有当count大于等于2的时候,才需要计算和以及进行判断
            if(count>=2){
                long sum = prevprev + prev;
                //如果当前分支的数 大于前面两个数的和,则说明这个分支不为递增
                if(sum < cur){
                    return false;
                }
                //如果当前分支的数小于前两个数的和,只能说明有可能是取少了 需要多取一位
                if(cur<sum){
                    continue;
                }
            }
            //只有当满足所有条件 才会去下一层继续寻找
            if(dfs(num,i+1,count+1,prev,cur)){
                return true;
            }

            //注意 如果用return dfs(num,i+1,count+1,prev,cur)会直接返回结果 比如 199100199 我们计算的时候会直接返回false 应该判断只有正确才返回true
        }
        return false;
    }

    public static void main(String[] args) {
        IsAdditiveNumber306 add = new IsAdditiveNumber306();
        add.isAdditiveNumber("199100199");
    }
}
