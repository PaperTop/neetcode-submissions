class TimeMap {

    private HashMap<String, List<String>> map;
    private HashMap<String, List<Integer>> bucket;
    public TimeMap() {
        map = new HashMap<>();
        bucket = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            List<String> values = new ArrayList<>();
            List<Integer> timestamps = new ArrayList<>();
            values.add(value);
            timestamps.add(timestamp);
            map.put(key, values);
            bucket.put(key, timestamps);
        }
        else {
            map.get(key).add(value);
            bucket.get(key).add(timestamp);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!bucket.containsKey(key)) {
            return "";
        }
        int max = -1;
        int l = 0;
        int r = bucket.get(key).size() - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (bucket.get(key).get(m) < timestamp) {
                max = m;
                l = m + 1; 
            }
            else if (bucket.get(key).get(m) > timestamp){
                r = m - 1;
            }
            else {
                return map.get(key).get(m);
            }
        }
        if (max == -1) {
            return "";
        }
        return map.get(key).get(max);
    }
}
