class DFS {
    private int n;
    private int[][] graph;
    private boolean[] check;

    public DFS(int n) {
        this.n = n;
        this.graph = new int[n][n];
        this.check = new boolean[n];
    }

    public void putSingle(int start, int end){
        graph[start-1][end-1] = 1;
    }

    public void putDouble(int start, int end){
        graph[start-1][end-1] = 1;
        graph[end-1][start-1] = 1;
    }

    public void searchDFS(int start){
        check[start-1] = true;
        System.out.print(start + " ");

        for(int x = 1 ; x <= n ; x++){
            if(graph[start-1][x-1] == 1 && check[x-1] == false)
                searchDFS(x);
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS(8);
        dfs.putDouble(1, 2);
        dfs.putDouble(1, 3);
        dfs.putDouble(2, 4);
        dfs.putDouble(2, 5);
        dfs.putDouble(3, 6);
        dfs.putDouble(3, 7);
        dfs.putDouble(4, 8);
        dfs.putDouble(5, 8);
        dfs.putDouble(6, 8);
        dfs.putDouble(7, 8);


        dfs.searchDFS(2);
    }
}
