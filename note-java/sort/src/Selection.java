public class Selection extends Abstract {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int x = 0; x < N - 1; x++) {
            int min = x;
            for (int y = x + 1 ; y < N ; y++) {
                if (less(a[y], a[min]))
                    min = y;
            }
            exch(a, x, min);
        }
        assert isSorted(a);
    }

    public static void main(String[] args) {
        Integer[] a = {10, 4, 5, 2, 1, 8, 3, 6};
        Selection.sort(a);
        Selection.show(a);
    }
}