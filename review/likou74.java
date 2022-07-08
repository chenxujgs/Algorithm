package suanfa.likou.review;

public class likou74 {
    public static void main(String[] args) {
       //boolean b = likou74.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3);
        boolean b = likou74.searchMatrix(new int[][]{{1},{2}}, 3);
        System.out.println(b);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
         int m=matrix.length;
         int n=matrix[0].length;
         int start=0,end=m*n-1;
         while (start<=end){
             int mid=(start+end)>>1;
             int line=mid/n;
             int column=mid%n;
            System.out.println(line+" "+column);
             if(matrix[line][column]>target){
                 end=mid-1;
             }else if (matrix[line][column]<target){
                 start=mid+1;
             }else{
                 return true;
             }

         }
        return false;
    }
}
