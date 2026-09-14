class MinStack {
    private Deque<Integer> items;

    public MinStack() {
        items = new ArrayDeque<>();
    }

    public void push(int val) {
        items.push(val);
    }

    public void pop() {
        items.pop();
    }

    public int top() {
        return items.getFirst();
    }

    public int getMin() {
        int minValue = Integer.MAX_VALUE;

        for (int value : items) {
            if (value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }
}
