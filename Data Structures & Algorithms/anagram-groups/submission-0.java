class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> freqMap = new HashMap<>();

        for(String str : strs){
            char[] signature = str.toCharArray();
            Arrays.sort(signature);
            String sign = new String(signature);
            if (!freqMap.containsKey(sign)){
                freqMap.put(sign, new ArrayList<String>());
            }
            freqMap.get(sign).add(str);
        }
        
        return new ArrayList(freqMap.values());
    }
}
