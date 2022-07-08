package suanfa.likou.A20220706;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class likou40 {
    public static void main(String[] args) {
        System.out.println(new likou40().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<Integer> list = new ArrayList<>();
        boolean[] mark = new boolean[len];
        Arrays.sort(candidates);
        getCombinationSum(candidates, target, 0, len, list, mark);
        return lists;
    }

    private void getCombinationSum(int[] candidates, int target, int start, int len, List<Integer> list, boolean[] mark) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < len; i++) {
            if (mark[i]||(i > start && candidates[i] == candidates[i - 1])) {
                continue;
            }
                list.add(candidates[i]);
                mark[i] = true;
                getCombinationSum(candidates, target - candidates[i], i + 1, len, list, mark);
                list.remove(list.size() - 1);
                mark[i] = false;
        }
    }
}
