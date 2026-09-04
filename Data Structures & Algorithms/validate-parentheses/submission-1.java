class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        String brackets = "([{}])";
        for(char c : s.toCharArray()){
            int bracket = brackets.indexOf(c);
            if (bracket < 3){
                // opening
                stack.offerLast(c);
                continue;
            }
            if (stack.isEmpty()) return false;
            char p = stack.pollLast();
            if (brackets.charAt(5 - bracket) != p) return false;
        }

        return stack.isEmpty();
    }
}
