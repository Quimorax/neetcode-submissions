class Solution {
    public boolean isValid(String s) {
        Deque<Character> openBraces = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);

            if (isOpenBracket(bracket)) {
                openBraces.push(bracket);
            } else {
                if (openBraces.isEmpty()) {
                    return false;
                }
                char lastBracket = openBraces.pop();
                if (!haveSameBracketType(lastBracket, bracket)) {
                    return false;
                }
            }
        }

        return openBraces.isEmpty();
    }

    private boolean isOpenBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }

    private boolean haveSameBracketType(char firstBracket, char secondBracket) {
        return (firstBracket == '(' && secondBracket == ')') ||
                (firstBracket == '{' && secondBracket == '}') ||
                (firstBracket == '[' && secondBracket == ']');
    }
}
