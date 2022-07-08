package suanfa.likou.review;

import java.util.ArrayList;
import java.util.List;

public class likou78 {
    public static void main(String[] args) {
        System.out.println(new likou78().subsets(new int[]{1, 2, 2}));
    }

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return lists;
    }

    private void dfs(int start, int[] nums) {
        if (start == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[start]);

        dfs(start + 1, nums);

        list.remove(list.size() - 1);

        dfs(start + 1, nums);
    }

}
