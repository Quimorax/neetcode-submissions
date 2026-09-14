class MinStack {
    private Deque<Integer> items;
    private Deque<Integer> minItems;

    public MinStack() {
        this.items = new ArrayDeque<>();
        this.minItems = new ArrayDeque<>();
    }
    
    public void push(int val) {
        items.push(val);
        int lastMin = minItems.isEmpty() ? Integer.MAX_VALUE : minItems.peek();
        int min = val < lastMin ? val : lastMin;
        minItems.push(min);
    }
    
    public void pop() {
        items.pop();
        minItems.pop();
    }
    
    public int top() {
        return items.getFirst();
    }
    
    public int getMin() {
        return minItems.peek();
    }
}
