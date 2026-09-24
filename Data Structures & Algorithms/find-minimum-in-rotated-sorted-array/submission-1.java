class Solution {
    public int findMin(int[] nums) {
        /**
            finding in log(n) means binary search
            But how?

            left, mid, right

            6 1 2 3 4 5

            if (left < right) // Straight array, left is the ans!


            if (left < mid) left = mid // Climb up the hill
            if (left > mid) right = mid // Climb down the hill

        */

        int left = 0, right = nums.length - 1;

        while(left < right){
            if (nums[left] < nums[right]) return nums[left];
            int mid = left + (right - left) / 2;
            
            if (nums[left] < nums[mid]) left = mid;
            if (nums[left] > nums[mid]) right = mid;

            if (right - left == 1) break;

        }

        return nums[right];
    }
}
