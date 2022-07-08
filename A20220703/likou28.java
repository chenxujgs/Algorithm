package suanfa.likou.A20220703;

import java.util.Arrays;

/**
 * 小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
 * 抽象: 寻找数组内最接近target的两个数之和
 */
public class likou28 {
    public static void main(String[] args) {
        int i = likou28.purchasePlans(new int[]{5, 3, 1, 2}, 7);
        System.out.println(i);

    }

    /**
     * 思路: 排序,每一遍循环以头指针为依据,使用双指针进行逐一判断,两数之和加起来大于target,则将尾指针-1
     * 小于则头指针＋1,遍历一遍后置换尾指针
     *
     * @param nums
     * @param target
     * @return
     */
    public static int purchasePlans(int[] nums, int target) {
        int start = 0, n = nums.length;
        int end = n - 1, sum = 0;
        Arrays.sort(nums);
        while (start < n - 1) {
            while (start != end) {
                if (nums[start] + nums[end] <= target) {
                    sum++;

                } else {
                    start++;
                }
                end--;
            }
            start++;
            end = n - 1;
        }
        return sum;
    }
}
