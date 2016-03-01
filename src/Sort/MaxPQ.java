package Sort;

/**
 * Author: Calvin Meng
 * Blog: mclspace.com  Email: rdmclin2@gamil.com
 * Update: 2016-02-27 21:31
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] queue;
    private int N = 0;

    MaxPQ(int MAXN) {
        queue = (Key[]) new Comparable[MAXN + 1];
    }
    private boolean less(int a, int b){
        return  queue[a].compareTo(queue[b]) < 0;
    }
    private void exch(int a,int b){
        Key temp = queue[a];
        queue[a] = queue[b];
        queue[b] = temp;
    }

    private void swim(int k){
        while(k >1 && less(k/2,k)){
            exch(k,k/2);
            k = k/2;
        }
    }

    //add N && swim(N)
    public void insert(Key key) {
        queue[++N] = key;
        swim(N);
    }

    public Key delMax(){
        Key res = queue[1];
        exch(1,N--);
        queue[N+1] = null;
        sink(1);
        return res;
    }

    private void sink(int k){
        while(2*k <= N){
            int j = 2 *k;
            if(j+1 <=N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }
    public int Size(){
        return N;
    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(100);
        pq.insert(2);
        pq.insert(1);
        pq.insert(3);
        pq.insert(0);
        int N = pq.Size();
        for(int i = 0; i < N; i++)
            System.out.println(pq.delMax());
    }
}
