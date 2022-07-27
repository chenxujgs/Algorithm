package suanfa.likou.A20220727;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * <p>
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 
 */
public class likou994 {
    public static void main(String[] args) {
        System.out.println(new likou994().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));

    }


    /**
     * 思路: 借鉴树的广搜＋条件标记
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int total = 0, bad = 0, ans = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    total++;
                    if (grid[i][j] == 2) {
                        bad++;
                        deque.offer(new int[]{i, j});
                    }
                }
            }
        }
        if (total == bad) {
            return ans;
        }

        int[][] locs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!deque.isEmpty()) {
            int size = deque.size();
            ans++;
            while (size-- > 0) {
                int[] poll = deque.poll();
                for (int[] loc : locs) {
                    int xx = poll[0] + loc[0];
                    int yy = poll[1] + loc[1];

                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || grid[xx][yy] != 1) {
                        continue;
                    }

                    grid[xx][yy] = 2;
                    bad++;
                    deque.offer(new int[]{xx, yy});
                }
                // 如果所有水果都腐烂,直接退出
                if (total == bad) {
                    return ans;
                }
            }
        }

        return bad == total ? ans : -1;
    }


}
