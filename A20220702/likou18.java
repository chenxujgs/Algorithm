package suanfa.likou.A20220702;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class likou18 {
    public static void main(String[] args) {
        System.out.println(new likou18().fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }

    /**
     * 思路: 在三数之和的基础上增加循环
     */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n <= 2) return lists;
        // 预先排序
        Arrays.sort(nums);
        // 第一个指针,选取第一个元素
        for (int i = 0; i < n - 3; i++) {
            // 排除重复的元素,i>0 放过第一个元素,防止[2,2,2,2,2]类似情况出现
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 减去第一个元素的值
            int sum = target - nums[i];
            // 第二个指针,选取第二个元素
            for (int j = i + 1; j < n - 2; j++) {
                // 类似放过第一个元素,防止重复情况出现
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 头指针和尾指针
                int left = j + 1, right = n - 1;
                // 减去第二个值
                sum -= nums[j];
                while (left < right) {
                    int temp = nums[left] + nums[right];
                    // 若相加元素和target相等
                    if (temp == sum) {
                        // 添加到list中
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        /**
                         * 移动指针
                         * 排除相等元素
                         */
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if (temp > sum) {   //相加元素大于target
                        right--;
                    } else {   //相加元素小于target
                        left++;
                    }
                }
                // 第二个指针遍历结束,重设值
                sum += nums[j];
            }
        }
        return lists;
    }

}
