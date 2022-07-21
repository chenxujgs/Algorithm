package suanfa.likou.A20220721;

import java.util.ArrayList;
import java.util.List;

/**
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * <p>
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 * <p>
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 */
public class likou947 {
    public static void main(String[] args) {
        System.out.println(new likou947().removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
    }


    /**
     * 把石头看成点,行和列看成连接的边,此题简化成搜索孤立的点
     *
     * @param stones
     * @return
     */
    public int removeStones(int[][] stones) {
        // 记录每个i索引代表的 stones[i] 的位置的行和列
        List<List<Integer>> lists = new ArrayList<>();
        int m = stones.length;
        for (int i = 0; i < m; i++) {
            lists.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    lists.get(i).add(j);
                }
            }
        }

        // 记录遍历过的点
        boolean[] marked = new boolean[m];

        int sum = 0;
        // 一次遍历所有连通的点
        for (int i = 0; i < m; i++) {
            if (!marked[i]) {
                sum++;
                dfs(lists, marked, i);
            }
        }
        return m - sum;
    }

    private void dfs(List<List<Integer>> lists, boolean[] marked, int i) {
        marked[i] = true;

        for (Integer x : lists.get(i)) {
            if (!marked[x]) {
                dfs(lists, marked, x);
            }
        }
    }


}
