//Stratey wanted to create a bunch of nodes that point higher
class Node {
    Set<Node> parents;
    Set<Node> children;
    char letter;

    Node(char l) {
        parents = new HashSet<>();
        children = new HashSet<>();
        letter = l;
    }
}

class Solution {
    public String foreignDictionary(String[] words) {
        //Build graph first
        Node[] nodes = new Node[26];
        int count = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (nodes[word.charAt(i) - 'a'] == null) {
                    count++;
                    nodes[word.charAt(i) - 'a'] = new Node(word.charAt(i));
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i], second = words[i + 1];
            boolean diff = false;
            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                char a = first.charAt(j), b = second.charAt(j);
                if (a != b) {
                    //Connect them
                    nodes[a - 'a'].children.add(nodes[b - 'a']);
                    nodes[b - 'a'].parents.add(nodes[a - 'a']);
                    diff = true;
                    break;
                }
            }
            //check if pair is invalid
            if (!diff && first.length() > second.length()) {
                return "";
            }
        }
        //build it
        StringBuilder res = new StringBuilder();
        Queue<Node> q = new ArrayDeque<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && nodes[i].parents.size() == 0) {
                q.offer(nodes[i]);
            }
        }
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            res.append(cur.letter);
            for (Node child : cur.children) {
                child.parents.remove(cur);
                if (child.parents.size() == 0) {
                    q.offer(child);
                }
            }
        }

        if (count != res.length()) {
            return "";
        }

        return res.toString();
    }
}
