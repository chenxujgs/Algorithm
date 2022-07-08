package suanfa.likou.review;

public class likou79 {
    public static void main(String[] args) {
        System.out.println(new likou79().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
    int m,n;
    int[][] loc=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
       boolean[][] bol=new boolean[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(board[i][j]==word.charAt(0)){
                   if(isexist(board,word,bol,i,j,0)){
                       return true;
                   }
                }
            }
        }
        return false;
    }

    private boolean isexist(char[][] board, String word, boolean[][] bol, int x, int y,int start) {

       if(start==word.length()-1){
           return board[x][y]==word.charAt(start);
       }
       if(board[x][y]==word.charAt(start)){
           bol[x][y]=true;
           for (int i = 0; i <loc.length ; i++) {
               int xx=x+loc[i][0];
               int yy=y+loc[i][1];
               if(isArea(xx,yy)&&!bol[xx][yy]) {
                   if (isexist(board, word, bol, xx, yy, start + 1)) {
                       return true;
                   }
               }
           }

       }

        return false;
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


}