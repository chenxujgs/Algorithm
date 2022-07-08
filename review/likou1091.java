package suanfa.likou.review;

import java.util.LinkedList;
import java.util.Queue;

public class likou1091 {
    public static void main(String[] args) {
        System.out.println(new likou1091().shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
       // System.out.println(new likou1091().shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int path = 1;
        int[][] location = new int[][]{{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                if (x == n - 1 && y == n - 1) {
                    return path;
                }

                for (int[] loc : location) {
                    int x1 = x + loc[0];
                    int y1 = y + loc[1];

                    if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= n || grid[x1][y1] == 1) {
                        continue;
                    }

                    queue.offer(new int[]{x1, y1});

                    grid[x1][y1] = 1;

                }
                path++;
            }

        }
            return -1;
        }

}