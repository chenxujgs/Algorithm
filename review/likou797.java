package suanfa.likou.review;

import java.util.ArrayList;
import java.util.List;

public class likou797 {
    public static void main(String[] args) {
        System.out.println(new likou797().allPathsSourceTarget(new int[][]{{4,3,1}, {3,2,4}, {3}, {4},{}}));
    }
    List<List<Integer>> lists=new ArrayList<>();
    List<Integer> list=new ArrayList<Integer>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int n=graph.length;
            list.add(0);
            dfs(graph,0,n);


        return lists;
    }

    private void dfs(int[][] graph, int i,int n) {

        if(i==n-1) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int j = 0; j <graph[i].length ; j++) {
            list.add(graph[i][j]);
            dfs(graph,graph[i][j],n);
            list.remove(list.size()-1);
        }

    }


}
