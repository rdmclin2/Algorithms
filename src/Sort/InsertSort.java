package Sort;

/**
 * Author: Calvin Meng
 * Blog: mclspace.com  Email: rdmclin2@gamil.com
 * Update: 2016-02-26 21:58
 */
public class InsertSort {
    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] =temp;
    }

    private static void show(Comparable[]a){
        for(int i = 0 ; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[]a){
        for(int i = 1 ; i < a.length; i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void sort(Comparable []a){
        for(int i = 1 ; i < a.length; i ++) {
            Comparable temp = a[i];
            int j = i;
            for(;j>0 && less(temp,a[j-1]);j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }


    public static void main(String[] args) {
        Integer[] a = {4,2,3,1};
        InsertSort.sort(a);
        assert isSorted(a);
        show(a);
    }
}
