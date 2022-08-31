package suanfa.likou.A20220831;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 */
public class likou395 {
    public static void main(String[] args) {
        System.out.println(new likou395().longestSubstring("aaabb", 3));
    }

    /**
     * 思路: 分治思想,对一段范围内出现次数都少于 k 的字符串的出现位置的中间部分的进行分组,
     * 因为该字符串不符合规定的话,则说明含有该字符串的最长子字符串都不符合
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    private int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }

            if (i > r) {
                break;
            }

            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int len = dfs(s, start, i - 1, k);
            ret = Math.max(ret, len);
        }
        return ret;

    }
}
