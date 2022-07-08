package suanfa.likou.A20220706;

import java.util.ArrayList;
import java.util.List;

public class likou39 {
    public static void main(String[] args) {
        System.out.println(new likou39().combinationSum(new int[]{2,7,6,3,5,1}, 9));
    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        getCombinationSum(target, candidates, list, 0,candidates.length);
        return lists;
    }

    private void getCombinationSum(int target, int[] candidates, List<Integer> list, int begin,int len) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = begin; i < len; i++) {
            list.add(candidates[i]);
            getCombinationSum( target - candidates[i], candidates,list, i,len);
            list.remove(list.size() - 1);
        }
    }
}
