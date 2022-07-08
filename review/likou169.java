package suanfa.likou.review;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author cxj
 * @date 2022/1/22
 * @description 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class likou169 {
    public static void main(String[] args) {
        System.out.println(likou169.majorityElement(new int[]{1, 2, 2, 1, 3}));
    }

    /**
     * 哈希表
0     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int mark = map.get(nums[i]) + 1;
                if (mark > n >> 1) {
                    return nums[i];
                }
                map.put(nums[i], mark);
            } else {
                map.put(nums[i], 1);
            }
        }
        return nums[0];
    }

    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 随机化
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Random random = new Random();

        int majorityCount = nums.length / 2;

        // 随机挑选一个下标,检查是否为众数
        while (true) {
            int candidate = nums[randRange(random, 0, nums.length)];
            if (count0ccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }

    }

    // 获取指定数在数组出现的次数
    private static int count0ccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }

        }
        return count;
    }

    // 获取指定范围内的随机数
    private static int randRange(Random random, int min, int max) {
        return random.nextInt(max - min) + min;
    }


}
