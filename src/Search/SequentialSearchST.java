package Search;

/**
 * Author: Calvin Meng
 * Blog: mclspace.com  Email: rdmclin2@gamil.com
 * Update: 2016-02-28 19:56
 */
public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;

        }
    }

    public Value get(Key key) {
        for (Node node = first; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node node = first; node != null; node = node.next) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        st.put("A", 1);
        st.put("B", 2);
        st.put("C", 3);
        st.put("D", 4);

        System.out.println(st.get("C"));
        return ;

    }


}
