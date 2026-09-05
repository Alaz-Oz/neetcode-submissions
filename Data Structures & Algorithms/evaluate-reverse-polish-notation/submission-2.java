class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < tokens.length; i++){
            int a, b, result = 0;
            switch (tokens[i]){
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    result = a + b;
                    stack.push(result);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    result = a - b;
                    stack.push(result);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    result = a * b;
                    stack.push(result);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    result = a / b;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
