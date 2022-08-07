package suanfa.likou.A20220807;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */
public class likou1 {
    /**
     * 思路:暴力破解,双指针查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0, n = nums.length; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }

    /**
     * 思路: 理由哈希表,查找当前遍历到的索引值对应 target 的差值
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, n = nums.length; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0};
    }
}
