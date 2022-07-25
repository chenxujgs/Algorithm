package suanfa.likou.A20220725;

import java.util.ArrayList;

/**
 * 你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class likou57 {
    public static void main(String[] args) {
        new likou57().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        //new likou57().insert(new int[][]{{1, 5}}, new int[]{6, 8});
    }

    /**
     * 区间的特点就是有序,可按三部分(左不重合,重合,右不重合)分别进行编码
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int i = 0;
        // 判断左边不重合
        while (i < len && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        // 判断重合
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);
        // 判断右边不重合
        while (i < len && intervals[i][0] > newInterval[1]) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);

    }
}
