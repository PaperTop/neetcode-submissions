//Give up
//strategy explaination: build it from the end to the beginning
//search for the node with no more adj that is the last one -> add to your solution then go backwards check that node if it has neighbors continue down those else add that node.....
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        //Sorts the neighbors of an airport by alphabetical
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket: tickets) {
            adj.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        LinkedList<String> res = new LinkedList<>();    //hold the solution as we build it
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String cur = stack.peek();
            if (!adj.containsKey(cur) || adj.get(cur).isEmpty()) {      //adds if the node has no more nodes meaning it is the last one, so append to the first
                res.addFirst(stack.pop());
            } else {
                stack.push(adj.get(cur).poll()); //keeps the history of the current dfs to go back to.
            }
        }

        return res;
    }
}
