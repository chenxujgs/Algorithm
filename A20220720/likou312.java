package suanfa.likou.A20220720;

/**
 * @author cxj
 * @date 2022/7/20
 * @description
 */
public class likou312 {
    public static void main(String[] args) {
        System.out.println(new likou312().maxCoins(new int[]{3, 1, 5, 8}));
    }

    /**
     * 思路: 假设此时定位到索引k,那么最大值等于 max=dp[i,k]+(nums[i]+nums[k]+nums[j])+dp[k,j]
     * 即需要遍历获得需要的k,小问题递推
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] tmp = new int[n + 2];
        tmp[0] = 1;
        tmp[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            tmp[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int i = 3; i <= n + 2; i++) {
            for (int j = 0; j <= n - i + 2; j++) {
                int res = 0;
                for (int k = j + 1; k < i + j - 1; k++) {
                    int left = dp[j][k];
                    int right = dp[k][i + j - 1];
                    res = Math.max(res, left + right + tmp[j] * tmp[i + j - 1] * tmp[k]);
                }
                dp[j][i + j - 1] = res;
            }

        }

        return dp[0][n + 1];
    }
}
