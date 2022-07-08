package suanfa.likou.review;

import java.util.LinkedList;
import java.util.Queue;

public class likou130 {
    public static void main(String[] args) {
        new likou130().solve1(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
        new likou130().solve(new char[][]{{'X'},{'O'}});
    }
    int m,n;
    public void solve(char[][] board) {
         m=board.length;
         n= board[0].length;
        int[][] location=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] bol=new boolean[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
               if(board[i][j]=='O'){
                   updateToX(board,i,j,m,n,location,bol);
               }
            }
        }
    }

    private void updateToX(char[][] board, int x, int y,int m,int n,int[][] location,boolean[][] bol) {
        if(x!=0&&y!=0&&x!=m-1&&y!=n-1){
            board[x][y]='X';
        }
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{x,y});

        bol[x][y]=true;
        boolean temp=false;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            if(poll[0]==0||poll[1]==0||x==m-1||y==n-1){
                temp=true;
            }
        for (int[] loc : location) {
            int x1 = poll[0] + loc[0];
            int y1 = poll[1] + loc[1];

            if (x1 >= m || x1 < 0 || y1 >= n || y1 < 0) {
                continue;
            }

            if(board[x1][y1]=='O') {
                if (temp) {
                    bol[x1][y1] = true;
                    queue.offer(new int[]{x1,y1});
                    continue;
                }

                if(bol[x1][y1]==false){
                    board[x1][y1]='X';
                    bol[x1][y1] = true;
                    queue.offer(new int[]{x1,y1});
                }
            }

        }
        temp=false;
        }
    }

    public void solve1(char[][] board) {
         m=board.length;
         n= board[0].length;

        for (int i = 0; i <m ; i++) {
            dfs(board,i,0);
            dfs(board,i,n-1);
        }

        for (int i = 1; i <n-1 ; i++) {
            dfs(board,0,i);
            dfs(board,m-1,i);
        }

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(board[i][j]=='A'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    private void dfs(char[][] board, int x, int y) {
        if (x >= m || x < 0 || y >= n || y < 0||board[x][y]!='O') {
            return;
        }

        board[x][y] = 'A';

        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}
