package com.shuatmd.leetcodetraining.Hard;

//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
public class CountDigitOne43 {
    public int countDigitOne(int n) {
        int digit = 1;
        int res = 0;
        //记录高位
        int high = n / 10;
        //记录低位
        int low = 0;
        //记录当前节点的值
        int cur = n % 10;
        while (high != 0 || cur != 0) {
            //当当前位数的值为0的时候,当前位数出现1的次数为high * digit
            //原理参考密码锁
            //例子 2209 判断10位出现1的次数 最后一次十位出现1是2119
            //xx1x 三个数字的可能性从000到219 总共可以出现219 + 1 = 220 次 = 22 x 10
            if(cur == 0){
                res = res + high * digit;
            }
            // 例子 2219 判断10位数出现1的次数
            // xx1x 三个数字的可能性从 000到229 前面220次是22 * digit 后面9次对应的是low的数字
            else if(cur == 1){
                res = res + high * digit + low + 1;
            }
            // 例子 2220 判断10位数出现1的次数 最后一次十位数出现1的数字是2219
            // xx1x 三个数字的可能性从 000到229 000到220 对应的是high * digit, 后面的0+9 对应的是digit的数字
            else if(cur > 1){
                res = res + (high + 1) * digit;
            }
            low = low + cur * digit;
            cur = high % 10;
            digit = digit * 10;
            high = high / 10;
        }
        return res;
    }
}
