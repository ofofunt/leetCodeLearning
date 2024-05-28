package com.shuatmd.leetcodetraining.Medium;

//334. 递增的三元子序列
//给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
//
//如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
//https://leetcode.cn/problems/increasing-triplet-subsequence/
public class IncreasingTriplet334 {
    //官方解法2： 贪心
    //推导过程有点复杂：
    //总结就是保证first 以及 second尽可能的小
    //同时在遍历中不断替换first 以及 second 的值


    //上述做法的贪心思想是：为了找到递增的三元子序列，first\textit{first}first 和 second\textit{second}second 应该尽可能地小，此时找到递增的三元子序列的可能性更大。
    //
    //假设 (first,second,num)(\textit{first}, \textit{second}, \textit{num})(first,second,num) 是一个递增的三元子序列，如果存在 second’\textit{second'}second’ 满足 first<second’<second\textit{first} < \textit{second'} < \textit{second}first<second’<second 且 second’\textit{second'}second’ 的下标位于 first\textit{first}first 的下标和 num\textit{num}num 的下标之间，则 (first,second’,num)(\textit{first}, \textit{second'}, \textit{num})(first,second’,num) 也是一个递增的三元子序列。但是当 (first,second’,num)(\textit{first}, \textit{second'}, \textit{num})(first,second’,num) 是递增的三元子序列时，由于 num\textit{num}num 不一定大于 second\textit{second}second，因此 (first,second,num)(\textit{first}, \textit{second}, \textit{num})(first,second,num) 未必是递增的三元子序列。由此可见，为了使找到递增的三元子序列的可能性更大，三元子序列的第二个数应该尽可能地小，将 second’\textit{second'}second’ 作为三元子序列的第二个数优于将 second\textit{second}second 作为三元子序列的第二个数。
    //
    //同理可得，三元子序列的第一个数也应该尽可能地小。
    //
    //如果遍历过程中遇到的所有元素都大于 first\textit{first}first，则当遇到 num>second\textit{num} > \textit{second}num>second 时，first\textit{first}first 一定出现在 second\textit{second}second 的前面，second\textit{second}second 一定出现在 num\textit{num}num 的前面，(first,second,num)(\textit{first}, \textit{second}, \textit{num})(first,second,num) 即为递增的三元子序列。
    //
    //如果遍历过程中遇到小于 first\textit{first}first 的元素，则会用该元素更新 first\textit{first}first，虽然更新后的 first\textit{first}first 出现在 second\textit{second}second 的后面，但是在 second\textit{second}second 的前面一定存在一个元素 first’\textit{first'}first’ 小于 second\textit{second}second，因此当遇到 num>second\textit{num} > \textit{second}num>second 时，(first’,second,num)(\textit{first'}, \textit{second}, \textit{num})(first’,second,num) 即为递增的三元子序列。
    //
    //根据上述分析可知，当遇到 num>second\textit{num} > \textit{second}num>second 时，一定存在一个递增的三元子序列，该三元子序列的第二个数和第三个数分别是 second\textit{second}second 和 num\textit{num}num，因此返回 true\text{true}true。
    //
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/increasing-triplet-subsequence/solutions/1204375/di-zeng-de-san-yuan-zi-xu-lie-by-leetcod-dp2r/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean increasingTripletGreedy(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            //首先我们确认了second左边已经有一个小于second的数
            //所以当cur > second的时候证明存在递增且大小为3的子序列
            if (cur > second) {
                return true;
            }
            //如果cur大于first且小于second,将second替换为cur
            //因为cur更小且能满足second > first的要求
            else if (cur > first) {
                second = cur;
            }
            //这一步比较麻烦,如果cur小于first,则将cur的值赋给first,此时虽然first在second的右边
            //但是我们知道此时second左边一定还有一个小于second的数,所以并不影响上面判断
            else {
                first = cur;
            }
        }
        return false;
    }

    //官方解法1： 因为只需要长度为3的递增数列 所以可以分为三部分解决
    //新建一个int[] leftMin记录index为i的时候左边的最小值
    //新建一个int[] rightMax记录index为i的时候右边最大的值
    //遍历nums[i] 查看是否存在 leftMin[i] < nums[i] < rightMax[i]
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        int[] leftMin = new int[length];
        int[] rightMax = new int[length];
        //leftMin的第一位对应nums第一位
        leftMin[0] = nums[0];
        //从左往右遍历,查询index小于等于i的最小值
        for (int i = 1; i < length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        //和上面同理 从右往左记录index大于i的最大数
        rightMax[length - 1] = nums[length - 1];
        for (int i = length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        //遍历整个nums[]
        for (int i = 1; i < length - 1; i++) {
            if (leftMin[i] < nums[i] && rightMax[i] > nums[i]) {
                return true;
            }
        }
        return false;
    }
}
