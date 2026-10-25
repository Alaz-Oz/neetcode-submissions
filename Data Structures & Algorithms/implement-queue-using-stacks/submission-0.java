class MyQueue {

    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();

    public MyQueue() {
    }
    
    public void push(int x) {
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }
    
    public int pop() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
    
    public int peek() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */