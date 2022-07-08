package suanfa.likou.review;

public class likou153 {
    public int findMin(int[] nums) {
        for (int i = 0; i <nums.length-1 ; i++) {
            if(nums[i]>nums[i+1]){
                return nums[i];
            }
        }
        return nums[0];
    }
}
