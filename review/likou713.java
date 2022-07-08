package suanfa.likou.review;

public class likou713 {
    public static void main(String[] args) {
        System.out.println(likou713.numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, n = nums.length;
        if (k < 1) return 0;
        int res = 0, sum = 1;
        for (int right = 0; right < n; right++) {
                 sum*=nums[right];
                 while (sum>=k) sum/=nums[left++];
                 res+=right-left+1;
        }
        return res;
    }
}
