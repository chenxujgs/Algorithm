package suanfa.likou.A20220714;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class likou221 {
    public static void main(String[] args) {
        System.out.println(new likou221().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    /**
     * 思路: 使用 marked 记录最小值,经典的动规
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] marked = new int[m][n];

        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        marked[i][j] = 1;
                    } else {
                        marked[i][j] = Math.min(marked[i - 1][j - 1], Math.min(marked[i - 1][j], marked[i][j - 1])) + 1;
                    }
                }
                sum = Math.max(sum, marked[i][j]);
            }
        }
        return sum * sum;
    }


}
