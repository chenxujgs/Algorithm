package suanfa.likou.A20220710;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class likou128 {
    public static void main(String[] args) {
        System.out.println(new likou128().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    /**
     * 思路: 此题难点为空间复杂度为O(1)且需要记录截止到这个值之前的最长子序列
     * 使用哈希表记录每个值的最长子序列,只需要查询小于这个值的最长子序列,类似动规
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, n = nums.length; i < n; i++) {
            map.put(nums[i], 1);
        }

        int res = 0;
        for (int num : nums) {
            int sum = 1;
            int cur = num - 1;
            while (map.containsKey(cur)) {
                sum += map.get(cur);
                map.put(num, sum);
                map.remove(cur--);
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
