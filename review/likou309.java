package suanfa.likou.review;

public class likou309 {
    public int maxProfit(int[] prices) {
       int len=prices.length;
       int[][] db=new int[len][2];
       db[0][0]=0;
       db[0][1]=-prices[0];
        for (int i = 1; i <len ; i++) {
            db[i][0]=Math.max(db[i-1][0],db[i-1][1]+prices[i]);
            db[i][1]=Math.max(db[i-1][1],db[i-1][0]-prices[i]);
        }

        return len;
    }
}
