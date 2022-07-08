package suanfa.likou.review;

public class likou70 {
    public static void main(String[] args) {
//        System.out.println(likou70.climbStairs(1));
//        System.out.println(likou70.climbStairs(4));
//        System.out.println(likou70.climbStairs(5));
//        System.out.println(likou70.climbStairs(6));
//        System.out.println(likou70.climbStairs(7));
        System.out.println(likou70.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int climbStairs(int n) {
        if(n<3) return n;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            res[i] = res[i - 2] + res[i - 1];
        }
        return res[n];
    }

    public static int climbStairs1(int n) {
        if(n<3) return n;
       int l=1,r=2,p=0;

        for (int i = 3; i < n + 1; i++) {
          p=r+l;
          l=r;
          r=p;
        }
        return p;
    }

    /**
     * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
     *
     * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] result=new int[n+1];
        result[0]=result[1]=0;
        for (int i = 2; i <=n ; i++) {
            result[i]=Math.min(result[i-2]+cost[i-2],result[i-1]+cost[i-1]);
        }
        return result[n];
    }
}
