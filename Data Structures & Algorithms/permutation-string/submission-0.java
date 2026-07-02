class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Optimation 
        if (s2.length() < s1.length()) {
            return false;
        }

        //Hashmap for the s1 counts
        HashMap<Character, Integer> s1Count = new HashMap<>();
        for (char letter : s1.toCharArray()) {
            s1Count.put(letter, s1Count.getOrDefault(letter, 0) + 1);
        }

        //Hashmap for the s2 window size counts
        HashMap<Character, Integer> s2Count = new HashMap<>();
        for (int i = 0; i < s1.length() - 1; i++) {
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
        }
        
        int l = 0;
        for (int r = s1.length() - 1; r < s2.length(); r++) {
            s2Count.put(s2.charAt(r), s2Count.getOrDefault(s2.charAt(r), 0) + 1);
            if (s2Count.equals(s1Count)) {
                return true;
            }
            if (s2Count.get(s2.charAt(l)) - 1 != 0) {
                s2Count.put(s2.charAt(l), s2Count.get(s2.charAt(l)) - 1);
            } else {
                s2Count.remove(s2.charAt(l));
            }
            l++;
        }

        return false;
    }
}
