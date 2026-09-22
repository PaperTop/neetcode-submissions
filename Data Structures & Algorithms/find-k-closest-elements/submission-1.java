//maxheap solution
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> 
            Math.abs(a - x) == Math.abs(b - x) ? 
                Integer.compare(b, a) : 
                Integer.compare(Math.abs(b - x), Math.abs(a - x)));

        for (int n : arr) {
            maxHeap.offer(n);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(maxHeap.poll());
        }

        Collections.sort(res);
        
        return res;
    }
}