class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> seen = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            seen.add(nums[i]);
        }
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if (seen.contains(cur - 1)) continue;
            int length = 1;
            // Starting node
            while(seen.contains(cur + 1)){
                length++;
                cur++;
            }

            max = Math.max(length, max);
        }

        return max;

    }
}
