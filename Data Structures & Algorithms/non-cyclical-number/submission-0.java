class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (n != 1) {
            if (visited.contains(n)) {
                return false;
            }
            visited.add(n);
            int newN = 0;
            while (n != 0) {
                newN += (n % 10) * (n % 10);
                n /= 10;
            }
            n = newN;
        }

        return true;
    }
}
