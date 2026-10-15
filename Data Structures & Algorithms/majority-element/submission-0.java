class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i : nums){
            int x = freq.containsKey(i)? freq.get(i) : 0;
            freq.put(i, x + 1);
        }
        
        int maxKey = 0;
        int maxVal = Integer.MIN_VALUE;

        for(var entry : freq.entrySet()){
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
}