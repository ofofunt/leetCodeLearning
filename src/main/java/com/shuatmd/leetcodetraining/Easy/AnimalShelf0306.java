package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayDeque;
import java.util.Deque;

//面试题 03.06. 动物收容所
//动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
//
//enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
//
//dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
//https://leetcode.cn/problems/animal-shelter-lcci/
public class AnimalShelf0306 {
    //手搓解法： 尝试只用Deque来做

    Deque<Integer> catQueue;
    Deque<Integer> dogQueue;

    int animalId;

    public AnimalShelf0306() {
        this.catQueue = new ArrayDeque<>();
        this.dogQueue = new ArrayDeque<>();
        this.animalId = 0;
    }

    public void enqueue(int[] animal) {
        if (0 == animal[1]) {
            catQueue.offer(animalId);
        } else {
            dogQueue.offer(animalId);
        }
        animalId++;
    }

    public int[] dequeueAny() {
        if (catQueue.isEmpty() || dogQueue.isEmpty()) {
            if (!catQueue.isEmpty()) {
                return new int[]{catQueue.poll(), 0};
            }
            if (!dogQueue.isEmpty()) {
                return new int[]{dogQueue.poll(), 1};
            }
            return new int[]{-1, -1};
        }
        return catQueue.peek() > dogQueue.peek() ? new int[]{dogQueue.poll(), 1} : new int[]{catQueue.poll(), 0};
    }

    public int[] dequeueDog() {
        if (dogQueue.isEmpty()) {
            return new int[]{-1, -1};
        }
        return new int[]{dogQueue.poll(),1};
    }


    public int[] dequeueCat() {
        if (catQueue.isEmpty()) {
            return new int[]{-1, -1};
        }
        return new int[]{catQueue.poll(),0};
    }
}
