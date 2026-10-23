class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0, prev = nums[0];
        for(left = 1, right = 0; right < nums.length; right++){
            if (nums[right] == prev) continue;
            nums[left++] = nums[right];
            prev = nums[right];
        }

        return left;
    }
}