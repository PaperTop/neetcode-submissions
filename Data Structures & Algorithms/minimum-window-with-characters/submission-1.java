class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char letter : t.toCharArray()) {
            tCount.put(letter, tCount.getOrDefault(letter, 0) + 1);
        }

        String res = "";
        HashMap<Character, Integer> sCount = new HashMap<>();
        int l = 0;
        int have = 0, need = tCount.size();
        for (int r = 0; r < s.length(); r++) {
            if (tCount.containsKey(s.charAt(r))) {
                sCount.put(s.charAt(r), sCount.getOrDefault(s.charAt(r), 0) + 1);
                if (sCount.get(s.charAt(r)).equals(tCount.get(s.charAt(r)))) {
                    have++;
                }
            }
            while (have == need) {
                if (res.equals("") || r - l + 1 < res.length()) {
                    res = s.substring(l, r + 1);
                }
                
                if (tCount.containsKey(s.charAt(l))) {
                    if (sCount.get(s.charAt(l)) - 1 == 0) {
                        sCount.remove(s.charAt(l));
                        have--;
                    } else {
                        sCount.put(s.charAt(l), sCount.get(s.charAt(l)) - 1);
                        if (sCount.get(s.charAt(l)) < tCount.get(s.charAt(l))) {
                            have--;
                        }
                    }
                    
                }
                l++;
            }
        }

        return res;
    }

    public boolean isValid(HashMap<Character, Integer> tCount , HashMap<Character, Integer> sCount) {
        for (char c : tCount.keySet()) {
            if (sCount.getOrDefault(c, 0) < tCount.get(c)) {
                return false;
            }
        }
        return true;
    }


}
