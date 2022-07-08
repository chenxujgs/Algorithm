package suanfa.likou.review;

public class likou209 {
    public static void main(String[] args) {
        System.out.println(likou209.minSubArrayLen(4, new int[]{1,4,4}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int len=nums.length;
        int left=0,right=0;
        int sum=0,res=Integer.MAX_VALUE;
        while(right<len){
           sum+=nums[right];
           while(sum>=target){
               res=Math.min(res,right-left+1);
               sum-=nums[left++];
           }
           right++;
        }
        return res;
    }
}
