package suanfa.likou.review;

public class likou547 {
    public static void main(String[] args) {
        System.out.println(new likou547().findCircleNum(new int[][]{{1, 1, 0}, {0, 0, 1}, {1, 1, 0}}));
    }
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int num = 0;

        for (int i = 0; i < len; i++) {
          if(!visited[i]){
              dfs(isConnected,visited,i,len);
              num++;
          }
        }
        return num;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i,int len) {
        for (int j = 0; j < len; j++) {
            if(isConnected[i][j]==1&&!visited[j]){
                visited[j]=true;
                dfs(isConnected, visited, j, len);
            }
        }
    }
}
