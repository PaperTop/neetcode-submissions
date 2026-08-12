class KthLargest {

    private int k;
    private List<Integer> arr = new ArrayList<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            arr.add(num);
        }
    }
    
    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);

        return arr.get(arr.size() - k);
    }
}
