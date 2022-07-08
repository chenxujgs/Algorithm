package suanfa.likou.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class likou91 {
    public static void main(String[] args) {
        System.out.println(new likou91().numDecodings("10"));
    }

    List<List<Character>> lists = new ArrayList<>();
    List<Character> list = new ArrayList<>();

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        Arrays.sort(chars);
        dfs(chars, 0, chars.length, false);
        return index;
    }

    int index = 0;

    private void dfs(char[] chars, int start, int length, boolean bol) {
        if (start == length ) {
            lists.add(list);
            System.out.println(lists);
            return;
        }

        dfs(chars, start + 1, length, false);
        if (!bol && start > 0 && chars[start] == chars[start - 1]) return;
        list.add(chars[start]);
        dfs(chars, start + 1, length, true);
        list.remove(list.size() - 1);
    }
}
