class TimeMap {

    Map<String, Map<Integer, String>> map;
    // List<String> data;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Map<Integer, String> timestamped = map.getOrDefault(key, new TreeMap<>());
        timestamped.put(timestamp, value);
        map.put(key, timestamped);
    }
    
    public String get(String key, int timestamp) {
        Map<Integer, String> timestamped = map.get(key);
        if (timestamped == null) return "";

        List<Integer> keys = new ArrayList<>(timestamped.keySet());

        int dataIndex = find(keys, timestamp);

        return dataIndex == -1? "" : timestamped.get(keys.get(dataIndex));
    }

    int find(List<Integer> arr, int target){
        int left = 0, right = arr.size() - 1;
        int mid = 0;

        while(left <= right){
            mid = left + (right - left) / 2;

            if (arr.get(mid) == target){
                return mid;
            }
            if (target < arr.get(mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        if (arr.get(mid) > target) return mid - 1;

        return mid;
    }
}
