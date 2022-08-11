package suanfa.likou.A20220810;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 */
public class likou11 {
    public static void main(String[] args) {
        System.out.println(new likou11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;
        while (left < right) {
            int tmp = Math.min(height[right], height[left]) * Math.abs(right - left);
            if (tmp > result) {
                result = tmp;
            }

            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
