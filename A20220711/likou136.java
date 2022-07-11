package suanfa.likou.A20220711;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class likou136 {
    public static void main(String[] args) {
        System.out.println(new likou136().singleNumber(new int[]{2, 2, 1}));
    }

    /**
     * 思路: 利用位运算 ^ 两个数异或为0,0和另一个数异或结果为另一个数
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1, n = nums.length; i < n; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
