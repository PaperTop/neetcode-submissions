//Efficiency improvements
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
                String cur = q.poll();
                if (target.equals(cur)) {
                    return res;
                }
                char[] chars = cur.toCharArray();
                for (int j = 0; j < 4; j++) {
                    chars[j] = (char)(((chars[j] - '0' + 1) % 10) + '0');   //add 1
                    String next = new String(chars);
                    if (ends.add(next)) {
                        q.offer(next);
                    }
                    chars[j] = (char)(((chars[j] - '0' + 8) % 10) + '0');    //down 1
                    next = new String(chars);
                    if (ends.add(next)) {
                        q.offer(next);
                    }
                    chars[j] = (char)(((chars[j] - '0' + 1) % 10) + '0');
                }
            }
            res++;
        }
        
        return -1;
    }
}