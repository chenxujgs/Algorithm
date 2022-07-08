package suanfa.likou.A20220705;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */

/**
 * 思路: 在力扣36题进行进一步衍生,对空余的空间根据规则进行填充
 * 同样记录行,列,宫内记录的值,只是需要标记这个空间已有值,不需要填充,还要记录需要填充的位置
 * 深搜进行填充
 */
public class likou37 {
    boolean[][] col = new boolean[9][9];
    boolean[][] line = new boolean[9][9];
    boolean[][][] box = new boolean[3][3][9];
    List<int[]> list = new ArrayList<>();
    boolean flag = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    list.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - '0' - 1;

                    col[i][num] = true;
                    line[j][num] = true;
                    box[i / 3][j / 3][num] = true;
                }
            }
        }

        dfs(board, 0);
    }

    private void dfs(char[][] board, int index) {
        if (index == list.size()) {
            flag = true;
            return;
        }
        int i = list.get(index)[0];
        int j = list.get(index)[1];
        for (int num = 0; num < 9 && !flag; num++) {
            //满足条件
            if (!line[i][num] && !col[j][num] && !box[i / 3][j / 3][num]) {
                line[i][num] = col[j][num] = box[i / 3][j / 3][num] = true;
                board[i][j] = (char) ('0' + num + 1);
                dfs(board, index + 1);
                line[i][num] = col[j][num] = box[i / 3][j / 3][num] = false;
            }
        }
    }

}
