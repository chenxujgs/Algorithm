package suanfa.likou.A20220704;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class likou34 {
    public static void main(String[] args) {
        int[] ints = new likou34().searchRange(new int[]{1}, 1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 思路: 有序,使用二分,找到左边第一个target,右边第一个target,在进行left和right的索引位置和值的判断
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = ans(nums, target, true);
        int right = ans(nums, target, false) - 1;
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    private int ans(int[] nums, int target, boolean flag) {
        int start = 0, end = nums.length - 1;
        int ans = nums.length;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] > target || (flag && nums[mid] >= target)) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
