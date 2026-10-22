class MyStack {
    
    Deque<Integer> queue1 = new ArrayDeque<>();
    Deque<Integer> queue2 = new ArrayDeque<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        var dataQueue = queue1.isEmpty()? queue2 : queue1;
        var otherQueue = queue1.isEmpty()? queue1 : queue2;
        while(true){
            int data = dataQueue.poll();
            if (dataQueue.isEmpty()) return data;
            otherQueue.offer(data);
        }
    }
    
    public int top() {
        var dataQueue = queue1.isEmpty()? queue2 : queue1;
        var otherQueue = queue1.isEmpty()? queue1 : queue2;
        while(true){
            int data = dataQueue.poll();
            otherQueue.offer(data);
            if (dataQueue.isEmpty()) return data;
        }
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */