class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] n = s.toCharArray();
        int res = 0;
        for (int i = 0; i < n.length - 1; i++) {
            if (map.get(n[i]) < map.get(n[i + 1])) {
                res -= map.get(n[i]);
            } else {
                res += map.get(n[i]);
            }
        }
        res += map.get(n[n.length - 1]);
        return res;
    }
}