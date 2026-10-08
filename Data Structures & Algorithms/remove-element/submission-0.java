class Solution {
    public int removeElement(int[] nums, int val) {
        
        for(int j = 0; j < nums.length; j++) {
            for(int i = 0; i < nums.length - 1; i++){
                if (nums[i] == val){
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }

        int k = 0;
        for(int i = nums.length - 1; i >= 0 && nums[i] == val; i--){
            k++;
        }

        return nums.length - k;
    }
}