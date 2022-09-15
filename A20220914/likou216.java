package suanfa.likou.A20220914;

import java.util.ArrayList;
import java.util.List;

/**
 * @找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次 
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class likou216 {
    public static void main(String[] args) {
        new likou216().combinationSum3(3, 7);
    }

    /**
     * 思路: 根据全排列组合的基础上增加条件,使用剪支+深搜
     */
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, 9, k, n);
        return lists;
    }

    private void dfs(int s, int e, int k, int sum) {
        if (list.size() + (e - s + 1) < k || list.size() > k) {
            return;
        }

        if (list.size() == k) {
            int tmp = 0;
            for (Integer i : list) {
                tmp += i;
            }

            if (tmp == sum) {
                lists.add(new ArrayList<>(list));
                return;
            }
        }

        list.add(s);
        dfs(s + 1, e, k, sum);
        list.remove(list.size() - 1);
        dfs(s + 1, e, k, sum);
    }
}
