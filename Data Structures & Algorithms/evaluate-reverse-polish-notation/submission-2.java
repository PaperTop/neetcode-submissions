class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if (s.equals("-")) {
                int num = stack.pop();
                int total = stack.pop();
                stack.push(total - num);
            }
            else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if (s.equals("/")) {
                int num = stack.pop();
                int total = stack.pop();
                stack.push(total / num);
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
