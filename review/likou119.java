package suanfa.likou.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxj
 * @date 2022/1/24
 * @description 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class likou119 {
    public static void main(String[] args) {
        System.out.println(likou119.getRow2(1));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex > 0) {
            res.add(1);
            int[][] temp = new int[rowIndex + 1][rowIndex + 1];
            for (int i = 0; i < rowIndex + 1; i++) {
                temp[i][rowIndex] = 1;
            }

            for (int i = 1; i < rowIndex + 1; i++) {
                for (int j = rowIndex - 1; j >= rowIndex - i; j--) {
                    temp[i][j] = temp[i - 1][j] + temp[i - 1][j + 1];
                }
            }
            for (int i = 1; i <= rowIndex - 1; i++) {
                res.add(temp[rowIndex][i]);
            }
        }
        res.add(1);

        return res;
    }

    public static List<Integer> getRow2(int rowIndex) {
        if (rowIndex < 1) return new ArrayList<Integer>() {{
            add(1);
        }};
        List<Integer> res = new ArrayList<>();
        int[] temp = new int[rowIndex + 1];
        temp[rowIndex] = 1;
        temp[rowIndex - 1] = 1;
        for (int i = 2; i < rowIndex + 1; i++) {
            temp[rowIndex - i] = 1;
            for (int j = i; j > 1; j--) {
                temp[rowIndex - j + 1] = temp[rowIndex - j + 1] + temp[rowIndex - j + 2];
            }
        }
        for (int i = 0; i <= rowIndex; i++) {
            res.add(temp[i]);
        }


        return res;
    }

}
