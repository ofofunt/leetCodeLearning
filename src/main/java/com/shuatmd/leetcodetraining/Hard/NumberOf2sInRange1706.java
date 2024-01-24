package com.shuatmd.leetcodetraining.Hard;
//面试题 17.06. 2出现的次数
//编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
//https://leetcode.cn/problems/number-of-2s-in-range-lcci/description/
public class NumberOf2sInRange1706 {
    //官方规范解法1： 思路参考手搓
    //手搓采取的是int转charArray的办法来做识别
    //官方采取的是直接在原数字n上进行循环 更直接
    public int numberOf2sInRangeOfficial(int n) {
        int count = 0;
        int high;
        int low;
        int cur;
        /*
        举个例子方便理解： 加入我们当前数字是12323
        第一次循环时 high = 1232 代表当前位数左边的数 low = 0代表当前位数右边的数字 cur = 3代表当前循环的位数
        第二次循环 high = 123 low = 3 cur = 2

         */
        for (int i = 1; i <= n; i*=10) {
            //取出高位
            high = (n/i) / 10;
            //取出地位
            low = n%i;
            //找到当前位置
            cur =(n/i) % 10;
            if (cur < 2){
                count += high * i;
            }else if (cur > 2){
                count += (high + 1) * i;
            }else if (cur == 2){
                count += high * i + low + 1;
            }
        }
        return count;
    }


    /*看了官方之后的手搓解法1： 简单易懂的数学解法
    分三种方法讨论 当前需要查看的位数大于2 等于2 或者小于2
    case1： 首先假设我们要查看数字 12323 中百位可以出现多少个2
    3 > 2 百位数的2的出现完全依靠左边高位数来实现
    00200 -> 00299
    01200 -> 01299
    02200 -> 02299
    ..............
    11200 -> 11299
    12200 -> 12299
    总共是(12 + 1) * 10 ^ (length('23')) = 1300个

    case2： 首先假设我们要查看数字 12123 中百位可以出现多少个2
    1 < 2 百位数的2的出现完全依靠左边高位数来实现
    00200 -> 00299
    01200 -> 01299
    02200 -> 02299
    ..............
    10200 -> 10299
    11200 -> 11299
    因为不存在12开头能实现的百位数为2的数字 所以会比大于的情况要少
    总共是12 * 10 ^ (length('23')) = 1200个

     case2： 首先假设我们要查看数字 12223 中百位可以出现多少个2
    2 = 2 百位数的2的出现完全依靠左边高位数以及右边低位来实现
    00200 -> 00299
    01200 -> 01299
    02200 -> 02299
    ..............
    11200 -> 11299
    12200 -> 11223

    其实就是小于2的情况 + 122开头存在多少个数的情况
    注意因为是200 到 223 所以实际是存在 23 + 1 = 24个的情况
    总共是12 * 10 ^ (length('23')) + 23 + 1= 1224个
    */

    public int numberOf2sInRange(int n) {
       if(n < 2){
           return 0;
       }
       if(n < 10){
           return 1;
       }
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();
        int count = 0;
        int len = charArray.length;
        int leftDig;
        int rightDig;
        for (int i = 0; i < len; i++) {
            int cur = Integer.valueOf(charArray[i] - '0');
            if(i == 0){
                leftDig = 0;
            }
            else {
                leftDig = Integer.valueOf(s.substring(0, i));
            }
            if(cur > 2){
                count +=Math.pow(10,len - i - 1) * (leftDig + 1);
            }
            else if (cur < 2){
                count +=Math.pow(10,len - i - 1) * leftDig;
            }
            else{
                rightDig = "".equals(s.substring(i + 1,len))? 0 :Integer.valueOf(s.substring(i + 1,len));
                count +=Math.pow(10,len - i - 1) * leftDig + rightDig + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf2sInRange1706 number = new NumberOf2sInRange1706();
        number.numberOf2sInRange(22);
    }

}
