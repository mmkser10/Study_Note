public class Bubble extends Abstract{

    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int x = 0 ; x < N-1 ; x++){
            for(int y = 1 ; y < N ; y++){
                if(less(a[y], a[y-1])){
                    exch(a, y, y-1);
                }
            }
        }
        assert isSorted(a);
    }

    public static void main(String[] args) {
        Integer[] a = {10, 4, 5, 2, 1, 8, 3, 6};
        Bubble.sort(a);
    }
}
