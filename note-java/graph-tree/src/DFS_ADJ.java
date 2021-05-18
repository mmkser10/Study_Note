import java.util.ArrayList;

class DFS_ADJ {
    private int n;
    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] check;

    public DFS_ADJ(int n){
        this.n = n;
        this.graph = new ArrayList<ArrayList<Integer>>();
        this.check = new boolean[n+1];

        for(int x = 0 ; x < n+1 ; x++){
            this.graph.add(new ArrayList<Integer>());
        }
    }

    public void putSingle(int start, int end){
        graph.get(start).add(end);
    }

    public void putDouble(int start, int end){
        graph.get(start).add(end);
        graph.get(end).add(start);
    }

    public void searchDFS_ADJ(int start){
        check[start] = true;
        System.out.print(start + " ");

        for(int x : graph.get(start)){
            if(check[x] == false)
                searchDFS_ADJ(x);
        }
    }

    public static void main(String[] args) {
        DFS_ADJ dfs_adj = new DFS_ADJ(8);
        dfs_adj.putDouble(1, 2);
        dfs_adj.putDouble(1, 3);
        dfs_adj.putDouble(2, 4);
        dfs_adj.putDouble(2, 5);
        dfs_adj.putDouble(3, 6);
        dfs_adj.putDouble(3, 7);
        dfs_adj.putDouble(4, 8);
        dfs_adj.putDouble(5, 8);
        dfs_adj.putDouble(6, 8);
        dfs_adj.putDouble(7, 8);


        dfs_adj.searchDFS_ADJ(1);
    }
}
