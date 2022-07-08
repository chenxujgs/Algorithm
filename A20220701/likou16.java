package suanfa.likou.A20220701;

import java.util.Arrays;

public class likou16 {
    public static void main(String[] args) {
        System.out.println(new likou16().threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        // 该值不能设置为Max_Integer,若target为负数,相减为MIN_Integer
        int ans = 10000;
        // 循环每一种可能性
        for (int i = 0; i < n; i++) {
            // 若该元素与前一个元素相等,跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = n - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                //若元素相等,则为答案
                if (temp == target) {
                    return temp;
                }
                //判断最接近最小值
                if (Math.abs(temp - target) < Math.abs(ans - target)) {
                    ans = temp;
                }
                // 若当前相加的元素大于值,移动右边指针(最大值),使下次相加的元素变小
                if (temp > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
