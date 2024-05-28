package com.shuatmd.leetcodetraining.Medium;

//307. 区域和检索 - 数组可修改
//给你一个数组 nums ，请你完成两类查询。
//
//其中一类查询要求 更新 数组 nums 下标对应的值
//另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
//实现 NumArray 类：
//https://blog.csdn.net/qq_40941722/article/details/104406126
//NumArray(int[] nums) 用整数数组 nums 初始化对象
//void update(int index, int val) 将 nums[index] 的值 更新 为 val
//int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
public class NumArray307Official {
    //官方解法： 树状结构来做
    //树状结构计算某节点的总和 和update单一节点非常方便
    //https://blog.csdn.net/qq_40941722/article/details/104406126

    //下面是树状结构的模板 可以考虑背一下
    int[] tree;
    int n;
    int[] nums;

    int lowbit(int x) {
        return x & -x;
    }


    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tree[i] += u;
        }
    }

    public NumArray307Official(int[] _nums) {
        this.nums = _nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }


    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}
