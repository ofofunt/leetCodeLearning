package com.shuatmd.leetcodetraining.Medium;
//剑指 Offer 56 - I. 数组中数字出现的次数
//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
public class NumberWithSingleTImeAppearance56 {
    //通过异或来实现
    //两个相同数异或为0,如果一个数组中只有一个数出现一次,则通过遍历异或可以得到最终结果
    //题目有两个数出现一次,需要将两个数单独分组,在进行遍历异或
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            //遍历异或,最后返回的是两个只出现过一次的数的异或
            res ^= num;
        }
        int m = 1;
        //因为res是两个数x y异或的结果,且x != y, 所以res一定会存在一位等于1
        //通过 m = 1 在遍历的时候辅助判断res从右往左第一位为1的数字
        while ((m & res) == 0) {
            //如果m & res == 0 证明res的这位数不为1
            m = m << 1;
            //往右移一位m 之后继续进行比较
        }
        int x = 0;
        int y = 0;
        for (int num : nums) {
            //通过num&m是否等于0来划分成2个数组,进行遍历异或操作
            if ((num & m) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
