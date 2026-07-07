/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);

        Node currNode = head;
        while (currNode != null) {
            Node newNode = new Node(currNode.val);
            map.put(currNode, newNode);
            currNode = currNode.next;
        }

        currNode = head;
        while (currNode != null) {
            Node currCopy = map.get(currNode);
            currCopy.next = map.get(currNode.next);
            currCopy.random = map.get(currNode.random);
            currNode = currNode.next;
        }

        return map.get(head);
    }
}
