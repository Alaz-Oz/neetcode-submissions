class Solution {

    public Set<List<Integer>> twoSum(int[] nums, int startIndex, int target){
        int left = startIndex, right = nums.length - 1;

        Set<List<Integer>> result = new HashSet<>();
        
        while(left < right){
            int sum = nums[left] + nums[right];

            if (sum == target) {
                var res = new ArrayList<Integer>();
                res.add(nums[left]);
                res.add(nums[right]);
                result.add(res);

                left++; // Move to find other combinations too
            }
            else if (sum < target) left++;
            else right--;
        }

        return result;
    }


    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        // int prev = nums[0];
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int curFirst = nums[i];

            if (i != 0 && nums[i - 1] == curFirst) continue; // Duplicate

            Set<List<Integer>> res = twoSum(nums, i + 1, -curFirst);

            for(var list : res){
                list.add(curFirst);
                result.add(list);
            }

        }

        return result;

    }
}
