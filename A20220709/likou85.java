package suanfa.likou.A20220709;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积
 */
public class likou85 {
    public static void main(String[] args) {
        System.out.println(new likou85().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    /**
     * 思路: 参考力扣84题,将一行看作一个柱形图,最后直接对最后一行进行计算
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n + 1];
        height[n]=-1;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = matrix[i][j] == '1' ? matrix[i][j] + height[j] - '0' : 0;
            }
            res = Math.max(res, RangeErea(Arrays.copyOf(height, n+1)));
        }
        return res;
    }

    private int RangeErea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int len = height.length, max = 0;
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
            } else {
                int top = -1;
                while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                    top = stack.pop();
                    max = Math.max(max, height[top] * (i - top));
                }
                height[top] = height[i];
                stack.push(top);
            }
        }
        return max;
    }
}
