package com.shuatmd.leetcodetraining.Medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//面试题 17.09. 第 k 个数
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
public class GetKthUglyNumber1709 {
    //官方题解2：多路归并
    //丑数只能通过之前丑数 *3 or * 5 or *7来实现
    //假设现在有一个丑数按照顺序排列的数列ugly
    //则 ugly[0] * 3,ugly[0] * 5,ugly[0] * 7,ugly[1] * 3,ugly[1] * 5,ugly[1] * 7.....依然为一个按照顺序排列的丑数数列
    //举例 ugly[0]=1; index1=0; index2=0; index3=0
    //ugly[1]=Min(ugly[index1]*3,ugly[index2]*5,ugly[index3]*7)
    //=Min(1*3,1*5,1*7)
    //=3
    //于是 index1++;
    //
    //ugly[2]=Min(ugly[index1]*3,ugly[index2]*5,ugly[index3]*7)
    //=Min(3*3,1*5,1*7)
    //=5
    //于是 index2++;

    public int getKthMagicNumberMerge(int k) {
        int[] numList = new int[k + 1];
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        numList[0] = 1;
        for (int i = 1; i < k; i++) {
            numList[i] = Math.min(Math.min(numList[p3] * 3, numList[p5] * 5), numList[p7] * 7);
            if (numList[i] == numList[p3] * 3) {
                p3++;
            }
            if (numList[i] == numList[p5] * 5) {
                p5++;
            }
            if (numList[i] == numList[p7] * 7) {
                p7++;
            }
        }
        return numList[k - 1];
    }

    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //官方题解1：用最小堆来实现
    //其实本质上是求3a x 5b x 7c数字的排序
    //根据k的次数轮流将数字放入prorityQueue中 并且维护一个Set来防止重复放入
    //之后第k次从队列中取出的数就是第k个最小的数
    public int getKthMagicNumber(int k) {
        //通过Set来确保放入Queue中的元素不存在重复 比如 3*5 5*3
        Set<Long> seen = new HashSet<>();
        //通过PriorityQueue来对放入元素进行排序
        PriorityQueue<Long> queue = new PriorityQueue<>();
        seen.add(1L);
        queue.offer(1L);
        int[] factors = new int[]{3, 5, 7};
        int ugly = 0;
        for (int i = 0; i < k; i++) {
            long poll = queue.poll();
            ugly = (int) poll;
            for (int factor : factors) {
                long next = factor * poll;
                if (seen.add(next)) {
                    queue.offer(next);
                }
            }
        }
        return ugly;
    }
}
