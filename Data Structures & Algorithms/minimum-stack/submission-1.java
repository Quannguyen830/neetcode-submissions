class MinStack {
    private Stack<Integer> stack;
    private int min;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        min = Math.min(min, val);
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        if (minStack.isEmpty()) min = Integer.MAX_VALUE;
        else min = minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
