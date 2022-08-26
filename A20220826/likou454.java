package suanfa.likou.A20220826;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class likou454 {
    /**
     * 思路: 哈希+分组,nums1[i] + nums2[j] =- nums3[k] - nums4[l]
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = nums1[i] + nums2[j];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = -nums3[i] - nums4[j];
                if (map.containsKey(tmp)) {
                    ans += map.get(tmp);
                }
            }
        }
        return ans;
    }

}

