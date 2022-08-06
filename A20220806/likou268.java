package suanfa.likou.A20220806;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class likou268 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int[] res = new int[len + 1];
        for (int i = 0; i < len; i++) {
            res[nums[i]] = nums[i];
        }

        for (int i = 1; i <= len; i++) {
            if (res[i] == 0) {
                return i;
            }
        }

        return res[0];
    }
}
