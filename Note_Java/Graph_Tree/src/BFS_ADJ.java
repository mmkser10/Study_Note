import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS_ADJ {
    private int n;
    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] check;
    private Queue<Integer> queue;

    public BFS_ADJ(int n) {
        this.n = n;
        this.graph = new ArrayList<ArrayList<Integer>>();
        this.check = new boolean[n+1];
        queue = new LinkedList<>();

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

    public void searchBFS_ADJ(int start){
        check[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int index = queue.poll();
            System.out.print(index + " ");

            for(int data : graph.get(index)){
                if(check[data] == false) {
                    queue.offer(data);
                    check[data] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS(4);
        bfs.putDouble(1, 2);
        bfs.putDouble(1, 4);
        bfs.putDouble(2, 3);
        bfs.putDouble(3, 4);

        bfs.searchBFS(1);
    }
}
