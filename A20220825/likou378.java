package suanfa.likou.A20220825;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * <p>
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 */
public class likou378 {
    public static void main(String[] args) {
        System.out.println(new likou378().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{matrix[i][0], i, 0});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] now = queue.poll();
            if (now[2] != n - 1) {
                queue.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }

        return queue.poll()[0];
    }
}
