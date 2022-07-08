package suanfa.likou.A20220702;

/**
 * 找到数组的最大连续子序列
 */
public class likou19 {
    public static void main(String[] args) {
        likou19 l = new likou19();
        System.out.println(l.maxsumofSubarray(new int[]{1, -2, -2, -2, -2, 6, -1}));
    }

    /**
     * 思路: 遍历一整串,每增加一个索引,加上之前的最大值,若小于0,不符合题意
     * @param arr
     * @return
     */
    public int maxsumofSubarray(int[] arr) {
        int sum = 0;
        int thissum = 0;
        for (int i = 0; i < arr.length; i++) {
            thissum += arr[i];
            if (thissum < 0) {
                thissum = 0;
            }
            if (thissum > sum) {
                sum = thissum;
            }
        }
        return sum;
    }
}
