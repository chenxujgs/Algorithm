package suanfa.likou.A20220801;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class likou179 {
    public static void main(String[] args) {
        System.out.println(new likou179().largestNumber(new int[]{3, 30, 34, 5, 9}));
        //new likou179().largestNumber(new int[]{10, 2});
    }

    /**
     * 思路:给字符串排好序即可
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        String s = sb.toString();
        return s.charAt(0) == '0' ? "0" : s;
    }
}
