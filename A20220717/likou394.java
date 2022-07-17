package suanfa.likou.A20220717;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class likou394 {
    public static void main(String[] args) {
        System.out.println(new likou394().decodeString("3[a]2[bc]"));
    }

    /**
     * 思路: 入栈/递归解决分解的小问题
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        // 存放结果
        Stack<String> stack2 = new Stack<>();
        StringBuilder res = new StringBuilder();
        int mark = 0;
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                Integer pop = stack1.pop();
                for (int i = 0; i < pop; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack2.pop() + tmp);
            } else if (c == '[') {
                stack1.push(mark);
                stack2.push(res.toString());
                mark = 0;
                res = new StringBuilder();
            } else if (Character.isDigit(c)) {
                mark = mark * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }


}
