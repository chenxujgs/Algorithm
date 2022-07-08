package suanfa.likou.review;

public class likou1014 {
    public static void main(String[] args) {
        System.out.println(new likou1014().maxScoreSightseeingPair(new int[]{8, 1, 6}));
    }

    /**
     * 思路主要将values[i] + values[j] + i - j 转化为values[i]+i +values[j]-j
     * 在循环中,values[j]-j 总是固定的,主要是最大化values[i]+i
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;

        int temp = values[0], max = 0;
        for (int i = 1; i < len; i++) {
            // 求出最大的结果
            max = Math.max(max, temp + values[i] - i);
            // 求出最大的values[i]+i,以便下次使用
            temp = Math.max(temp, values[i] + i);
        }
        return max;
    }
}