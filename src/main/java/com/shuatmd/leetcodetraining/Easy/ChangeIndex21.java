package com.shuatmd.leetcodetraining.Easy;

public class ChangeIndex21 {
    //Solution 1: 双指针交换，i从0到末尾 j从末尾到0
    //i负责寻找顺序寻找
    public int[] exchange(int[] nums) {
        int j = nums.length - 1;
        int i = 0;
        int tmp;
        while (i < j) {
            while (i < j && ((nums[i] & 1) == 1)) {
                i++;
            }
            while (i < j && ((nums[j] & 1) == 0)) {
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        ChangeIndex21 changeIndex21 = new ChangeIndex21();
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        changeIndex21.exchange(intArray);

    }
}
