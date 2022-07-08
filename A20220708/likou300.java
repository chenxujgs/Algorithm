package suanfa.likou.A20220708;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，
 * 删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class likou300 {
    public static void main(String[] args) {
        System.out.println(new likou300().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

    /**
     * 思路: 双指针＋动规  动规主要是记录在双指针范围内能获取到的最长序列,由选中的两个值进行
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, res = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
