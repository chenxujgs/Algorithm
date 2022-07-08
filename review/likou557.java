package suanfa.likou.review;

public class likou557 {
    public static void main(String[] args) {
        String s = likou557.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }
    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuffer sb=new StringBuffer();
        char[] chars = strings[0].toCharArray();
        reverseString(chars);
        sb.append(chars);
        for (int i = 1; i <strings.length ; i++) {
            char[] s1 = strings[i].toCharArray();
            reverseString(s1);
            sb.append(" ");
            sb.append(s1);
        }
        return sb.toString();
    }
    public static void reverseString(char[] s) {
        int n=s.length-1,mid=n>>1;
        for(int i=0;i<mid;i++){
            swap(s,i,n-i);
        }
        if(n%2==1){
            swap(s,mid,mid+1);
        }
    }
    private static void swap(char[] nums, int left, int right) {
        char mid=nums[left];
        nums[left]=nums[right];
        nums[right]=mid;
    }
}
