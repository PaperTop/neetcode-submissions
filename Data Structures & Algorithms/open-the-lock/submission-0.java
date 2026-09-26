//Strat: BFS to try every single possitibility
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> ends = new HashSet<>();
        for (String s : deadends){
            ends.add(s);
        }
        if (ends.contains("0000")) {
            return -1;
        }

        int res = 0;
        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");
        ends.add("0000");

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                StringBuilder cur = new StringBuilder(q.poll());
                if (target.equals(cur.toString())) {
                    return res;
                }
                for (int j = 0; j < 4; j++) {
                    char up = (char)(((cur.charAt(j) - '0' + 1) % 10) + '0');   //add 1
                    cur.setCharAt(j, up);
                    if (!ends.contains(cur.toString())) {
                        q.offer(cur.toString());
                        ends.add(cur.toString());
                    }
                    char down = (char)(((cur.charAt(j) - '0' + 8) % 10) + '0');    //down 1
                    cur.setCharAt(j, down);
                    if (!ends.contains(cur.toString())) {
                        q.offer(cur.toString());
                        ends.add(cur.toString());
                    }
                    char reset = (char)(((cur.charAt(j) - '0' + 1) % 10) + '0');
                    cur.setCharAt(j, reset);
                }
            }
            res++;
        }
        
        return -1;
    }
}