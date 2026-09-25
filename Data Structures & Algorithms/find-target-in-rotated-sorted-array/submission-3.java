class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        if (nums[left] > nums[right])
        // Find min element;
        while(left < right){
            if (nums[left] < nums[right]) return nums[left];
            int mid = left + (right - left) / 2;
            
            if (nums[left] < nums[mid]) left = mid;
            if (nums[left] > nums[mid]) right = mid;

            if (right - left == 1) break;

        }

        // nums[right];

        System.out.println(right);

        // binary search for both part
        return Math.max(
            binarySearch(nums, 0, right - 1, target),
            binarySearch(nums, right, nums.length - 1, target)
        );
    }

    int binarySearch(int[] nums, int left, int right, int target){
        if (left < 0) return -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return -1;
    }
}
