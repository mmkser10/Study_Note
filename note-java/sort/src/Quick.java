public class Quick extends Abstract{

    public static int quickSort(Comparable[] a, int left, int right){
        int mid = (left + right) / 2;
        exch(a, left, mid);


        Comparable pivot = a[left];
        int i = left, j = right;

        while (i < j) {
            while (pivot.compareTo(a[j]) < 0 ) {
                j--;
            }

            while (i < j && pivot.compareTo(a[i]) >= 0) {
                i++;
            }
            exch(a, i, j);
        }

        a[left] = a[i];
        a[i] = pivot;
        return i;
    }

    public static void sort(Comparable[] a, int left, int right){
        if (left >= right) {
            return;
        }

        int pivot = quickSort(a, left, right);
        sort(a, left, pivot - 1);
        sort(a, pivot + 1, right);
    }


    public static void main(String[] args) {
        Integer[] a = {10, 4, 5, 2, 1, 8, 3, 6};
        sort(a, 0, a.length-1);
    }
}
