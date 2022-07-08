package suanfa.likou.A20220707;

public class likou45 {
    public static void main(String[] args) {
        System.out.println(new likou45().jump(new int[]{2, 3, 1, 1, 4}));
    }
    public int jump(int[] nums) {
        int n=nums.length;
        int index=0;
        int maxLoc=0;
        int end=0;
        for (int i = 0; i <n ; i++) {
            maxLoc=Math.max(maxLoc,i+nums[i]);
            if(end==i){
                end=maxLoc;
                index++;
            }
        }
        return index;
    }
}
