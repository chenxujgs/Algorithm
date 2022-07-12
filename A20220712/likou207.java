package suanfa.likou.A20220712;

import java.util.ArrayList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class likou207 {
    public static void main(String[] args) {
        System.out.println(new likou207().canFinish(3, new int[][]{{1, 0}, {0, 2}}));
    }

    /**
     * 思路: 先将数组组合成图,方便查找
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }

        // 组合图
        for (int[] prerequisite : prerequisites) {
            lists.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] marked = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, lists, marked)) {
                return false;
            }
        }
        return true;
    }

    /**
     * marked[i] 1 遍历中 0 未遍历 2 遍历结束
     * 1 表示遍历中或者有环
     * 若当前集合递归时递归到marked[i]为1,则表示marked[1]已递归过,重新递归到表示有环
     * 只有为2表示正常递归结束,无中间返回
     *
     * @param index
     * @param lists
     * @param marked
     * @return
     */
    private boolean dfs(int index, List<List<Integer>> lists, int[] marked) {
        if (marked[index] == 1) {
            return true;
        }

        if (marked[index] == 2) {
            return false;
        }

        marked[index] = 1;
        List<Integer> list = lists.get(index);
        for (Integer integer : list) {
            if (dfs(integer, lists, marked)) {
                return true;
            }
        }

        marked[index] = 2;

        return false;
    }

}
