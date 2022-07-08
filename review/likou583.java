package suanfa.likou.review;

public class likou583 {
    public int minDistance(String word1, String word2) {
         char[] char1=word1.toCharArray();
         char[] char2=word2.toCharArray();

         int n1=char1.length-1;
         int n2=char2.length-1;
         int begin1=0;
         int begin2=0;
         while(begin1<=n1) {
            if(char1[begin1]==char2[begin2]){
                begin1++;
                begin2++;
            }else{
                begin2++;
            }
         }
        return n1;
    }
}
