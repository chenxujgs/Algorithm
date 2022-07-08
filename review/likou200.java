package suanfa.likou.review;

public class likou200 {
    public int numIslands(char[][] grid) {
        int nl=grid.length;
        int nr=grid[0].length;
        int sum=0;
        for (int i = 0; i <nl ; i++) {
            for (int j = 0; j <nr ; j++) {
                if(grid[i][j]=='1'){
                  sum++;
                  dfs(grid,i,j);
                }
            }
        }
        return sum;
    }
    private void dfs(char[][] grid, int x, int y) {
        int nl=grid.length;
        int nr=grid[0].length;

        if (x < 0 || y < 0 || x >= nl || y >= nr || grid[x][y] == '0') {
            return;
        }


        grid[x][y]='0';
        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);
    }
}