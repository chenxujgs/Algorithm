package suanfa.likou.A20220713;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class likou169 {
    public static void main(String[] args) {
        System.out.println(new likou169().majorityElement(new int[]{3, 2, 3}));
    }

    // 出现 n/2 的元素会占据数组一半空间
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
