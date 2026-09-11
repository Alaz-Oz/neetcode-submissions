class Solution {
    public int maxArea(int[] heights) {
        
        int maxArea = 0;

        for(int left = 0, right = heights.length - 1; left < right;){
            int dist = right - left;
            int minSide = 0;
            if (heights[left] < heights[right]){
                minSide = heights[left];
                left++; // In search of larger
            }else {
                minSide = heights[right];
                right--;
            }
            
            maxArea = Math.max(maxArea, dist * minSide);
        }
        return maxArea;
    }
}
