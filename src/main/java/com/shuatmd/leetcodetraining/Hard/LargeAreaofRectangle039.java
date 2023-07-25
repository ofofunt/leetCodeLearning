package com.shuatmd.leetcodetraining.Hard;

import java.util.Stack;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-14 16:49
 * @Description: TODO
 * @Version: I.0
 */
//剑指 Offer II 039. 直方图最大矩形面积
//给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//求在该柱状图中，能够勾勒出来的矩形的最大面积。
public class LargeAreaofRectangle039 {
    //手搓解法1：思考思考怎么用stack来做
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int area = 0;
        for (int i = 0, length = heights.length; i < length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                area = Math.max(area, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            area = Math.max(area, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return area;
    }
}
