package suanfa.likou.review;

public class likou62 {
    public static void main(String[] args) {
        System.out.println(new likou62().uniquePaths(3, 2));
    }
    public int uniquePaths(int m, int n) {
        int[][] db=new int[m][n];

        for (int i = 0; i <m ; i++) {
            db[i][0]=1;
        }
        for (int i = 0; i <n ; i++) {
            db[0][i]=1;
        }

        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                db[i][j]=db[i-1][j]+db[i][j-1];
            }
        }


        return db[m-1][n-1];
    }

    int[][] bols = new int[][]{{1, 0}, {0, 1}};
    private int dfs(int x, int y, int m, int n, boolean[][] visited, int index) {
        if(x==m-1&&y==n-1){
            index++;
            return index;
        }
        for (int[] bol : bols) {
            int xx = x + bol[0];
            int yy = y + bol[1];

            if (xx >= m || yy >= n) {
                continue;
            }
            if (!visited[xx][yy]) {
                visited[xx][yy] = true;
                index= dfs(xx, yy, m, n, visited, index);
                visited[xx][yy]=false;
            }
        }
        return index;
    }

}