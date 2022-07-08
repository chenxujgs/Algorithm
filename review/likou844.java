package suanfa.likou.review;

public class likou844 {
    public static void main(String[] args) {
        likou844 l=new likou844();
//        System.out.println(l.compareWord("bxj##tw"));
//        System.out.println(l.compareWord(  "bxo#j##tw"));
        System.out.println(l.compareWord(   "a##c"));
        System.out.println(l.compareWord(   "#a#c"));



    }
    public boolean backspaceCompare(String s, String t) {
         return compareWord(s).equals(compareWord(t));
    }
    private String compareWord(String s){
         int len=s.length(),end=len-1,temp=0;
         char[] word =s.toCharArray();
         StringBuilder sb=new StringBuilder();
         while(end>=0) {
             while (end>=0 &&word[end] == '#') {
                 temp++;
                 end--;
             }
             while (temp > 0&&end>=0&&word[end] != '#') {
                 temp--;
                 end--;
             }
             if (end >= 0&&word[end]!='#') {
                 sb.append(word[end--]);
             }
         }

        return sb.toString();
    }
}
