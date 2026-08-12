//Copying solution for bucket
class Solution {
    public int lastStoneWeight(int[] stones) {
        int maxStone = 0;
        for (int stone : stones) {
            maxStone = Math.max(maxStone, stone);
        }

        int[] bucket = new int[maxStone + 1];
        for (int stone : stones) {
            bucket[stone]++;
        }

        int first = maxStone, second = maxStone;
        while (first > 0) {
            //Cancel everything in bucket if even count
            if (bucket[first] % 2 == 0) {
                first--;
                continue;
            }

            //If largets bucket is odd, that means there will be 1 remaining, no need to calculate for 3 count, directly look for second largest
            int j = Math.min(first - 1, second);
            while (j > 0 && bucket[j] == 0) {
                j--;
            }

            if (j == 0) {
                return first;
            }

            second = j; //second largest
            bucket[first]--; //decrease first to 0 
            bucket[second]--; //decrease second
            bucket[first - second]++; //add the new rock, guranteed to be non-zero
            first = Math.max(first - second, second); //Move the pointer to the next heaviest stone
        }

        return first;
    }
}
