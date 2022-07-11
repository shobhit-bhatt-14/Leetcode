class MinStack {
    public Stack<Integer> original, temp;

    public MinStack() {
        original = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int val) {
        original.push(val);

        if (temp.empty() || temp.peek().intValue() >= val)
            temp.push(val);
    }

    public void pop() {
        if (!original.empty()) {
            if (original.peek().intValue() == temp.peek().intValue())
                temp.pop();

            original.pop();
        }
    }

    public int top() {
        return original.peek();
    }

    public int getMin() {
        return temp.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */