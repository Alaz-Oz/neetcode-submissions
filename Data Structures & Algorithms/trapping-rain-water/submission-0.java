class Solution {
    public int trap(int[] height) {
        /*
            i, j -> traversing through the array starting from the start
            i -> biggest pillar seen so far
            j -> explorer
            
            if (explorer is below biggest pillar){
                water += biggest pillar - current level;
            }
            if (explorer is at same level or higher than biggest pillar){
                i = j // explorer's position
            }
            
            // When reaching the last, the boundary will have some leakage

            // Moving from back to the front now till the i (last biggest Pillar)
            // excluding the pillar of course

            j is explorer here too
            k -> the local maxima pillar seen from back as iterating
            

            // leaking total water
            water -= biggest pillar - current level

            if (explorer is below local maxima pillar){
                water += maxima pillar - current
            }

            if (explorer at the *same lvl*(doesn't matter here) or higher than maxima pillar){
                k = j // explorer's position
            }

            The water will contain the solution
        */

        int leftBiggestPillarIdx = 0;
        int explorer = 0;

        int water = 0;

        for(explorer = 0; explorer < height.length; explorer++){
            
            if (height[leftBiggestPillarIdx] <= height[explorer]){
                leftBiggestPillarIdx = explorer;
            }else{
                water += height[leftBiggestPillarIdx] - height[explorer];
            }
        }

        int rightBiggestPillarIdx = height.length - 1;

        for(explorer = height.length - 1; explorer > leftBiggestPillarIdx; explorer--){
            water -= height[leftBiggestPillarIdx] - height[explorer];

            if (height[rightBiggestPillarIdx] <= height[explorer]){
                rightBiggestPillarIdx = explorer;
            }else{
                water += height[rightBiggestPillarIdx] - height[explorer];
            }
        }


        return water;
    }
}
