package suanfa.likou.review;

/**
 * @author cxj
 * @date 2022/2/11
 * @description 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 targe
 */
public class likou240 {
    public static void main(String[] args) {
        System.out.println(new likou240().searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
  //      System.out.println(new likou240().searchMatrix(new int[][]{ {-1,3}}, 3));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        int n= matrix[0].length;
        int cow=0;
        int line=n-1;
        while(cow<m&&line>=0){
            if(matrix[ cow][line]>target){
                line--;
            }else if(matrix[cow][line]<target){
                cow++;
            }else{
                return true;
            }
        }
        return false;
    }
}
