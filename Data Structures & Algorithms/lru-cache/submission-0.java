public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int cap;
    private HashMap<Integer, Node> nodes;
    private Node dumbLeft;
    private Node dumbRight;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.nodes = new HashMap<>();
        this.dumbLeft = new Node(0, 0);
        this.dumbRight = new Node(0, 0);
        this.dumbLeft.next = this.dumbRight;
        this.dumbRight.prev = this.dumbLeft;
    }
    
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    private void insert(Node node) {
        Node prev = this.dumbRight.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.dumbRight;
        this.dumbRight.prev = node;
    }

    public int get(int key) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            remove(node);
            insert(node);
            return nodes.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            node.val = value;
            remove(node);
            insert(node);
        }
        else {
            if (nodes.size() >= cap) {
                Node lru = this.dumbLeft.next;
                remove(lru);
                nodes.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            nodes.put(key, newNode);
            insert(newNode);
        }
    }
}
