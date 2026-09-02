//Sort first O(logn) space of O(n);
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        Arrays.sort(hand);
        for (int num : hand) {
            if (map.get(num) > 0) {
                for (int i = num; i < num + groupSize; i++) {
                    if (map.getOrDefault(i, 0) == 0) {
                        return false;
                    } else {
                        map.put(i, map.get(i) - 1);
                    }
                }
            }
        }

        return true;
    }
}
