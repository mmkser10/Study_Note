public abstract class Abstract {

    public static void sort(Comparable[] a) { };

    protected static boolean less(Comparable v, Comparable w) { return v.compareTo(w) < 0; }

    protected static void exch(Comparable[] a, int x, int y){
        Comparable t = a[x] ;
        a[x] = a[y];
        a[y] = t;
    }

    protected static void show(Comparable[] a) {
        for ( int x = 0; x < a.length; x++ )
            System.out.print(a[x] + " ");
        System.out.println();
    }

    protected static boolean isSorted(Comparable[] a) {
        for(int x= 1 ; x < a.length ; x++)
            if(less(a[x], a[x-1]))
                return false;
        return true;
    }
}