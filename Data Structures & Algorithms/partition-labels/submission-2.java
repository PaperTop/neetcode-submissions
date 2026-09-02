/*
Optimizations: Instead of storing the count and iterating down just store the last index and continuusly update it until you reached the end. Could use an array instead of hashmap to avoid overhead
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}
