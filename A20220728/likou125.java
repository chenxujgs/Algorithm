package suanfa.likou.A20220728;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class likou125 {
    public static void main(String[] args) {
        // System.out.println(new likou125().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new likou125().isPalindrome("0p"));
    }

    /**
     * 思路: 常规双指针,注意限制条件即可
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        int left = 0, right = len - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(str[left])) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(str[right])) {
                right--;
            }

            if (Character.toLowerCase(str[left]) != Character.toLowerCase(str[right])) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}
