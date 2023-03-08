package com.shuatmd.leetcodetraining.Hard;

import java.util.PriorityQueue;
import java.util.Queue;

//如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
//如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
public class MedianFinder41 {
    Queue<Integer> A, B;

    //通过两个队列,一个大顶堆一个小顶堆来存储所有数字
    //当整体数字个数为奇数时,中位数为A队列的堆顶数字
    //当整体数字个数为偶数时,中位数为A队列的堆顶 + B队列的堆顶 / 2
    public MedianFinder41() {
        //A队列为大顶堆,peek是当前队列里最小的数字,整个队列用来保存较大的一半数字
        A = new PriorityQueue<Integer>();
        //B队列为小顶堆,堆顶为当前队列最大的数字,整个队列用来保存较小的一半数字
        B = new PriorityQueue<Integer>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        //当AB大小不等时,先将元素添加到A队列,同时B队列添加A队列中poll出来的最小值,保证B队列中存的都是更小的一部分
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        }
        //当AB大小相等时,先将元素添加到B队列,同时A队列添加B队列中poll出来的最大值,保证A队列中存的都是更大的一部分
        else {
            B.add(num);
            A.add(B.poll());
        }

    }

    public double findMedian() {
        if (A.size() == B.size()) {
            //记得除以2.00转double
            return (A.peek() + B.peek()) / 2.00;
        } else {
            return A.peek();
        }

    }
}
