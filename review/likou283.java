package suanfa.likou.review;

public class likou283 {
    public static void main(String[] args) {
        //likou283.moveZeroes(new int[]{0,1,0,3,12});
    }
    public  void moveZeroes(int[] nums) {
            int n=nums.length,left=0,right=0;
            while(right<n){
                if(nums[right]!=0){
                    swap(nums,left,right);
                    left++;
                }
                right++;

            }
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }
    private  void swap(int[] nums, int left, int right) {
        int mid=nums[left];
        nums[left]=nums[right];
        nums[right]=mid;
    }
}
