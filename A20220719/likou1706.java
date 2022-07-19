package suanfa.likou.A20220719;

/**
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 * <p>
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 * <p>
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 * <p>
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 */
public class likou1706 {

    /**
     * 思路: 模拟套路,若是V,则在j索引开始将j索引及比大于j索引的col相加,若在一行构成 V ,则相加必为0
     *
     * @param grid
     * @return
     */
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] answer = new int[n];

        for (int j = 0; j < n; j++) {
            int col = j;
            for (int[] g : grid) {
                int dir = g[col];
                col += dir;
                if (col < 0 || col >= n || dir != g[col]) {
                    answer[j] = -1;
                    break;
                }
                answer[j] = col;
            }

        }
        return answer;
    }

}
