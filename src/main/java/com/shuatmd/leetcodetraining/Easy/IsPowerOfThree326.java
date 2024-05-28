package com.shuatmd.leetcodetraining.Easy;

public class IsPowerOfThree326 {
    //官方解法： 数学
    //因为3是质数,所以3的所有次方的数也是质数
    //我们用int范围最大的3^19作为被除数,如果n能够整除3^19 则说明他是3的幂
    public boolean isPowerOfThreeMath(int n) {
        return n> 0 && 1162261467 %n == 0;
    }
    //平凡的手搓：使用while
    public boolean isPowerOfThree(int n) {
       while(n !=0 && n%3 ==0){
           n/=3;
       }
       return n == 1;
    }

    public static void main(String[] args) {
        IsPowerOfThree326 isPower = new IsPowerOfThree326();
        isPower.isPowerOfThree(27);
    }
}
