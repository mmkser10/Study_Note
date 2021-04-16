import java.util.Arrays;

public class Merge extends Abstract{

    public static void sort(Comparable[] a, int left, int right){
        if(left < right) {
            int mid = (left + right) / 2;
            sort(a, left, mid);
            sort(a, mid + 1, right);
            mergeSort(a, left, mid, right);
        }
    }

    public static void mergeSort(Comparable[] a, int left, int mid, int right){
        Comparable[] L = Arrays.copyOfRange(a, left, mid+1);
        Comparable[] R = Arrays.copyOfRange(a, mid+1, right+1);

        int x = 0;  int y = 0;
        int k = left;
        int lN = L.length; int rN = R.length;

        while(x < lN && y < rN){
            if(less(L[x],  R[y]))
                a[k] = L[x++];
            else
                a[k] = R[y++];
            k++;
        }

        while(x < lN){
            a[k++] = L[x++];
        }
        while(y < rN){
            a[k++] = R[y++];
        }
    }

    public static void main(String[] args) {
        Integer[] a = {10, 4, 5, 2, 1, 8, 3, 6};
        sort(a, 0, a.length-1);
    }
}
