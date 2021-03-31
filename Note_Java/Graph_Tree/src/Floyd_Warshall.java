public class Floyd_Warshall {
    private int n;
    private int[][] graph;

    public Floyd_Warshall(int n){
        this.n = n;
        this.graph = new int[n+1][n+1];
    }

    public void put(int start, int end, int weight){
        graph[start][end] = weight;
    }

    public int resultReturn(int start, int end){
        return graph[start][end];
    }

    public void printGraph(){
        for(int x = 1 ; x < n ; x++){
            for(int y = 1 ; y < n ; y++){
                System.out.print(graph[x][y] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    public void searchFloyd_Warshall(){
        for(int x = 0; x <= n ;x++)
        {
            for(int y = 0; y <= n ;y++)
            {
                if(x != y)
                    graph[x][y] = Integer.MAX_VALUE;
            }
        }
        for(int x = 1; x <= n; x++){
            for(int y = 1; y <= n; y++){
                if(x != y) {
                    for (int k = 1; k <= n; k++) {
                        if(y != k && x != k){
                            if(graph[y][k] > graph[y][x] + graph[x][k]){
                                graph[y][k] = graph[y][x] + graph[x][k];
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Floyd_Warshall floyd_warshall = new Floyd_Warshall(8);
        floyd_warshall.put(1, 2, 3);
        floyd_warshall.put(1, 5, 4);
        floyd_warshall.put(1, 4, 4);
        floyd_warshall.put(2, 3, 2);
        floyd_warshall.put(3, 4, 1);
        floyd_warshall.put(4, 5, 2);
        floyd_warshall.put(5, 6, 4);
        floyd_warshall.put(4, 7, 6);
        floyd_warshall.put(7, 6, 3);
        floyd_warshall.put(3, 8, 3);
        floyd_warshall.put(6, 8, 2);
        floyd_warshall.printGraph();
        floyd_warshall.searchFloyd_Warshall();
        floyd_warshall.printGraph();

    }
}
