class MedianFinder {

    List<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();    
    }
    
    public void addNum(int num) {
        nums.add(num);
        Collections.sort(nums);
    }
    
    public double findMedian() {
        if (nums.size() % 2 == 0) {
            return (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1)) / 2.0;
        }
        return nums.get(nums.size() / 2);
    }
}
