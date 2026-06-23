class Solution {
    public String encode(List<String> strs) {
        int capacity = 0;

        for (String s : strs) {
            capacity += s.length() + 2;
        }

        StringBuilder res = new StringBuilder(capacity);

        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = str.length();

        while (i < n) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            int end = start + length;

            res.add(str.substring(start, end));
            i = end;
        }

        return res;
    }
}