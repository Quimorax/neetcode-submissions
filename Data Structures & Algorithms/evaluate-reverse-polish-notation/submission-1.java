class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();

                int result = switch (token) {
                    case "+" -> firstOperand + secondOperand;
                    case "-" -> firstOperand - secondOperand;
                    case "*" -> firstOperand * secondOperand;
                    default -> firstOperand / secondOperand;
                };
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.length() == 1 && "+-*/".contains(token);
    }
}
