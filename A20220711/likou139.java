package suanfa.likou.A20220711;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class likou139 {

    public static void main(String[] args) {
        System.out.println(new likou139().wordBreak("catsandog", new ArrayList<String>() {{
            add("cats");
            add("dog");
            add("sand");
            add("and");
            add("cat");
        }}));
//        System.out.println(new likou139().wordBreak("leetcode", new ArrayList<String>() {{
//            add("leet");
//            add("code");
//        }}));
    }

    /**
     * 思路: j为分隔符,字符串s是否合法可由 s1[0,j-1] 和 s2[j,i-1] 得出,判断到s2合法时可由dp[j]判断s1合法得出s合法
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
