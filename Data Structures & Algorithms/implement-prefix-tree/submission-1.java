//Optimzied of my original solution

class Node {

    boolean done;
    Node[] letters;

    public Node(boolean status) {
        this.done = status;
        this.letters = new Node[26];
    }
}

class PrefixTree {

    private Node root;
    
    public PrefixTree() {
         root = new Node(false);
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) { //removed word.toCharArray to use O(1) auxilary memory
            int idx = word.charAt(i) - 'a';
            if (curr.letters[idx] == null) {
                curr.letters[idx] = new Node(false);
            }
            curr = curr.letters[idx];
        }
        curr.done = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.letters[idx] == null) {
                return false;
            }
            curr = curr.letters[idx];
        }
        return curr.done;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.letters[idx] == null) {
                return false;
            }
            curr = curr.letters[idx];
        }
        return true;
    }
}
