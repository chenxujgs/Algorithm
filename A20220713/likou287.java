package suanfa.likou.A20220713;

import java.util.HashSet;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class likou287 {
    public static void main(String[] args) {
        //System.out.println(new likou287().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new likou287().findDuplicate1(new int[]{1, 3, 4, 2, 2}));
    }

    // 哈希桶
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return 0;
    }

    // 快慢指针
    public int findDuplicate1(int[] nums) {
        int slow = 0, fast = 0;
        // 定位到重复元素的最后一位
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 和寻环链表差不多,将 slow 定位到重复元素的第一位
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
