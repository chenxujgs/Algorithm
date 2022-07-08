package suanfa.likou.review;

/**
 * @author cxj
 * @date 2022/2/27
 * @description
 */
public class likou383 {
    public static void main(String[] args) {
        System.out.println(new likou383().canConstruct("az", "aab"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = new char[27];
        int m = magazine.length();
        char[] mag = magazine.toCharArray();
        for (int i = 0; i < m; i++) {
            chars[mag[i] - 96]++;
        }
        int r = ransomNote.length();
        char[] ran = ransomNote.toCharArray();
        for (int i = 0; i < r; i++) {
            if (chars[ran[i] - 96] > 0) {
                chars[ran[i] - 96]--;
            } else {
                return false;
            }
        }
        return true;
    }
}
