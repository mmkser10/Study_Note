import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int distance;

    public Edge(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(distance, o.distance);
    }
}
public class Kruskal {
    private int n;
    private PriorityQueue<Edge> pq;
    private int[] pivot;
    private int answer;

    public Kruskal(int n) {
        this.n = n;
        this.pq = new PriorityQueue<>();
        this.pivot = new int[n];
        this.answer = 0;
    }

    public void put(Edge edge){
        pq.add(edge);
    }

    public int findSet(int[] p, int x){
        if(p[x] == x) return x;
        else return p[x] = findSet(p, p[x]);
    }

    public void union(int[] p, int x, int y){
        if(x < y) p[findSet(p, y)] = findSet(p, x);
        else p[findSet(p, x)] = findSet(p, y);
    }

    public void searchKruskal(){
        int count = 0;
        for(int x = 0 ; x < n ; x++){
            pivot[x] = x;
        }

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(findSet(pivot, edge.start) != findSet(pivot, edge.end)){
                answer+= edge.distance;
                if(++count == n) break;
                union(pivot, edge.start, edge.end);
            }
        }
        System.out.println(answer);
    }

    public int getAnswer(){
        return this.answer;
    }

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal(4);
        kruskal.put(new Edge(0, 1, 1));
        kruskal.put(new Edge(0, 2, 2));
        kruskal.put(new Edge(1, 2, 5));
        kruskal.put(new Edge(1, 3, 1));
        kruskal.put(new Edge(2, 3, 8));
        kruskal.searchKruskal();
        System.out.println(kruskal.getAnswer());
    }
}
