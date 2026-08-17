class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : counts) {
            if (count != 0) {
                maxHeap.offer(count);
            }
        }

        Queue<int[]> cooldown = new ArrayDeque<>();
        int cycle = 0;
        
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            if (!cooldown.isEmpty() && cooldown.peek()[1] == cycle) {
                maxHeap.offer(cooldown.poll()[0]);
            }

            if (maxHeap.isEmpty()) {
                cycle++;
                continue;
            }

            if (maxHeap.peek() > 1) {
                cooldown.offer(new int[] {maxHeap.peek() - 1, cycle + n + 1});
            }
            
            maxHeap.poll();
            cycle++;
        }

        return cycle;
    }
}
