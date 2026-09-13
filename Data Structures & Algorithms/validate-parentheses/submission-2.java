class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> closedBrackets = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);

            if (bracket == '(') {
                closedBrackets.push(')');
            } else if (bracket == '{') {
                closedBrackets.push('}'); 
            } else if (bracket == '[') {
                closedBrackets.push(']');
            } else if (closedBrackets.isEmpty() || closedBrackets.pop() != bracket) {
                return false;
            }
        }
        return closedBrackets.isEmpty();
    }
}
