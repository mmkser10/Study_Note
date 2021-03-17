public class Insertion extends Abstract {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int x = 1 ; x < N ; x++) {
            for (int y = x ; y > 0 && less(a[y], a[y-1]) ; y--) {
                exch(a, y, y-1);
            }
        }
        assert isSorted(a);
    }

    public static void main(String[] args) {
        Integer[] a = {10, 4, 5, 2, 1, 8, 3, 6};
        Insertion.sort(a);
        Insertion.show(a);
    }
}