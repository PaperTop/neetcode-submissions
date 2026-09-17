class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] res = new int[tasks.length];
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> {
                if (a[1] != b[1]) { return Integer.compare(a[1], b[1]);}
                return Integer.compare(a[2], b[2]);
                }
        );
        PriorityQueue<int[]> loading = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            loading.offer(new int[]{task[0], task[1], i});
        }

        int time = 0;
        int i = 0;
        while (!available.isEmpty() || !loading.isEmpty()) {
            //Check if need to add anything from loading
            if (available.isEmpty() && !loading.isEmpty()) {
                time = Math.max(time, loading.peek()[0]);
            }
            while (!loading.isEmpty() && loading.peek()[0] <= time) {
                available.offer(loading.poll());
            }

            //Process the first item in loading
            int[] task = available.poll();
            time += task[1]; //Add processing time
            res[i] = task[2]; //add to res
            i++;
        }


        return res;
    }
}