package com.shuatmd.leetcodetraining.Medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

//剑指 Offer 63. 股票的最大利润
//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
public class MaxProfitStock63 {
    //官方解法：直截了当最快
    public int maxProfitOfficial(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if(price < minPrice){
                minPrice = price;
            }
            else{
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    //自己写的解法2： 优化到一个deque来实现 效率还是不行
    public int maxProfitDeque(int[] prices) {
        Deque<Integer> deque = new LinkedList<>();
        if(prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        deque.addFirst(prices[0]);
        deque.addLast(0);
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] > deque.getLast()){
                deque.removeLast();
                deque.addLast(prices[i]);
            }
            if(prices[i] <= deque.peek()){
                deque.removeFirst();
                deque.removeLast();
                deque.addFirst(prices[i]);
                deque.addLast(0);
            }
            maxProfit = Math.max(maxProfit, deque.getLast() - deque.peek());
        }
        return maxProfit;
    }
    //自己写的解法1： 效率不够 得改进下
    public int maxProfit(int[] prices) {
        Deque<Integer> lowerQueue = new LinkedList<>();
        Deque<Integer> upperQueue = new LinkedList<>();
        if(prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        lowerQueue.addFirst(prices[0]);
        upperQueue.addFirst(prices[0]);
        for (int i = 1; i < prices.length; i++) {
            if(!lowerQueue.isEmpty() && prices[i] < lowerQueue.peek()){
                lowerQueue.removeFirst();
                lowerQueue.addFirst(prices[i]);
                if(!upperQueue.isEmpty()) {
                    upperQueue.removeFirst();
                    upperQueue.addLast(0);
                }
            }
            if(!upperQueue.isEmpty() && prices[i] > upperQueue.peek()){
                upperQueue.removeFirst();
                upperQueue.addFirst(prices[i]);
            }
            maxProfit = Math.max(maxProfit, upperQueue.peek() - lowerQueue.peek());
        }
        return maxProfit;
    }
}
