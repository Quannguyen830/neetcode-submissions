class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> in = new HashMap<>();
        in.put('(', ')');
        in.put('[', ']');
        in.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (in.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || in.get(stack.pop()) != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
