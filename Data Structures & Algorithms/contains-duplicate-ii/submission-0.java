class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();


        for(int right = 0, left = 0; right < nums.length; right++){
            if (right - left > k) {
                set.remove(nums[left]);
                left++;
            }

            boolean success = set.add(nums[right]);
            
            if (!success) return true;

        }

        return false;
    }
}