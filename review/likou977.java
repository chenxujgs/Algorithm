package suanfa.likou.review;

import java.util.Arrays;

public class likou977 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            nums[i]= (int) Math.pow(nums[i],2);
        }
        Arrays.sort(nums);
    return nums;
    }
}
