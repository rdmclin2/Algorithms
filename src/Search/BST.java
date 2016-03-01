package Search;

/**
 * Author: Calvin Meng
 * Blog: mclspace.com  Email: rdmclin2@gamil.com
 * Update: 2016-02-28 21:32
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return get(x.left, key);
        else if (cmp < 0) return get(x.right, key);
        else return x.value;
    }

    private int size(Node x){
        if(x ==  null) return 0;
        else return  x.N;
    }

    public void put(Key key,Value value){
        root = put(root,key,value);
    }
    private Node put(Node x,Key key,Value value){
        if(x == null) return new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        if (cmp > 0) x.left = put(x.left, key,value);
        else if (cmp < 0) x.right = put(x.right, key,value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }

    public static void main(String[] args) {
        BST<String, Integer> st = new BST<>();
        st.put("C", 1);
        st.put("B", 2);
        st.put("A", 3);
        st.put("D", 4);

        System.out.println(st.get("A"));
    }
}
