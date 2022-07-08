package suanfa.likou.A20220701;

//给你一个字符串 s，找到 s 中最长的回文子串。
public class likou5 {
    public static void main(String[] args) {
        System.out.println(new likou5().longestPalindrome("cbbd"));
    }

    /**
     * 思路: dp[i][j]=dp[j][p]||(p-j)<3?dp[j][p]:dp[j + 1][p - 1]
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        char[] str = s.toCharArray();
        int maxLen = 1, begin = 0;

        for (int i = 2; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                int p = i + j - 1;
                if (p >= len) {
                    break;
                }

                if (str[j] != str[p]) {
                    dp[j][p] = false;
                } else {
                    if (p - j < 3) {
                        dp[j][p] = true;
                    } else {
                        dp[j][p] = dp[j + 1][p - 1];
                    }
                }
                if (dp[j][p] && p - j + 1 > maxLen) {
                    maxLen = p - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, maxLen);
    }
}
