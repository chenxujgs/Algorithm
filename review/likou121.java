package suanfa.likou.review;

public class likou121 {
    public static void main(String[] args) {
        System.out.println(new likou121().maxProfit(new int[]{7,6,4,3,1}));
    }
    public int maxProfit(int[] prices) {
          int temp=prices[0];
          int n=prices.length;
          int[] res=new int[n];
        for (int i = 1; i <n ; i++) {
            int lirun=prices[i]-temp;
            if(lirun<0){
                temp=prices[i];
            }
            if(lirun>res[i-1]){
                res[i]=lirun;
            }else{
                res[i]=res[i-1];
            }


        }
        return res[n-1];
    }
}
