class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freqMap = new int[2001];
        for(int i = 0; i < nums.length; i++){
            freqMap[nums[i] + 1000]++;
        }

        Map<Integer, List<Integer>> reverseMapping = new TreeMap<>(Collections.reverseOrder());

        for(int i = 0; i < 2001; i++){
            int freq = freqMap[i];
            int num = i - 1000;
            if (freq == 0) continue;

            if (reverseMapping.get(freq) == null){
                reverseMapping.put(freq, new ArrayList<>());
            }
            reverseMapping.get(freq).add(num);
        }
        System.out.println(reverseMapping);
        int[] result = new int[k];
        int i = 0;
        for(int key : reverseMapping.keySet()){
            for(int j : reverseMapping.get(key)){
                if (i >= k) return result;
                result[i++] = j;
            }
        }
        
        return result;
    }
}
