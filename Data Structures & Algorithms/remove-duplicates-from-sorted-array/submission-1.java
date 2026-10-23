class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        for(left = 1, right = 1; right < nums.length; right++){
            if (nums[right] == nums[right - 1]) continue;
            nums[left++] = nums[right];
        }

        return left;
    }
}