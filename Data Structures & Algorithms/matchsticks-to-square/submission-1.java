/*
Alright what is square. A square is a shape with 4 equal sides.
I think this a DP problem simply because we need to know how many 
total/4 - 1 can make and so on, then we can compare to the matchsticks and keep building off of that
*/
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int match : matchsticks) {
            total += match;
        }
        if (total % 4 != 0) return false;
        int side = total / 4;
        int[] buckets = new int[4];
        
        Arrays.sort(matchsticks);

        return search(matchsticks, buckets, side, matchsticks.length - 1);
    }

    private boolean search(int[] matchsticks, int[] buckets, int side, int i) {
        if (i == -1) {
            return true;
        }
    
        //Try each bucket
        for (int j = 0; j < 4; j++) {
            buckets[j] += matchsticks[i];
            if (buckets[j] <= side && search(matchsticks, buckets, side, i - 1)) {
                return true;
            }
            buckets[j] -= matchsticks[i];
            
            if (buckets[j] == 0) {
                break;
            }
        }

        return false;
    }
}