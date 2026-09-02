class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> open = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char l = s.charAt(i);
            if (l == '(') {
                open.push(i);
            } else if (l == '*') {
                star.push(i);
            } else if (l == ')') {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while (!open.isEmpty()) {
            if (star.isEmpty()) {
                return false;
            }
            if (star.peek() > open.peek()) {
                open.pop();
            }
            star.pop();
        }

        return true;
    }
}
