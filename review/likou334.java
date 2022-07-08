package suanfa.likou.review;

/**
 * @author cxj
 * @date 2022/2/11
 * @description 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k)
 * 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；
 * 否则，返回 false
 */
public class likou334 {
    public static void main(String[] args) {
        System.out.println(new likou334().increasingTriplet(new int[]{6, 7, 1, 2}));
    }

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        // 记录第一个数 第二个数
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            // 记录第三个数
            int num = nums[i];
            // 若第三个数大于第二个数(第二个数总是大于第一个),则返回true
            if (num > second) {
                return true;
                // 第三个数小于第二个数,若大于第一个数,则将第三个数转化为第二个数,重新记录第三个数进行判断
            } else if (num > first) {
                second = num;
                // 第三个数小于第一,二个数,将第三个数转为第一个,重新开始判断
            } else {
                first = num;
            }
        }
        return false;
    }
}
