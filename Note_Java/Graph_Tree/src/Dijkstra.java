import java.util.Arrays;

public class Dijkstra {
    private int n;
    private int[][] graph;

    public Dijkstra(int n){
        this.n = n;
        this.graph = new int[n][n];
    }

    public void put(int start, int end, int weight){
        graph[start-1][end-1] = weight;
    }

    public void searchDijkstra(int start){
        int[] distance = new int[n];
        boolean[] check = new boolean[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start-1] = 0;

        for(int x = 0 ; x < n-1 ; x++){
            int min = Integer.MAX_VALUE;
            int index = -1;

            for(int y = 0 ; y < n ; y++){
                if(!check[y] && min > distance[y]){
                    index = y;
                    min = distance[y];
                }
            }

            for(int y = 0 ; y < n ; y++){
                if(
                        !check[y]
                        && graph[index][y] != 0
                        && distance[index] != Integer.MAX_VALUE
                        && distance[index] + graph[index][y] < distance[y])
                {
                    distance[y] = distance[index] + graph[index][y];
                }
            }
            check[index] = true;
        }
        System.out.println(Arrays.toString(distance));
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(8);
        dijkstra.put(1, 2, 3);
        dijkstra.put(1, 5, 4);
        dijkstra.put(1, 4, 4);
        dijkstra.put(2, 3, 2);
        dijkstra.put(3, 4, 1);
        dijkstra.put(4, 5, 2);
        dijkstra.put(5, 6, 4);
        dijkstra.put(4, 7, 6);
        dijkstra.put(7, 6, 3);
        dijkstra.put(3, 8, 3);
        dijkstra.put(6, 8, 2);
        dijkstra.searchDijkstra(1);
    }
}
