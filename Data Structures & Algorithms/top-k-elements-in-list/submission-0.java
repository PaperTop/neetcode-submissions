class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (counts.containsKey(key)) {
                counts.put(key, counts.get(key) + 1);
            }
            else {
                counts.put(key, 1);
            }
        }

        int[] result = new int[k];
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(counts.entrySet());
        entries.sort((a,b) -> b.getValue() - a.getValue());

        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }
        
        return result;
    }
}
