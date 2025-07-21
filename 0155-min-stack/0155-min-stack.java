import java.util.*;

class MinStack {

    private Stack<Integer> stack;
    private Deque<Integer> deque;

    public MinStack() {
        stack = new Stack<>();
        deque = new ArrayDeque<>();
    }
    
    public void push(int val) {
        // 가장 같거나 작은 값이면 queue 앞에 넣어 준다.

        if(deque.isEmpty()) {
            deque.addFirst(val);
        } else {
            if(val <= deque.peekFirst()) {
                deque.addFirst(val);
            }
        }

        stack.push(val);
    }
    
    public void pop() {
        // deque에서도 삭제 처리를 해줘야한다.
        // System.out.println("pop called");
        // System.out.println("stack.peek() : " + stack.peek() + ", deque.peekFirst() : " + deque.peekFirst());
        // System.out.println();
        if(stack.peek().equals(deque.peekFirst())) {
            // System.out.println("removed deque's data");
            deque.removeFirst();
        }

        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        // System.out.println("getMin called");
        // System.out.println("deque.size() : " + deque.size() + ", deque.peekFirst() : " + deque.peekFirst());
        // System.out.println();

        return deque.peekFirst();        
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