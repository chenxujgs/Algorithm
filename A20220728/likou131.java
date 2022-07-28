package suanfa.likou.A20220728;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串
 */
public class likou131 {
    public static void main(String[] args) {
        System.out.println(new likou131().partition("aab"));
    }

    /**
     * 思路: 有点暴力的感觉,但是比 dp 简单,先分割,在判断每个字符串是不是回文
     */
    List<List<String>> lists;
    List<String> path;

    public List<List<String>> partition(String s) {
        lists = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(s, 0);
        return lists;
    }

    private void backtracking(String s, int index) {
        if (index == s.length()) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }

}
