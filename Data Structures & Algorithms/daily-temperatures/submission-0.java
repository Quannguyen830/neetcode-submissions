class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack stack
        // int[] result  
    
        // for temp:
        //     while temp > stack.peek():
        //         int index = stack.pop()
        //         result[index] = temp.index - index; 
            
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int popped_index = stack.pop();
                result[popped_index] = i - popped_index;
            }

            stack.push(i);
        }

        return result;
    }
}
