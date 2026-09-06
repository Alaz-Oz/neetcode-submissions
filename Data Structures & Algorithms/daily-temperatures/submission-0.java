class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
            # Observation
            It is something like braces, which opens first closes last.
            Same pattern is there in numbers. The numbers in between the ith day and i lies in between only. Hinting Stack behavior.

            # Idea
            Move across the array.
            Push current element is greater than the top in array. Current index goes for the element in the index.
            If the 
        */

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while (stack.peek() != null && temperatures[i] > temperatures[stack.peek()]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
            }
            stack.push(i);
        }

        return result;
    }
}
