class MinStack {

    private Deque<Integer>  stack;
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int min = stack.peek();
        for (int x : stack) {
            if (x < min) { 
                min = x;
            }
        }
        return min;
    }
}
