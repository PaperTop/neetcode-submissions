/*
Strategy: Keep a hashmap count of everthing. Go through the list keeping track of what letters are in your current substring that have greater than 0 counts, once those hit 0 end that substring. Should be O(n) time and O(m) space for unique characters
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        Set<Character> need = new HashSet<>();
        int sub = 0;

        for (int i = 0; i < s.length(); i++) {
            need.add(s.charAt(i));
            count.put(s.charAt(i), count.get(s.charAt(i)) - 1);
            sub++;

            if (count.get(s.charAt(i)) == 0) {
                need.remove(s.charAt(i));
            }
            if (need.size() == 0) {
                res.add(sub);
                sub = 0;
            }
        }

        return res;
    }
}
