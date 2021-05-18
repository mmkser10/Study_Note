public class Heap extends Abstract{
    public static void heapify(Comparable[] a, int n, int i) {
        int p = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        if (l < n && less(a[p], a[l]) ) {
            p = l;
        }

        if (r < n && less(a[p], a[r])) {
            p = r;
        }

        if (i != p) {
            exch(a, p, i);
            heapify(a, n, p);
        }
    }

    public static void sort(Comparable[] a) {
        int n = a.length;

        // init, max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        // for extract max element from heap
        for (int i = n - 1; i > 0; i--) {
            exch(a, 0, i);
            heapify(a, i, 0);
        }
    }


    public static void main(String[] args) {
        Integer[] a = {10, 4, 5, 2, 1, 8, 3, 6};
        sort(a);
    }
}
