package suanfa.likou.A20220726;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class likou41 {
    /**
     * 思路: 满足时间复杂度O(N),只能先对数组进行遍历,常熟空间复杂度,使用哈希桶存储存在的值
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int m = nums.length;
        for (int i = 0; i < m; i++) {
            set.add(nums[i]);
        }

        for (int i = 1; i <= m; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return m + 1;
    }
}
