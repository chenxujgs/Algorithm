package suanfa.likou.A20220816;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class likou22 {
    public static void main(String[] args) {
        System.out.println(new likou22().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    private void dfs(List<String> list, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == 2 * n) {
            list.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            dfs(list, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(")");
            dfs(list, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
