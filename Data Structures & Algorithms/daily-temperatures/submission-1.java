class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekFirst()] < temperatures[i]) {
                int index = stack.removeFirst();
                result[index] = i - index;
            }

            stack.addFirst(i);
        }

        return result;
    }
}
