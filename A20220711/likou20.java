package suanfa.likou.A20220711;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class likou20 {
    public static void main(String[] args) {
        System.out.println(new likou20().isValid("["));
    }

    /**
     * 思路: 左右括号的正确出现总是有序
     * 分为两种情况:
     * 左括号: 直接放到栈中
     * 右括号: 判断栈中是否有元素,若空,说明不符合规则,有元素,判断栈顶元素是否相同,相同,相互抵消,不同返回false
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        for (int i = 0, n = s.length(); i < n; i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || map.get(stack.peek()) != s.charAt(i)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
