public class Shell extends Abstract {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while(h < N/3){
            h = 1+3*h;
        }
        while(h >= 1){
            for(int x = h ; h < N ; x++){
                for(int y = x ; y >= h && less(a[y], a[y-h]); y -= h){
                    exch(a, y, y-h);
                }
                h /= 3;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {10, 4, 5, 2, 1, 8, 3, 6};
        Shell.sort(a);
        Shell.show(a);
    }
}