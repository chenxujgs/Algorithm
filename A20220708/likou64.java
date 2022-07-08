package suanfa.likou.A20220708;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class likou64 {
    public static void main(String[] args) {
        System.out.println(new likou64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    // 动规解决
    public int minPathSum1(int[][] grid) {
        for (int i = 0, m = grid.length; i < m; i++) {
            for (int j = 0, n = grid[0].length; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + 1;
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    int m, n, sum = Integer.MAX_VALUE;

    // 深搜解决(超时)
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dfs(grid, 0, 0, grid[0][0]);
        return sum;
    }

    int[][] loc = new int[][]{{0, 1}, {1, 0}};

    private void dfs(int[][] grid, int x, int y, int num) {
        if (x == m - 1 && y == n - 1) {
            sum = Math.min(sum, num);
            return;
        }

        for (int[] path : loc) {
            int xx = x + path[0];
            int yy = y + path[1];
            if (xx >= m || yy >= n) {
                continue;
            }
            num += grid[xx][yy];
            dfs(grid, xx, yy, num);
            num -= grid[xx][yy];
        }
    }
}
