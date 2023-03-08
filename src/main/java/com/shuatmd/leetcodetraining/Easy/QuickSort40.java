package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;
import java.util.PriorityQueue;

//实现快拍
public class QuickSort40 {
    public static int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) return quickSort(arr, k, l, i - 1);
        if (i < k) return quickSort(arr, k, i + 1, r);
        return Arrays.copyOf(arr, k);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,6,5,8,9,4,10,3,20,11,13,16,19,22,23,25,2};
        int[] ints = QuickSort40.quickSort(arr, 4, 0, arr.length - 1);
        for (int i : ints) {
            //System.out.println(i);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y-x);
        pq.add(9);
        pq.add(5);
        pq.add(2);
        pq.add(7);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
