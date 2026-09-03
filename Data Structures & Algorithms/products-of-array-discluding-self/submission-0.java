class Solution {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        int zeroCount = 0;
        int zeroIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                zeroCount++;
                zeroIndex = i;
                continue;
            }
            product *= nums[i];
        }

        int[] result = new int[nums.length];
        if (zeroCount > 1) return result; // all zeros

        if (zeroCount == 1) {
            result[zeroIndex] = (int) product;
        }else {
            for(int i = 0; i < nums.length; i++){
                result[i] = (int) (product / nums[i]);
            }
        }

        return result;
    }
}  
