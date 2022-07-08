package suanfa.likou.A20220704;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 */
public class likou36 {
    /**
     * 思路: 需要记录一行,一列,分隔线内出现的数字,判断时又需要O(1)取出对应值,防止遍历数组
     * 该规则为9*9,取出的值在 一行,一列,分隔线内只出现一次,可以以行,列,分割线为i,值为j为二维数组索引进行判断
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] col = new int[9][10];
        int[][] row = new int[9][10];
        int[][] box = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                int num = board[i][j] - '0';
                if (row[i][num] == 1) {
                    return false;
                }
                if (col[j][num] == 1) {
                    return false;
                }

                if (box[(i / 3) * 3 + j / 3][num] == 1) {
                    return false;
                }
                row[i][num] = 1;
                col[j][num] = 1;
                box[(i / 30) * 3 + j / 3][num] = 1;

            }
        }
        return true;
    }

}
