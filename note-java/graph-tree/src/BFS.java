import java.util.LinkedList;
import java.util.Queue;

class BFS {
    private int n;
    private int[][] graph;
    private boolean[] check;
    private Queue<Integer> queue;

    public BFS(int n) {
        this.n = n;
        this.graph = new int[n][n];
        this.check = new boolean[n];
        queue = new LinkedList<>();
    }

    public void putSingle(int start, int end){
        graph[start-1][end-1] = 1;
    }

    public void putDouble(int start, int end){
        graph[start-1][end-1] = 1;
        graph[end-1][start-1] = 1;
    }

    public void searchBFS(int start){
        check[start-1] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int index = queue.poll();
            System.out.print(index + " ");
            for(int x = 1 ; x <= n ; x++){
                if(check[x-1] == false && graph[index-1][x-1] == 1){
                    queue.offer(x);
                    check[x-1] = true;
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
