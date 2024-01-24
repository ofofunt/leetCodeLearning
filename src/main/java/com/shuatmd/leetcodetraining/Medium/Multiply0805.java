package com.shuatmd.leetcodetraining.Medium;
//面试题 08.05. 递归乘法
//递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。

public class Multiply0805 {
    //官方解法：优化版本的递归
    public int multiplyRec(int A, int B) {
        int min = Math.min(A,B);
        int max = Math.max(A,B);
        if(min == 0){
            return 0;
        }

        return max + multiplyRec(max,min- 1);
    }
    //手搓解法：尝试一下递归
    //写的有点麻烦了 而且其实并不需要判断start,和end 可以直接通过是否=1来判断
    //另外其实需要根据数的大小来优化一下,判断哪个作为被乘数
    public int res = 0;
    public int multiply(int A, int B) {
        recur(A,B,0);
        return res;
    }

    private void recur(int a, int end, int start) {
        if(start == end){
            return;
        }
        res +=a;
        recur(a,end,start+1);
    }

    public static void main(String[] args) {
        Multiply0805 multiply0805 = new Multiply0805();
        multiply0805.multiply(1,10);
    }
}
