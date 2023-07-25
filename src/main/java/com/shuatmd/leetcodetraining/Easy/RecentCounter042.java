package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-15 16:53
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 042. 最近请求次数
//写一个 RecentCounter 类来计算特定时间范围内最近的请求。
//请实现 RecentCounter 类：
//RecentCounter() 初始化计数器，请求数为 0 。
//int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
//保证 每次对 ping 的调用都使用比之前更大的 t 值。
public class RecentCounter042 {

    //用queue来实现最简单
    //
    Queue<Integer> queue =  new ArrayDeque<>();
    int count;
    public RecentCounter042() {

    }

    public int ping(int t) {
        queue.offer(t);
        while(queue.peek() < t - 3000){
            queue.poll();
        }
        return queue.size();
    }
}
