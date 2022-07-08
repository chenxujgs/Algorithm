package suanfa.likou.review;

/**
 * @author cxj
 * @date 2022/2/2
 * @description
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 */
public class likou48 {
    public static void main(String[] args) {
       new likou48().swap(1,2);
    }
    public void rotate(int[][] matrix) {
        int n= matrix.length;
       //水平翻转
        for (int i = 0; i <n>>1 ; i++) {
            for (int j = 0; j <n ; j++) {
                swap(matrix[i][j],matrix[n-i-1][j]);
            }
        }

        // 垂直翻转
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <i ; j++) {
                swap(matrix[i][j],matrix[j][i]);
            }
        }
    }
    private void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
        System.out.println(a+" "+b);
    }
}
