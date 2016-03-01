package Search;

/**
 * Author: Calvin Meng
 * Blog: mclspace.com  Email: rdmclin2@gamil.com
 * Update: 2016-02-28 20:11
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int N = 0;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return keys.length == 0;
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int k = rank(key);
        if (k < N && keys[k].compareTo(key) == 0) return values[k];
        else return null;
    }

    public void put(Key key,Value value){
        int k = rank(key);
        if(k < N && keys[k].compareTo(key) == 0){
            values[k] = value;
            return ;
        }
        for(int i = N;i >k;i--){
            keys[i] = keys[i-1];
            values[i] =values[i-1];
        }
        keys[k] = key;
        values[k] = value;
        N++;
    }

    public int rank(Key key) {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = keys[mid].compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(8);
        st.put("C", 1);
        st.put("B", 2);
        st.put("A", 3);
        st.put("D", 4);

        System.out.println(st.get("A"));
    }

}
