class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStore;
    

    public MinStack() {
        stack = new ArrayDeque<>();
        minStore = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        int min = val;
        if (minStore.peek() != null){
            min = Math.min(minStore.peek(), min);
        }
        minStore.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStore.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStore.peek();
    }
}
