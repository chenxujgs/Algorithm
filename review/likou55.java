package suanfa.likou.review;

public class likou55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int db = 0;

           for (int i = 0; i <n; i++) {
               if(i<=db){
                   db = Math.max(i + nums[i], db);
                   if(db>=n-1){
                       return true;
                   }
               }

           }

        return false;
    }
}



























































































