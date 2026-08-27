class Pair {
    String word;
    int length;

    Pair (String s, int l) {
        word = s;
        length = l;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> allWords = new HashSet<>();

        for (String word : wordList) {
            allWords.add(word);
        }

        int shortest = 1000;
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            String currWord = curr.word;
            int currLength = curr.length;

            //check if end
            if (currWord.equals(endWord)) {
                shortest = Math.min(shortest, currLength);
                continue;
            }
            //continue with process
            for (int i = 0; i < currWord.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    char letter = (char) ('a' + j);
                    String possibleWord = currWord.substring(0, i) + letter + currWord.substring(i + 1, currWord.length());
                    if (!possibleWord.equals(currWord) && allWords.contains(possibleWord)) {
                        allWords.remove(currWord);
                        q.offer(new Pair(possibleWord, currLength + 1));
                    }
                }
            }
        }
        if (shortest == 1000) {
            return 0;
        }
        return shortest;
    }
}
