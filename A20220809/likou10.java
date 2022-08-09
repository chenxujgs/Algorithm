package suanfa.likou.A20220809;

/**
 * @author cxj
 * @date 2022/8/9
 * @description
 */
public class likou10 {
    public static void main(String[] args) {
        System.out.println(new suanfa.likou.A20220809.likou10().isMatch("aa", "a*"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        char[] st = s.toCharArray();
        char[] pt = p.toCharArray();

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pt[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (match(i, j - 1, st, pt)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (match(i, j, st, pt)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean match(int i, int j, char[] st, char[] pt) {
        if (i == 0) {
            return false;
        }
        if (pt[j - 1] == '.') {
            return true;
        }

        return st[i - 1] == pt[j - 1];
    }
}
