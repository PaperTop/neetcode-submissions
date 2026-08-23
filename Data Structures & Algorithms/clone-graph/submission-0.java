/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {    
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        
        q.offer(node);
        map.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node n : curr.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    q.offer(n);
                }
            }           
        }

        Set<Node> completed = new HashSet<>();
        q.offer(node);
        completed.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            Node copyCurr = map.get(curr);
            for (Node n : curr.neighbors) {
                Node copyBranch = map.get(n);
                copyCurr.neighbors.add(copyBranch);
                if (!completed.contains(n)) {
                    q.offer(n);
                    completed.add(n);
                }
            }
        }

        return map.get(node);
    }
}