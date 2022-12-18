package com.example.leetCodeLearning.src.main.java.com.shuatmd.leetcodetraining.Easy;

public class Fib {
    int[] ints;

    // Solution1: 简单递归 但是需要储存起来运算中的中间结果 n-1的运算结果可以给n-2的时候复用
    // 比如f(2) = 1, 算f(3）的时候可以直接取出f(2)的值 不用再去做运算
    // 时间O(n)因为有n层需要递归 空间O(n) 因为递归需要n层栈
    public int fib(int n) {
        ints = new int[n];
        if(n <= 1) return n;
        return (f(n - 1) + f(n - 2)) % 1000000007;
    }
    private int f(int n) {
        if(n == 0 || n == 1) return n;
        if (ints[n] != 0){
            return ints[n];
        }
        ints[n] = (f(n - 1) + f(n - 2)) % 1000000007;
        return (f(n - 1) + f(n - 2)) % 1000000007;
    }

    //Solution2: 自底向上实现求和
    //abc代表三个指针 c指向得数 a=b b=c模拟指针前进的动作
    public int fib2(int n){
        if(n < 2){
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Fib fibb = new Fib();
        System.out.println(fibb.fib(44));
        System.out.println(fibb.fib2(44));
    }
}
