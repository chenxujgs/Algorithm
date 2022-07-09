package suanfa.likou.A20220709;

import java.util.Arrays;
import java.util.Stack;


/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class likou84 {
    public static void main(String[] args) {
        System.out.println(new likou84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    /**
     * 是以i 为中心，向左找第一个小于 heights[i] 的位置 left_i；
     * 向右找第一个小于于 heights[i] 的位置 right_i，即最大面积为 heights[i] * (right_i - left_i -1)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        // 总是记录最小元素
        int[] right = new int[n];
        Arrays.fill(right, n);
        // 每个索引利用 left 和 right 都要记录所能得到的矩阵面积最大值
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && heights[i] <= heights[stack.peek()]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
