package suanfa.likou.A20220718;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题
 */
public class likou238 {
    public static void main(String[] args) {
        //  new likou238().productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        new likou238().productExceptSelf1(new int[]{1, 2, 3, 4});
    }

    /**
     * 思路: 利用前缀和特性，省略右边数组
     * 当前乘积=左边乘积*右边乘积
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        // 前缀和(截止到 i 之前乘积的最大值)
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            left[i] = r * left[i];
            r *= nums[i];
        }
        return left;
    }

    /**
     * 计算 ｉ　左边最大乘积和和右边最大乘积和
     * 将两边进行乘积
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[n - i - 1] = right[n - i] * nums[n - i];
        }

        for (int i = n - 1; i >= 0; i--) {
            left[i] = left[i] * right[i];
        }
        return left;
    }
}
