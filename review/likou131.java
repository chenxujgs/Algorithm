package suanfa.likou.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxj
 * @date 2022/4/3
 * @description
 */
public class likou131 {
    public static void main(String[] args) {
        System.out.println(new likou131().partition("aabcc"));

    }

    List<List<String>> ans = new ArrayList<>();
    String[][] ps;

    public List<List<String>> partition(String s) {
        int n = s.length();
        ps = new String[n][n];
        /**
         * 如 aabcc
         * ["a", "aa", null, null, null]
         * [null, "a", null, null, null]
         * [null, null, "b", null, null]
         * [null, null, null, "c", "cc"]
         * [null, null, null, null, "c"]
         */
        // 初始化回文字符串到ps数组中,存储第i个到第j个的回文字符串
        initP(s.toCharArray());
        // 深搜拼接ps数组中的元素
        dfs(s, 0, new ArrayList<String>());
        return ans;
    }

    private void dfs(String s, int i, ArrayList<String> list) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int j = 1; j <= s.length() - i; j++) {
            if (ps[i][i + j - 1] == null) {
                continue;
            }
            list.add(ps[i][i + j - 1]);
            dfs(s, i + j, list);
            list.remove(list.size() - 1);
        }
    }

    private void initP(char[] s) {
        int len = s.length;
        boolean[][] p = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                /**
                 * 为什么需要p数组: 记录两个字符相等的同时,记录包含在两个字符里面的字符串是否是回文串
                 */
                p[i][j] = s[i] == s[j] && (j - i < 2 || p[i + 1][j - 1]);
                if (p[i][j]) {
                    ps[i][j] = new String(Arrays.copyOfRange(s, i, j + 1));
                }
            }
        }
    }
}
