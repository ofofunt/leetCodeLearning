package com.shuatmd.leetcodetraining.Easy;
//面试题 05.06. 整数转换
//整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
//https://leetcode.cn/problems/convert-integer-lcci/
public class ConvertInteger0506 {
    //手搓解法：分两步解题
    //需要改变几位才能将整数A转化为整数B ->实际上需要的是找到A异或B的结果中存在几个1
    //首先找到A异或B的结果diff
    //然后通过diff&(diff-1)来消除掉最右边的1,可以执行多少次就可以表明diff中存在几个1
    public int convertInteger(int A, int B) {
        int diff = A^B;
        int res = 0;
        while(diff!=0){
            //通过diff&（diff-1）来判断到底有几个1
            diff&=(diff-1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        ConvertInteger0506 c = new ConvertInteger0506();
        c.convertInteger(826966453,-729934991);
    }
}
