class Node {

    Boolean done;
    Node[] letters;

    public Node(Boolean status) {
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
        for (char letter : word.toCharArray()) {
            if (curr.letters[letter - 97] == null) {
                curr.letters[letter - 97] = new Node(false);
            }
            curr = curr.letters[letter - 97];
        }
        curr.done = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (char letter : word.toCharArray()) {
            if (curr.letters[letter - 97] == null) {
                return false;
            }
            curr = curr.letters[letter - 97];
        }
        return curr.done;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char letter : prefix.toCharArray()) {
            if (curr.letters[letter - 97] == null) {
                return false;
            }
            curr = curr.letters[letter - 97];
        }
        return true;
    }
}
