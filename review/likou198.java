package suanfa.likou.review;

public class likou198 {
    public static void main(String[] args) {
        System.out.println(likou198.rob1(new int[]{1,2,1,1}));
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        int res=0;
        int index=0;
        while(index<n){
            int temp=0;
            for (int i = index; i <n ; i+=2) {
                temp+=nums[i];
            }
            if(temp>res){
                res=temp;
            }
            index++;
        }
        return res;
    }

    public static int rob1(int[] nums) {
       int n=nums.length;
       if(n<2) return nums[0];

       int res1=check(nums,0,n-1);
       int res2=check(nums,1,n);
       if(res1>res2) return res1;
       else return res2;
    }
    private static int check(int[] nums,int start,int end){
        int first=nums[start];
        int second=Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <end ; i++) {
            int temp=second;
            second=Math.max(second,first+nums[i]);
            first=temp;
        }
        return second;
    }
}
