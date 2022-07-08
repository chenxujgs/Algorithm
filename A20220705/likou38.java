package suanfa.likou.A20220705;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 */
public class likou38 {
    public static void main(String[] args) {
        System.out.println(new likou38().countAndSay(5));
    }

    /**
     * 思路: 使用一个值在每一次循环内记录值
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String str = "1";
        int pos = 0;
        int start = 0;

        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(start) == str.charAt(pos)) {
                    pos++;
                }
                sb.append(pos - start).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
            pos = 0;
            start = 0;
        }
        return str;
    }
}