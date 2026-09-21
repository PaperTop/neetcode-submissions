class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> 
            Math.abs(a - x) == Math.abs(b - x) ? 
                Integer.compare(a, b) : 
                Integer.compare(Math.abs(a - x), Math.abs(b - x)));

        for (int n : arr) {
            minHeap.offer(n);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            res.add(minHeap.poll());
        }

        Collections.sort(res);
        
        return res;
    }
}