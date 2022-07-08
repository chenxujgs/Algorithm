package suanfa.likou.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxj
 * @date 2022/6/26
 * @description
 *///给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
public class likou54 {
    public static void main(String[] args) {
        System.out.println(new likou54().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length - 1, n = matrix[0].length - 1;
        int top = 0, bottom = m, left = 0, right = n;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if(right>left&&top<bottom){
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                for (int i = bottom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }

            top++;
            bottom--;
            left++;
            right--;
        }
        return list;
    }
}
