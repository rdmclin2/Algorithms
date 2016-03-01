package Sort;

import java.util.Arrays;

/**
 * Author: Calvin Meng
 * Blog: mclspace.com  Email: rdmclin2@gamil.com
 * Update: 2016-02-27 22:16
 */
public class HeapSort {

    private static void exch(Comparable[] queue,int a,int b){
        Comparable temp = queue[a-1];
        queue[a-1] = queue[b-1];
        queue[b-1] = temp;
    }
    private static boolean less(Comparable[] queue,int a, int b){
        return  queue[a-1].compareTo(queue[b-1]) < 0;
    }

    private static void sink(Comparable[] queue,int k,int N){
        while(2*k <= N){
            int j = 2 *k;
            if(j+1 <=N && less(queue,j,j+1)) j++;
            if(!less(queue,k,j)) break;
            exch(queue,k,j);
            k = j;
        }
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        for(int k = N/2;k >= 1;k--){
            sink(a,k,N);
        }
        while(N >1){
            exch(a,1,N--);
            sink(a,1,N);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {4,6,3,2,1};
        HeapSort.sort(a);
        System.out.println(Arrays.toString(a));
    }


}
