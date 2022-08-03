package suanfa.likou.A20220803;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * <p>
 * 以任意顺序返回这两个数字均可。
 */
public class likou_missingTwo {
    public static void main(String[] args) {
        //    new likou_missingTwo().missingTwo1(new int[]{2, 3});
        new likou_missingTwo().missingTwo1(new int[]{1});
    }

    /**
     * 思路: 使用哈希表记录存在的数字
     *
     * @param nums
     * @return
     */
    public int[] missingTwo(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int[] res = new int[2];
        for (int i = 1, tmp = 1; tmp >= 0; i++) {
            if (!set.contains(i)) {
                res[tmp] = i;
                tmp--;
            }
        }
        return res;
    }

    /**
     * 思路: 将数字转移到它对应的索引上,在查找索引上缺失的数字即可
     *
     * @param nums
     * @return
     */
    public int[] missingTwo1(int[] nums) {
        int[] ans = new int[nums.length + 3];
        for (int i = 0; i < nums.length; i++) {
            ans[nums[i]] = nums[i];
        }

        int[] res = new int[2];
        int tmp = 1;
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] == 0) {
                res[tmp--] = i;
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {

    }
}
