class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer[]> stack = new ArrayDeque<>(); // stores idx
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            if (stack.isEmpty()){
                stack.push(new Integer[] {i, heights[i]});
                continue;
            }
            
            // int indexAtTop = stack.peek();
            // int valueAtTop = heights[indexAtTop];
            int indexAtTop = stack.peek()[0];
            int valueAtTop = stack.peek()[1];
            int curValue = heights[i];
            int idx = i;

            while(curValue < valueAtTop){
                int dist = i - indexAtTop;
                maxArea = Math.max(maxArea, dist * valueAtTop);
                idx = indexAtTop;

                System.out.println("Found: " + valueAtTop + " from " + indexAtTop);

                stack.pop();
                if (stack.isEmpty()) {
                    valueAtTop = -1;
                    break;
                }

                // indexAtTop = stack.peek();
                // valueAtTop = heights[indexAtTop];
                indexAtTop = stack.peek()[0];
                valueAtTop = stack.peek()[1];
            }

            if (curValue > valueAtTop){
                // stack.push(i);
                System.out.println("Putting " + curValue + " from " + indexAtTop);

                stack.push(new Integer[]{idx, curValue});
            }
        }

        while(!stack.isEmpty()){
            // int indexAtTop = stack.pop();
            // int valueAtTop = heights[indexAtTop];
            Integer[] elem = stack.pop();
            int indexAtTop = elem[0];
            int valueAtTop = elem[1];
            int dist = heights.length - indexAtTop;
            maxArea = Math.max(maxArea, dist * valueAtTop);
        }

        return maxArea;
    }
}
