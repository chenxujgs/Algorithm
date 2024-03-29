package suanfa.likou.A20220901;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false
 */
public class likou217 {
    public static void main(String[] args) {
        System.out.println(2 ^ 3 ^ 4 ^ 2);
    }

    /**
     * 思路: 使用 set 存储就行,因为只判断出现两次的
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
