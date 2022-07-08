package suanfa.likou.A20220707;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class likou47 {
    public static void main(String[] args) {
        System.out.println(new likou47().permuteUnique(new int[]{1, 2, 2}));
    }
    List<List<Integer>> lists=new ArrayList<>();
    List<Integer> list=new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n=nums.length;
        boolean[] bol=new boolean[n];
        Arrays.sort(nums);
        dfs(nums,bol,0,n);

        return lists;
    }

    private void dfs(int[] nums, boolean[] bol, int start, int n) {
       if(start==n){
           lists.add(new ArrayList<>(list));
           return;
       }

        for (int i = 0; i <n ; i++) {
            if(bol[i]) continue;
            if(i>0&&nums[i]==nums[i-1]&&!bol[i-1]){
                continue;
            }
            list.add(nums[i]);
            bol[i]=true;
            dfs(nums, bol, start+1, n);

            list.remove(list.size()-1);
            bol[i]=false;
        }
    }


}
