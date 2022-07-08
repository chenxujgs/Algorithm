package suanfa.likou.review;

import java.util.ArrayList;
import java.util.List;

public class likou90 {
    public static void main(String[] args) {
        System.out.println(new likou90().subsetsWithDup(new int[]{1, 2, 2}));
    }

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        dfs(0, nums, false);
        return lists;
    }

    /**
     * @param start 当前值
     * @param nums  数组
     * @param bol   判断当前元素是否已遍历
     */
    private void dfs(int start, int[] nums, boolean bol) {
        // 若当前值与数组长度相等,存入
        if (start == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        //遍历第一遍,将当前元素设置为未遍历
        dfs(start + 1, nums, false);
        /**
         * 满足条件退出
         * 1. 当前元素已遍历 bol=false
         * 2. 当前元素索引大于0
         * 3. 前一个索引的值与该索引的值相等
         */
        if (!bol && start > 0 && nums[start - 1] == nums[start]) return;
        list.add(nums[start]);
        //遍历第二遍,将当前元素设置为已遍历
        dfs(start + 1, nums, true);
        /**
         * 剪枝
         * 例如 遍历完第一遍(单纯增加start),退出后加入索引为2的值
         * list[]  start=2  length=3
         * 第二遍 lists[[],[2]] 加入后退出递归到start=2的递归,由于bol=true,不返回
         * list[2,2]  start=3  length=3
         *  剪  list[2]
         */
        list.remove(list.size() - 1);
    }
}
