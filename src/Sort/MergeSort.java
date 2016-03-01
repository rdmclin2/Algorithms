package Sort;

/**
 * Author: Calvin Meng
 * Blog: mclspace.com  Email: rdmclin2@gamil.com
 * Update: 2016-02-27 14:19
 */
public class MergeSort {

    private static Comparable[] aux;

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void merge(Comparable[] a, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid)                 a[k] = aux[j++];
            else if (j > high)           a[k] = aux[i++];
            else if (less(aux[i], aux[j]))   a[k] = aux[i++];
            else                         a[k] = aux[j++];
        }
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }


    public static void main(String[] args) {
        Integer[] a = {4, 2, 3, 1};
        MergeSort.sort(a);
        assert isSorted(a);
        show(a);
    }
}
