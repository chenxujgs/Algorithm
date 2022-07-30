package suanfa.likou.A20220730;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cxj
 * @date 2022/7/29
 * @description
 */
public class likou212 {
    public static void main(String[] args) {
        System.out.println(new likou212().findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "ea", "ea", "rain"}));
        // System.out.println(new likou212().findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcb"}));
    }

    /**
     * 使用回溯,标记存在的单词,并遍历所有可能的词
     */
    Set<String> set = new HashSet<>();
    boolean[][] marked = new boolean[12][12];
    List<String> list = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
                dfs(board, marked, sb, i, j);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return list;
    }

    int[][] locs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private void dfs(char[][] board, boolean[][] marked, StringBuilder sb, int i, int j) {
        if (sb.length() > 10) {
            return;
        }

        if (set.contains(sb.toString())) {
            list.add(sb.toString());
            set.remove(sb.toString());
        }

        marked[i][j] = true;
        for (int[] loc : locs) {
            int xx = i + loc[0];
            int yy = j + loc[1];

            if (xx >= board.length || yy >= board[0].length || xx < 0 || yy < 0) {
                continue;
            }

            if (!marked[xx][yy]) {
                sb.append(board[xx][yy]);
                dfs(board, marked, sb, xx, yy);
                marked[xx][yy] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        marked[i][j] = false;
    }
}
