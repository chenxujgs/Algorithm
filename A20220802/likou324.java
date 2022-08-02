package suanfa.likou.A20220802;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 */
public class likou324 {
    public static void main(String[] args) {
        new likou324().wiggleSort(new int[]{1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3});
        //new likou324().wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
    }

    /**
     * 思路: 双指针＋排序,利用好双指针就可以了
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        int len = clone.length;
        Arrays.sort(clone);
        // 1 2 2 3 3
        int left = (len - 1) / 2, right = len - 1;
        int index = 0;
        while (index < len) {
            if (index % 2 == 0) {
                nums[index] = clone[left];
                left--;
            } else {
                nums[index] = clone[right];
                right--;
            }
            index++;
        }
    }
}
