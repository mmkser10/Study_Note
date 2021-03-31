import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra_PQ{
    private int n;
    private List<Edge>[] graph;
    private class Edge implements Comparable<Edge> {
        int v, weight;

        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return weight + "";
        }

    }

    public Dijkstra_PQ(int n){
        this.n = n;
        graph = new ArrayList[n];
        for(int x = 0 ; x < n ; x++) {
            graph[x] = new ArrayList<>();
        }
    }

    public void put(int start, int end, int weight){
        graph[start-1].add(new Edge(end-1, weight));
    }


    public void putDouble(int start, int end, int weight){
        graph[start-1].add(new Edge(end-1, weight));
        graph[end-1].add(new Edge(start-1, weight));
    }

    public void searchDijkstra_PQ(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] check = new boolean[n];
        Edge[] distance = new Edge[n];

        for(int x = 0 ; x < n ; x++){
            if (x == start-1) {
                distance[x] = new Edge(x, 0);
            }
            else {
                distance[x] = new Edge(x, Integer.MAX_VALUE);
            }
            pq.add(distance[x]);
        }
        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            for(Edge next : graph[edge.v]){
                if(!check[next.v] && distance[next.v].weight > distance[edge.v].weight + next.weight) {
                    distance[next.v].weight = distance[edge.v].weight+next.weight;
                    pq.remove(distance[next.v]);
                    pq.add(distance[next.v]);
                }
            }
            check[edge.v] = true;
        }
        System.out.println(Arrays.toString(distance));
    }

    public static void main(String[] args) {
        Dijkstra_PQ dijkstra_pq = new Dijkstra_PQ(8);
        dijkstra_pq.put(1, 2, 3);
        dijkstra_pq.put(1, 5, 4);
        dijkstra_pq.put(1, 4, 4);
        dijkstra_pq.put(2, 3, 2);
        dijkstra_pq.put(3, 4, 1);
        dijkstra_pq.put(4, 5, 2);
        dijkstra_pq.put(5, 6, 4);
        dijkstra_pq.put(4, 7, 6);
        dijkstra_pq.put(7, 6, 3);
        dijkstra_pq.put(3, 8, 3);
        dijkstra_pq.put(6, 8, 2);
        dijkstra_pq.searchDijkstra_PQ(1);
    }
}
